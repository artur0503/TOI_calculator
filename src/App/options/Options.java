package App.options;

import App.core.classes.model.POJO.Data;

import java.util.LinkedList;

/**
 * Created by Arthur 31.01.2018 14:19.
 */
public class Options {

    public LinkedList<Data> optionAlphabet(){
        LinkedList<Data> magic = new LinkedList<>();
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
        return magic;
    }

    public LinkedList<Data> option1(){
        LinkedList<Data> magic = new LinkedList<>();
        magic.add(new Data(0.5, "T", 1));
        magic.add(new Data(0.1, "R", 2));
        magic.add(new Data(0.2, "A", 3));
        magic.add(new Data(0.1, "B", 4));
        magic.add(new Data(0.1, "_", 5));
        return magic;
    }

    public LinkedList<Data> option2(){
        LinkedList<Data> magic = new LinkedList<>();
        magic.add(new Data(0.3, "A", 1));
        magic.add(new Data(0.2, "B", 2));
        magic.add(new Data(0.15, "C", 3));
        magic.add(new Data(0.1, "D", 4));
        magic.add(new Data(0.1, "E", 5));
        magic.add(new Data(0.1, "F", 6));
        magic.add(new Data(0.05, "G", 7));
        return magic;
    }

}
