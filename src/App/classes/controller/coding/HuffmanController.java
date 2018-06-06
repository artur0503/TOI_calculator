package App.classes.controller.coding;

import App.classes.model.core.coding.Huffman;
import App.classes.model.POJO.Data;
import App.interfaces.controller.ControllerCoding;
import App.interfaces.model.coding.ModelCodingTree;

import java.util.LinkedList;

public class HuffmanController implements ControllerCoding {

    private LinkedList<Data> resData;
    private LinkedList<Data> drawCode;
//    private LinkedList<LinkedList<Data>> drawData;

    public HuffmanController(LinkedList<Data> resData) {
        this.resData = resData;
    }

    @Override
    public LinkedList<Data> getDataFromView() {
        return resData;
    }

    @Override
    public LinkedList<Data> getCodeToDraw() {
        return drawCode;
    }

    @Override
    public LinkedList<LinkedList<Data>> getDataToDraw() {
        return null;
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
                setDrawCode(magic.dataResult());
//                setDrawData();
            }
        } else
            System.out.println("###ERROR###\n SUM < 1");
//            int N = 16;

//            double maxE = new BigDecimal(((-N*((1.0/N)*(Math.log(1.0/N)))))).setScale(3, RoundingMode.UP).doubleValue();
//
//            System.out.println("Макс. энтропия: " + maxE);

    }

    private void setDrawCode(LinkedList<Data> drawCode) {
        this.drawCode = drawCode;
    }

//    public void setDrawData(LinkedList<LinkedList<Data>> drawData) {
//        this.drawData = drawData;
//    }
}
