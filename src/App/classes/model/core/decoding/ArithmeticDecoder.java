package App.classes.model.core.decoding;

import App.classes.model.POJO.Data;
import App.interfaces.model.decoding.ModelDecodingArithmetic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class ArithmeticDecoder implements ModelDecodingArithmetic {

    private double textDouble;
    private int count;
    private LinkedList<Data> code;
    private String res = "";

    public ArithmeticDecoder(double textDouble, int count, LinkedList<Data> code) {
        this.textDouble = textDouble;
        this.count = count;
        this.code = code;
    }

    private LinkedList<Data> giveInterval(LinkedList<Data> code){
        double begin;
        double end = 1;
        for (Data aList : code) {
            begin = end - aList.getChance();
            begin = new BigDecimal(begin).setScale(10, RoundingMode.HALF_UP).doubleValue();
            aList.setInterval(new double[]{begin, end});
            end = begin;
        }
        return code;
    }

    @Override
    public void decoding() {
        LinkedList<Data> code = giveInterval(this.code);
        a:for (int i = 0; i < count; i++){
            double textDouble = this.textDouble;
            for (Data aCode : code) {
                if (res.split("").length == count)
                    break a;
                if (res.equals("")) {
                    if (textDouble > aCode.getInterval()[0] & textDouble <= aCode.getInterval()[1]) {
                        res = res + aCode.getNameS();
                        textDouble = (textDouble - aCode.getInterval()[0]) / aCode.getChance();
                        textDouble = new BigDecimal(textDouble).setScale(10, RoundingMode.HALF_UP).doubleValue();
                        this.textDouble = textDouble;
                        break;
                    }
                } else {
                    double h = aCode.getInterval()[0];
                    double k = aCode.getInterval()[1];
                    if (textDouble > h & textDouble <= k) {
                        res = res + aCode.getNameS();
                        textDouble = (textDouble - aCode.getInterval()[0]) / aCode.getChance();
                        textDouble = new BigDecimal(textDouble).setScale(10, RoundingMode.HALF_UP).doubleValue();
                        this.textDouble = textDouble;
                    }
                }
            }
        }
    }

    @Override
    public String getResult() {
        return res;
    }
}
