package App.classes.controller.coding;

import App.classes.model.POJO.Data;
import App.classes.model.core.coding.Arithmetic;
import App.interfaces.controller.ControllerCoding;
import App.interfaces.model.coding.ModelCodingArithmetic;

import java.util.LinkedList;

public class ArithmeticController implements ControllerCoding {

    private String text;
    private LinkedList<Data> inputData;
    private LinkedList<Data> resCode;
    private LinkedList<Data> drawData;

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

    @Override
    public LinkedList<Data> getDataFromView() {
        return getInputData();
    }

    @Override
    public LinkedList<Data> getCodeToDraw() {
        return getResCode();
    }

    @Override
    public LinkedList<Data> getDataToDraw() {
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
            setDrawData(magic.dataForDrawing());
            System.out.println("Результат: " + magic.resultCode());
        }
    }
}
