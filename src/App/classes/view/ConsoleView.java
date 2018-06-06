package App.classes.view;

import App.classes.controller.coding.ArithmeticController;
import App.classes.controller.coding.HuffmanController;
import App.classes.controller.coding.ShenonController;
import App.classes.controller.decoding.BinaryDecoderController;
import App.classes.model.POJO.Data;
import App.interfaces.controller.ControllerCoding;
import App.interfaces.view.BaseView;
import Testing.Test;
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
        //введенные данные которые получили после нажатия кнопки

        LinkedList<Data> linkedList = new LinkedList<>();
        new Test().test0(linkedList);
        setInputData(linkedList);
    }

//    private LinkedList<Data> userInput(){
//        LinkedList<Data> linkedList = new LinkedList<>();
//        Scanner sc = new Scanner(System.in);
//        int k = 0;
//        System.out.println("Введите элемент и частоту(через пробел)\nДля заверщения введите '000'");
//        while (true){
//            String s1 = sc.nextLine();
//            if (s1.equals("000")) break;
//            String s[] = s1.split(" ");
//            linkedList.add(new Data(Double.parseDouble(s[1]), s[0], k++));
//        }
//        return linkedList;
//    }

    private void mainMenu(Scanner sc){
        a:while (true) {
            System.out.println("\nМЕНЮ\n1 Ввод частот");
            System.out.println("2 Код Хаффмана");
            System.out.println("3 Код Шенона-Фанно");
            System.out.println("4 Арефметическое кодирование");
            System.out.println("5 Выйти");

            System.out.print("Выберете пункт: ");
            switch (sc.nextInt()){
                case 1:
                    System.out.println();
                    afterAction();
                    break;
                case 2:
                    System.out.println();
                    if (getInputData() != null) {
                        ControllerCoding huffman = new HuffmanController(transportList());
                        huffman.execute();
                        secMenu(sc, huffman);
                    } else
                        System.out.println("###ERROR###\n" +
                                "Введите элементы");
                    break;
                case 3:
                    System.out.println();
                    if (getInputData() != null){
                    ControllerCoding shanon = new ShenonController(transportList());
                    shanon.execute();
                    secMenu(sc, shanon);
                    } else
                        System.out.println("###ERROR###\n" +
                                "Введите элементы");
            break;
                case 4:
                    System.out.println();
                    if (getInputData() != null) {
                        ControllerCoding arithm = new ArithmeticController(transportList());
                        System.out.print("Введите строку: ");
                        String str = new Scanner(System.in).nextLine();
                        ((ArithmeticController) arithm).setTextForCoding(str);
                        arithm.execute();
                    }
                    break;
                case 5:
                    break a;
            }
        }
    }

    private void secMenu(Scanner sc1, ControllerCoding cc){
        Scanner sc2 = new Scanner(System.in);
        a:while (true) {
            System.out.println("\nПроизвести декодирование \n1 да\n2 нет");
            System.out.print("Выберете пункт: ");
            switch (sc1.nextInt()){
                case 1:
                    System.out.println("Введите строку: ");
                    String text = sc2.nextLine();
                    BinaryDecoderController decoder2 = new BinaryDecoderController(text, cc.getCodeToDraw());
                    decoder2.execute();
                    System.out.println("Результат: " + decoder2.getDecodingResult());
                    break;
                case 2:
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

