package App.core.classes.model.logic.coding;

import App.core.classes.model.POJO.Data;
import App.core.classes.model.comparator.huffmanComp.DataComparatorUp;
import App.core.interfaces.model.coding.ModelCodingArithmetic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class Arithmetic implements ModelCodingArithmetic {

    private LinkedList<Data> list;
    private LinkedList<Data> resList;
    private double resCode;
    private String text;

    @Override
    public LinkedList<Data> dataForDrawing() {
        return listWithInterval();
    }

    @Override
    public LinkedList<Data> dataResult() {
        return resList;
    }

    @Override
    public void create(LinkedList<Data> list) {
        this.list = list;
    }

    @Override
    public void textForCoding(String text) {
        this.text = text;
    }

    @Override
    public double resultCode() {
        return resCode;
    }

    @Override
    public void showConsole() {
        resList.sort(new DataComparatorUp());
        for (Data data : resList) {
            System.out.println(data.getNameS()
                    + " (" + data.getChance() + ")"
                    + " (" + data.getInterval()[0] + " - " + data.getInterval()[1] + ")"
                    + "\n  H = " + new DecimalFormat("###,###.##############").format(data.getCodeArithm()[0]) + ";"
                    + "\n  K = " + new DecimalFormat("###,###.##############").format(data.getCodeArithm()[1])+ ";");
        }
    }

    @Override
    public boolean check() {
        int count = 0;
        LinkedList<Data> list = giveInterval();
        for (String str : getTextArray()) {
            for (Data aData : list) {
                if (str.equals(aData.getNameS())) {
                    count++;
                    break;
                }
            }
        }
        return count == getTextArray().length;
    }

    @Override
    public void coding() {
        LinkedList<Data> listText = new LinkedList<>();
        LinkedList<Data> listElement = giveInterval();
        double h = 0;
        double k = 0;
        int count = 0;
        try {
            for (String str : getTextArray()) {
                for (Data aData : listElement) {
                    String s = aData.getNameS();
                    if (s.equals(str)) {
                        if (k == 0) {
                            h = aData.getInterval()[0];
                            k = aData.getInterval()[1];
                        } else {
                            double h1 = h;
                            double k1 = k;
                            h = h1 + aData.getInterval()[0] * (k1 - h1);
                            k = h1 + aData.getInterval()[1] * (k1 - h1);
                        }
                        h = new BigDecimal(h).setScale(32, RoundingMode.HALF_UP).doubleValue();
                        k = new BigDecimal(k).setScale(32, RoundingMode.HALF_UP).doubleValue();
                        aData.setCodeArithm(new double[]{h, k});
                        listText.add(new Data(aData.getChance(),
                                aData.getNameS(),
                                aData.getCodeArithm(),
                                aData.getInterval(),
                                count++)
                        );
                    }
                }
            }
            double res = (listText.getLast().getCodeArithm()[0] + listText.getLast().getCodeArithm()[1]) / 2;
            res = new BigDecimal(res).setScale(32, RoundingMode.HALF_UP).doubleValue();
            setResList(listText);
            setResCode(res);
        } catch (Exception e){
            setResCode(0);
            System.out.println("###ERROR###");
        }
    }

    private LinkedList<Data> listWithInterval(){
        return giveInterval();
    }

    private LinkedList<Data> giveInterval(){
        LinkedList<Data> list = this.list;
        double begin;
        double end = 1;
        for (Data aList : list) {
            begin = end - aList.getChance();
            begin = new BigDecimal(begin).setScale(10, RoundingMode.HALF_UP).doubleValue();
            aList.setInterval(new double[]{begin, end});
            end = begin;
        }
        return list;
    }

    private void setResList(LinkedList<Data> resList) {
        this.resList = resList;
    }

    private void setResCode(double resCode) {
        this.resCode = resCode;
    }

    private String[] getTextArray(){
        return text.split("");
    }
}
