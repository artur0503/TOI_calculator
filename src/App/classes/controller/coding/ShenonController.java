package App.classes.controller.coding;

import App.classes.model.POJO.Data;
import App.classes.model.core.coding.Huffman;
import App.classes.model.core.coding.ShenonFano;
import App.interfaces.controller.ControllerCoding;
import App.interfaces.model.coding.ModelCodingTree;

import java.util.LinkedList;

/**
 * Created by Arthur 31.01.2018 15:30.
 */
public class ShenonController implements ControllerCoding {

    private LinkedList<Data> resData;
    private LinkedList<Data> drawCode;
//    private LinkedList<LinkedList<Data>> drawData;

    public ShenonController(LinkedList<Data> resData) {
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
        ModelCodingTree magic = new ShenonFano();
        if (getDataFromView() != null) {
            magic.create(getDataFromView());
            if (magic.check()) {
                magic.sortCh();
                magic.tree();
                magic.sortCh();
                System.out.println();
                magic.showConsole();
                setDrawCode(magic.dataResult());
            }
        }else
            System.out.println("ERROR (SUM < 1)");
        //пойдет во view
//        if (drawCode.size() == drawData.size()) {
//            for (int i = 0; i < drawCode.size(); i++) {
//                System.out.println();
//                for (int j = 0; j < drawData.get(i).size(); j++){
//                    System.out.print(drawData.get(i).get(j).getNameS() + " ");
//                }
//                System.out.println(": " + drawCode.get(i));
//            }
//        }
    }

    private void setDrawCode(LinkedList<Data> drawCode) {
        this.drawCode = drawCode;
    }

//    public void setDrawData(LinkedList<LinkedList<Data>> drawData) {
//        this.drawData = drawData;
//    }
}
