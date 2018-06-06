package App.classes.controller.coding;

import App.classes.model.POJO.Data;
import App.classes.model.core.coding.Arithmetic;
import App.interfaces.controller.ControllerCoding;
import App.interfaces.model.coding.ModelCodingArithmetic;

import java.util.LinkedList;

public class ArithmeticController implements ControllerCoding {

    private LinkedList<Data> inputData;
    private String text;

    public ArithmeticController(LinkedList<Data> inputData) {
        this.inputData = inputData;
    }

    @Override
    public LinkedList<Data> getDataFromView() {
        return inputData;
    }

    @Override
    public LinkedList<Data> getCodeToDraw() {
        return null;
    }

    @Override
    public LinkedList<LinkedList<Data>> getDataToDraw() {
        return null;
    }

    public void setTextForCoding(String text){
        this.text = text;
    }

    @Override
    public void execute() {
        ModelCodingArithmetic magic = new Arithmetic();
        magic.create(getDataFromView());
        magic.textForCoding(text);
        if (magic.check()) {
            magic.coding();
            magic.showConsole();
            System.out.println("Результат: " + magic.resultCode());
        }
    }
}
