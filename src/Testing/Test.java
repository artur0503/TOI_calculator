package Testing;

import App.classes.model.POJO.Data;
import App.interfaces.model.Model;

import java.util.LinkedList;

/**
 * Created by Arthur 31.01.2018 14:19.
 */
public class Test {

    public void testRandom(LinkedList<Data> list){
        LinkedList<Integer> test = new LinkedList<>();
        for (int i = 0; i < (7 + Math.random() * 30 + 10); i++){
            test.add((int) (1 + Math.random() * 30));
        }
        int sum = 0;
        for (int i = 0; i < test.size(); i++) {
            sum = sum + test.get(i);
        }
        if (sum > 100){
            int sum2 = sum;
            while (sum2 > 100) {
                sum2 = sum2 - test.getLast();
                test.remove(test.size()-1);
            }
            if (sum2 < 100){
                test.add(100 - sum2);
            }
            if (sum2 == 100){
                sum = sum2;
            }
        }
        if (sum < 100){
            test.add(100 - sum);
        }
        if (sum == 100){
            System.out.println("ok");
        }

        for (int i = 0; i < test.size(); i++){
            int j = i + 1;
            list.add(new Data(test.get(i), j, i));
//            magic.add(test.get(i), j);
        }
    }

    public void test0(LinkedList<Data> magic){
        magic.add(new Data(14.5, "-", 1));
        magic.add(new Data(9.5, "О", 2));
        magic.add(new Data(7.4, "Е", 3));
        magic.add(new Data(6.4, "А", 4));
        magic.add(new Data(6.2, "И", 5));//тут изменил 6.4->6.2
        magic.add(new Data(5.6, "Т", 6));

        magic.add(new Data(5.6, "Н", 7));
        magic.add(new Data(4.7, "С", 8));
        magic.add(new Data(4.1, "Р", 9));
        magic.add(new Data(3.9, "В", 10));
        magic.add(new Data(3.6, "Л", 11));
        magic.add(new Data(2.9, "К", 12));
        magic.add(new Data(2.6, "М", 13));
        magic.add(new Data(2.6, "Д", 14));
        magic.add(new Data(2.4, "П", 15));
        magic.add(new Data(2.1, "у", 16));
        magic.add(new Data(1.9, "Я", 17));
        magic.add(new Data(1.6, "Ы", 18));
        magic.add(new Data(1.5, "З", 19));
        magic.add(new Data(1.5, "Ь", 20));
        magic.add(new Data(1.5, "Б", 21));
        magic.add(new Data(1.4, "Г", 22));
        magic.add(new Data(1.3, "Ч", 23));
        magic.add(new Data(1.0, "Й", 24));
        magic.add(new Data(0.9, "X", 25));
        magic.add(new Data(0.8, "Ж", 26));
        magic.add(new Data(0.7, "Ю", 27));
        magic.add(new Data(0.6, "Ш", 28));
        magic.add(new Data(0.4, "Ц", 29));
        magic.add(new Data(0.3, "Щ", 30));
        magic.add(new Data(0.3, "Э", 31));
        magic.add(new Data(0.2, "Ф", 32));
//        magic.add(new Data(25, "a", 1));
//        magic.add(new Data(25, "b", 2));
//        magic.add(new Data(25, "c", 3));
//        magic.add(new Data(10, "d", 4));
//        magic.add(new Data(5, "e", 5));
//        magic.add(new Data(5, "f", 6));
//        magic.add(new Data(5, "g", 7));
    }

    public void test1(Model magic){
        magic.add(22, "A");
        magic.add(16, "B");
        magic.add(15, "C");
        magic.add(14, "D");
        magic.add(12, "E");
        magic.add(9, "F");
        magic.add(5, "G");
        magic.add(5, "J");
        magic.add(1, "H");
        magic.add(1, "I");
    }

    public void test2(Model magic){
        magic.add(27, "a");
        magic.add(20, "b");
        magic.add(15, "c");
        magic.add(11, "d");
        magic.add(10, "e");
        magic.add(9, "f");
        magic.add(8, "g");
    }

}
