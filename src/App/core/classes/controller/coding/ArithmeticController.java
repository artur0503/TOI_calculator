package App.core.classes.controller.coding;

import App.core.classes.model.models.Data;
import App.core.classes.model.logic.coding.Arithmetic;
import App.core.interfaces.controller.ControllerCoding;
import App.core.interfaces.model.coding.ModelCodingArithmetic;

import java.util.LinkedList;

public class ArithmeticController implements ControllerCoding {

    private String text;
    private LinkedList<Data> inputData;
    private LinkedList<Data> resCode;
    private LinkedList<Data> drawData;
    private double res;

    public ArithmeticController(LinkedList<Data> inputData) {
        this.inputData = inputData;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String getText() {
        return text;
    }

    private LinkedList<Data> getInputData() {
        return inputData;
    }

    private LinkedList<Data> getResCode() {
        return resCode;
    }

    private void setResCode(LinkedList<Data> resCode) {
        this.resCode = resCode;
    }

    private LinkedList<Data> getDrawData() {
        return drawData;
    }

    private void setDrawData(LinkedList<Data> drawData) {
        this.drawData = drawData;
    }

    public double getRes() {
        return res;
    }

    private void setRes(double res) {
        this.res = res;
    }

    @Override
    public LinkedList<Data> getDataFromView() {
        return getInputData();
    }

    @Override
    public LinkedList<Data> getCodeToDraw() {
        return getResCode();
    }

    @Override
    public LinkedList<String[]> getDataToDraw() {
        return null;
    }

    public LinkedList<Data> getDataToDrawArithm() {
        return getDrawData();
    }

    @Override
    public void execute() {
        ModelCodingArithmetic magic = new Arithmetic();
        magic.create(getDataFromView());
        magic.textForCoding(getText());
        if (magic.check()) {
            magic.coding();
            magic.showConsole();
            setResCode(magic.dataResult());
            setDrawData(magic.dataForDrawingArithm());
            setRes(magic.resultCode());
        }
        else {
            setRes(-1);
        }
    }
}
