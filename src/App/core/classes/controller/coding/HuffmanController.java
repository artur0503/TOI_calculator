package App.core.classes.controller.coding;

import App.core.classes.model.models.Data;
import App.core.classes.model.logic.coding.Huffman;
import App.core.classes.model.models.DataDraw;
import App.core.interfaces.controller.ControllerCoding;

import java.util.LinkedList;

public class HuffmanController implements ControllerCoding {

    private LinkedList<Data> inputData;
    private LinkedList<Data> resCode;
    private LinkedList<String[]> drawData;
    private LinkedList<LinkedList<DataDraw>> drawLastSum;

    public HuffmanController(LinkedList<Data> inputData) {
        this.inputData = inputData;
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

    private LinkedList<String[]> getDrawData() {
        return drawData;
    }

    private void setDrawData(LinkedList<String[]> drawData) {
        this.drawData = drawData;
    }

    public LinkedList<LinkedList<DataDraw>> getDrawLastSum() {
        return drawLastSum;
    }

    private void setDrawLastSum(LinkedList<LinkedList<DataDraw>> drawLastSum) {
        this.drawLastSum = drawLastSum;
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
        return getDrawData();
    }

    @Override
    public void execute() {
        Huffman magic = new Huffman();
        if (getDataFromView() != null) {
            magic.create(getDataFromView());
            if (magic.check()) {
                magic.sortCh();
                magic.tree();
                magic.sortCh();
                magic.sortInd();
//                magic.showConsole();
                setDrawLastSum(magic.getLastSum());
                magic.sortCh();
                setResCode(magic.dataResult());
                setDrawData(magic.dataForDrawing());
            }
        } else
            System.out.println("###ERROR###\n SUM < 1");
    }
}
