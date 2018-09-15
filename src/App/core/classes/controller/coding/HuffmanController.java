package App.core.classes.controller.coding;

import App.core.classes.model.logic.coding.Huffman;
import App.core.classes.model.POJO.Data;
import App.core.interfaces.controller.ControllerCoding;
import App.core.interfaces.model.coding.ModelCodingTree;

import java.util.LinkedList;

public class HuffmanController implements ControllerCoding {

    private LinkedList<Data> inputData;
    private LinkedList<Data> resCode;
    private LinkedList<Data> drawData;

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
        ModelCodingTree magic = new Huffman();
        if (getDataFromView() != null) {
            magic.create(getDataFromView());
            if (magic.check()) {
                magic.sortCh();
                magic.tree();
                magic.sortCh();
                magic.sortInd();
                System.out.println();
                magic.showConsole();
                setResCode(magic.dataResult());
                setDrawData(magic.dataForDrawing());
            }
        } else
            System.out.println("###ERROR###\n SUM < 1");
//            int N = 16;

//            double maxE = new BigDecimal(((-N*((1.0/N)*(Math.log(1.0/N)))))).setScale(3, RoundingMode.UP).doubleValue();
//
//            System.out.println("Макс. энтропия: " + maxE);

    }
}
