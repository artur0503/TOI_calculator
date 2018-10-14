package App.core.classes.controller.formulas;

import App.core.classes.model.models.Data;
import App.core.classes.model.logic.formulas.Formulas;
import App.core.interfaces.controller.ControllerFormulas;

import java.util.LinkedList;

public class FormulasController implements ControllerFormulas {
    
    private LinkedList<Data> list;
    
    private int countMess;
    private double entropy;
    private double maxEntropy;
    private double avLength;
    private double redundancy;

    public FormulasController(LinkedList<Data> list) {
        this.list = list;
    }

    private LinkedList<Data> getList() {
        return list;
    }

    private int getCountMess() {
        return countMess;
    }

    private void setCountMess(int countMess) {
        this.countMess = countMess;
    }

    private double getEntropy() {
        return entropy;
    }

    private void setEntropy(double entropy) {
        this.entropy = entropy;
    }

    private double getMaxEntropy() {
        return maxEntropy;
    }

    private void setMaxEntropy(double maxEntropy) {
        this.maxEntropy = maxEntropy;
    }

    private double getAvLength() {
        return avLength;
    }

    private void setAvLength(double avLength) {
        this.avLength = avLength;
    }

    private double getRedundancy() {
        return redundancy;
    }

    private void setRedundancy(double redundancy) {
        this.redundancy = redundancy;
    }

    @Override
    public int resCountMessage() {
        return getCountMess();
    }

    @Override
    public double resEntropy() {
        return getEntropy();
    }

    @Override
    public double resMaxEntropy() {
        return getMaxEntropy();
    }

    @Override
    public double resAverageLength() {
        return getAvLength();
    }

    @Override
    public double resRedundancy() {
        return getRedundancy();
    }

    @Override
    public void execute() {
        Formulas formulas = new Formulas(getList());
        setCountMess(formulas.getCountMessage());
        setMaxEntropy(formulas.getMaxEntropy());
        setEntropy(formulas.getEntropy());
        setAvLength(formulas.getAverageLength());
        setRedundancy(formulas.getRedundancy());
    }
}
