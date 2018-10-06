package App.core.classes.view;

import App.core.classes.controller.coding.ArithmeticController;
import App.core.classes.controller.coding.HuffmanController;
import App.core.classes.controller.coding.ShenonController;
import App.core.classes.controller.decoding.ArithmeticDecoderController;
import App.core.classes.controller.decoding.BinaryTextDecoderController;
import App.core.classes.controller.formulas.FormulasController;
import App.core.classes.model.POJO.Data;
import App.core.interfaces.controller.ControllerCoding;
import App.core.interfaces.controller.ControllerDecoding;
import App.core.interfaces.controller.ControllerFormulas;
import App.core.interfaces.view.BaseView;
import App.options.Options;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Arthur 31.01.2018 15:59.
 */
public class ConsoleView implements BaseView {

    private LinkedList<Data> userList;

    /**MAIN METHOD**/
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        mainMenu(sc);
    }

    /**ACTION AFTER USE BUTTON**/
    @Override
    public void afterAction(){
        LinkedList<Data> linkedList = new Options().option1();
        setInputData(linkedList);
    }

    private void mainMenu(Scanner sc){
        a:while (true) {
            System.out.println("МЕНЮ\n1) Ввод частот");
            System.out.println("2) Код Хаффмана");
            System.out.println("3) Код Шенона-Фанно");
            System.out.println("4) Арефметическое кодирование");
            System.out.println("5) Выйти");

            System.out.print("Выберете пункт: ");
            switch (sc.nextInt()){
                case 1:
                    System.out.println("\nВвод данных: ");
                    afterAction();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\n  КОДИРОВАНИЕ ХАФМАНА ");
                    if (getInputData() != null) {
                        ControllerCoding huffman = new HuffmanController(transportList());
                        huffman.execute();
                        ControllerFormulas formulas = new FormulasController(huffman.getCodeToDraw());
                        formulas.execute();
                        System.out.println(" N - " + formulas.resCountMessage()
                                + "\n E - " + formulas.resEntropy()
                                + "\n Emax - " + formulas.resMaxEntropy()
                                + "\n Mav - " + formulas.resAverageLength()
                                + "\n R - " + formulas.resRedundancy()
                        );
                        binaryDecodingMenu(sc, huffman);
                    } else
                        System.out.println("###ERROR###\n" + "Введите элементы");
                    break;
                case 3:
                    System.out.println("\n  КОДИРОВАНИЕ ШЕНОНА-ФАНО ");
                    if (getInputData() != null){
                        ControllerCoding shanon = new ShenonController(transportList());
                        shanon.execute();
                        ControllerFormulas formulas = new FormulasController(shanon.getCodeToDraw());
                        formulas.execute();
                        System.out.println(" N - " + formulas.resCountMessage()
                                + "\n E - " + formulas.resEntropy()
                                + "\n Emax - " + formulas.resMaxEntropy()
                                + "\n Mav - " + formulas.resAverageLength()
                                + "\n R - " + formulas.resRedundancy()
                        );
                    binaryDecodingMenu(sc, shanon);
                    } else
                        System.out.println("###ERROR###\n" + "Введите элементы");
            break;
                case 4:
                    if (getInputData() != null)
                        arithmeticMenu(sc);
                    break;
                case 5:
                    break a;
            }
        }
    }

    private void binaryDecodingMenu(Scanner sc1, ControllerCoding cc){
        Scanner sc2 = new Scanner(System.in);
        a:while (true) {
            System.out.println("\nПроизвести декодирование: \n1) да\n2) нет");
            System.out.print("Выберете пункт: ");
            switch (sc1.nextInt()){
                case 1:
                    System.out.println("Введите строку(пример '10100...'): ");
                    String text = sc2.nextLine();
                    ControllerDecoding decoder = new BinaryTextDecoderController(text, cc.getCodeToDraw());
                    decoder.execute();
                    System.out.println("Результат: " + decoder.getDecodingResult());
                    break;
                case 2:
                    System.out.println();
                    break a;
            }
        }
    }

    private void arithmeticMenu(Scanner sc1){
        a:while (true) {
            System.out.println("\n АРЕФМЕТИЧЕСКОЕ КОДИРОВАНИЕ  ");
            System.out.println("1) Закодировать");
            System.out.println("2) Декодировать");
            System.out.println("3) В Меню");
            System.out.print("Выберете пункт: ");
            switch (sc1.nextInt()) {
                case 1:
                    System.out.print("Введите строку: ");
                    String str = new Scanner(System.in).nextLine();
                    ArithmeticController arithm = new ArithmeticController(transportList());
                    arithm.setText(str);
                    arithm.execute();
                    System.out.println("Результат: " + arithm.getRes());
                    break;
                case 2:
                    try {
                        System.out.print("Введите кол-во элементов: ");
                        int count = new Scanner(System.in).nextInt();
                        System.out.println("Введите строку(пример '0,12345....'): ");
                        double res = new Scanner(System.in).nextDouble();
                        ControllerDecoding decoder = new ArithmeticDecoderController(res, count, transportList());
                        decoder.execute();
                        System.out.println("Результат: " + decoder.getDecodingResult());
                    } catch (Exception e){
                        System.out.println("###ERROR###\n  Неправильные символы");
                    }
                    break;
                case 3:
                    System.out.println();
                    break a;
            }
        }
    }

    private LinkedList<Data> transportList(){
        LinkedList<Data> linkedList = new LinkedList<>();
        if (userList != null)
            linkedList.addAll(userList);
        return linkedList;
    }

    @Override
    public void setInputData(LinkedList<Data> userList) {
        this.userList = userList;
    }

    @Override
    public LinkedList getInputData() {
        return userList;
    }
}

