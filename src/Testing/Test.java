package Testing;

import App.classes.controller.coding.ArithmeticController;
import App.classes.controller.decoding.ArithmeticDecoderController;
import App.classes.model.POJO.Data;
import App.classes.model.core.coding.Arithmetic;
import App.classes.model.core.decoding.ArithmeticDecoder;
import App.interfaces.model.coding.ModelCodingArithmetic;
import App.interfaces.model.decoding.ModelDecoding;
import App.interfaces.model.decoding.ModelDecodingArithmetic;

import java.util.LinkedList;
import java.util.Random;

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
        for (Integer aTest : test) {
            sum = sum + aTest;
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
        magic.add(new Data(0.145, "_", 1));
        magic.add(new Data(0.095, "О", 2));
        magic.add(new Data(0.074, "Е", 3));
        magic.add(new Data(0.064, "А", 4));
        magic.add(new Data(0.062, "И", 5));//тут изменил 6.4->6.2
        magic.add(new Data(0.056, "Т", 6));
        magic.add(new Data(0.056, "Н", 7));
        magic.add(new Data(0.047, "С", 8));
        magic.add(new Data(0.041, "Р", 9));
        magic.add(new Data(0.039, "В", 10));
        magic.add(new Data(0.036, "Л", 11));
        magic.add(new Data(0.029, "К", 12));
        magic.add(new Data(0.026, "М", 13));
        magic.add(new Data(0.026, "Д", 14));
        magic.add(new Data(0.024, "П", 15));
        magic.add(new Data(0.021, "У", 16));
        magic.add(new Data(0.019, "Я", 17));
        magic.add(new Data(0.016, "Ы", 18));
        magic.add(new Data(0.015, "З", 19));
        magic.add(new Data(0.015, "Ь", 20));
        magic.add(new Data(0.015, "Б", 21));
        magic.add(new Data(0.014, "Г", 22));
        magic.add(new Data(0.013, "Ч", 23));
        magic.add(new Data(0.010, "Й", 24));
        magic.add(new Data(0.009, "Х", 25));
        magic.add(new Data(0.008, "Ж", 26));
        magic.add(new Data(0.007, "Ю", 27));
        magic.add(new Data(0.006, "Ш", 28));
        magic.add(new Data(0.004, "Ц", 29));
        magic.add(new Data(0.003, "Щ", 30));
        magic.add(new Data(0.003, "Э", 31));
        magic.add(new Data(0.002, "Ф", 32));
    }

    public void test1(LinkedList<Data> magic){
        magic.add(new Data(0.5, "T", 1));
        magic.add(new Data(0.1, "R", 2));
        magic.add(new Data(0.2, "A", 3));
        magic.add(new Data(0.1, "B", 4));
        magic.add(new Data(0.1, "_", 5));
    }
//
//    public void test2(ModelCoding magic){
//        magic.add(27, "a");
//        magic.add(20, "b");
//        magic.add(15, "c");
//        magic.add(11, "d");
//        magic.add(10, "e");
//        magic.add(9, "f");
//        magic.add(8, "g");
//    }

    public static void main(String[] args) {
        LinkedList<Data> list = new LinkedList<>();
        Test test = new Test();
        test.test1(list);
        int res1 = 0;
        int count = 1000000;
        for (int i = 0; i < count; i++){
           res1 = res1 + test.testForArithm(list);
        }
        System.out.println(res1 / count);
    }

    private int testForArithm(LinkedList<Data> list){
        String text = "";
        int count;
        Random random = new Random();
        count = 100 + (int) (Math.random()*1000);
        for (int j = 0; j < count; j++) {
            text = text + list.get(random.nextInt(list.size()-1)).getNameS();
        }
        count = text.split("").length;
        ArithmeticController coding = new ArithmeticController(list);
        coding.setText(text);
        coding.execute();
        ArithmeticDecoderController arithmetic = new ArithmeticDecoderController(coding.getRes(), count, list);
        arithmetic.execute();
        String[] strArr = text.split("");
        int c = 0;
        count = 0;
        for (String s : arithmetic.getDecodingResult().split("")) {
            if (s.equals(strArr[c])) {
                count++;
            }
            else break;
            c++;
        }
        return count;
    }

}
