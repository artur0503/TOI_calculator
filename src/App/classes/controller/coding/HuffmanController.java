package App.classes.controller.coding;

import App.classes.model.core.coding.Huffman;
import App.classes.model.POJO.Data;
import App.interfaces.controller.ControllerCoding;
import App.interfaces.model.coding.ModelCodingTree;

import java.util.LinkedList;

public class HuffmanController implements ControllerCoding {

    private LinkedList<Data> resData;
    private LinkedList<String> drawCode;
    private LinkedList<LinkedList<Data>> drawData;

    public HuffmanController(LinkedList<Data> resData) {
        this.resData = resData;
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
            }
        }else
            System.out.println("ERROR (SUM < 1)");
//            int N = 16;

//            double maxE = new BigDecimal(((-N*((1.0/N)*(Math.log(1.0/N)))))).setScale(3, RoundingMode.UP).doubleValue();
//
//            System.out.println("Макс. энтропия: " + maxE);


//        }else
//            System.out.println("сумма меньше 1");
    }

    @Override
    public LinkedList<Data> getDataFromView() {
        return resData;
    }

    @Override
    public LinkedList<String> getCodeToDraw() {
        return null;
    }

    @Override
    public LinkedList<LinkedList<Data>> getDataToDraw() {
        return null;
    }
}
