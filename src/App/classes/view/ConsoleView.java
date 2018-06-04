package App.classes.view;

import App.interfaces.controller.Controller;
import App.classes.controller.ControllerHuffman;
import App.classes.controller.ControllerShenon;
import App.classes.model.POJO.Data;
import App.interfaces.view.View;
import Testing.Test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Arthur 31.01.2018 15:59.
 */
public class ConsoleView implements View {

    private LinkedList<Data> list;

    private Scanner sc = new Scanner(System.in);
    /**MAIN METHOD**/
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1 Ввод частот");
            System.out.println("2 Код Хаффмана");
            System.out.println("3 Код Шенона-Фанно");
            System.out.println("4 Арефметическое кодирование");
            System.out.print("Выберете пункт: ");
            switch (sc.nextInt()){
                case 1:
                    afterAction();
                    break;
                case 2:
                    Controller haf = new ControllerHuffman(getInputData());
                    haf.execute();
                    break;
                case 3:
                    Controller sh = new ControllerShenon(getInputData());
                    sh.execute();
                    break;
                case 4:

                    break;
            }
        }
    }

    /**ACTION AFTER USE BUTTON**/
    @Override
    public void afterAction(){
        //введенные данные которые получили после нажатия кнопки
        LinkedList<Data> linkedList = new LinkedList<>();
//        new Test().testRandom(linkedList);
        new Test().test0(linkedList);

        double sum = 0;
        for (int i = 0; i < linkedList.size(); i++) {
            sum = linkedList.get(i).getChance() + sum;
        }
        System.out.println(sum);

//        int k = 0;
//        System.out.println("Введите элемент и частоту(через пробел)");
//        while (true){
//            String s1 = sc.nextLine();
//            if (s1.equals("0")) break;
//            String s[] = s1.split(" ");
//            linkedList.add(new Data(Double.parseDouble(s[1]) * 100, s[0], k++));
//        }
        setInputData(linkedList);
    }

    @Override
    public void setInputData(LinkedList<Data> list) {
        this.list = list;
    }

    @Override
    public LinkedList getInputData() {
        return list;
    }
}
