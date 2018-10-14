package App.core.classes.model.logic.formulas;

import App.core.classes.model.models.Data;
import App.core.interfaces.model.formulas.ModelFormulas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class Formulas implements ModelFormulas {

    private LinkedList<Data> list;

    public Formulas(LinkedList<Data> list) {
        this.list = list;
    }

    public LinkedList<Data> getList() {
        return list;
    }

    @Override
    public int getCountMessage() {
        return findCountMessage(getList());
    }

    @Override
    public double getEntropy() {
        return findEntropy(getList());
    }

    @Override
    public double getMaxEntropy() {
        return findMaxEntropy(getList());
    }

    @Override
    public double getAverageLength() {
        return findAverageLength(getList());
    }

    @Override
    public double getRedundancy() {
        return findRedundancy(getEntropy(), getMaxEntropy());
    }


    private int findCountMessage(LinkedList<Data> list){
        return list.size();
    }

    private double findMaxEntropy(LinkedList<Data> list){

        double N = list.size();

        double q = new BigDecimal(1 / N)
                .setScale(4, RoundingMode.HALF_UP)
                .doubleValue();

        double exp = (-1 * N) * ( q * Math.log(q));

        return new BigDecimal(exp)
                .setScale(4, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private double findEntropy(LinkedList<Data> list){

        double exp = list.size();
        //TODO:УТОЧНИТЬ
        return new BigDecimal(exp)
                .setScale(4, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private double findAverageLength(LinkedList<Data> list){
        int sum = 0;
        for (Data data : list){
            sum = sum + data.getCodeBinary().split("").length;
        }

        double exp = sum / list.size();////нахождение средего

        return new BigDecimal(exp)
                .setScale(4, RoundingMode.HALF_UP)
                .doubleValue();

    }

    private double findRedundancy(double entropy, double maxEntropy){
        return new BigDecimal((maxEntropy - entropy) / maxEntropy)
                .setScale(4, RoundingMode.HALF_UP)
                .doubleValue();
    }

}
