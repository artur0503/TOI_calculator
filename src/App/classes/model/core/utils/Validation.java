package App.classes.model.core.utils;

import App.classes.model.POJO.Data;

import java.util.LinkedList;

public class Validation {

    private LinkedList<Data> list;

    public Validation(LinkedList<Data> list) {
        this.list = list;
    }

    private boolean checkNotNull(){
        return (list != null);
    }

    private boolean checkSize(){
        if (checkNotNull())
            return !(list.size() > 0);
        else
            return false;
    }

    public boolean checkSum(){
        if (checkSize())
            return !(sum(list) != 100);
        else
            return false;
    }

    private double sum(LinkedList<Data> list){
        double sum = 0;
        for (Data aList : list) {
            sum = sum + aList.getChance();
        }
        System.out.println(sum);
        return sum;
    }

}
