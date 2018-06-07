package App.classes.controller.coding;

import App.classes.model.POJO.Data;
import App.classes.model.core.coding.ShenonFano;
import App.interfaces.controller.ControllerCoding;
import App.interfaces.model.coding.ModelCodingTree;

import java.util.LinkedList;

/**
 * Created by Arthur 31.01.2018 15:30.
 */
public class ShenonController implements ControllerCoding {

    private LinkedList<Data> inputData;
    private LinkedList<Data> resCode;
    private LinkedList<Data> drawData;

    public ShenonController(LinkedList<Data> inputData) {
        this.inputData = inputData;
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

    private LinkedList<Data> getInputData() {
        return inputData;
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
        ModelCodingTree magic = new ShenonFano();
        if (getDataFromView() != null) {
            magic.create(getDataFromView());
            if (magic.check()) {
                magic.sortCh();
                magic.tree();
                magic.sortCh();
                System.out.println();
                magic.showConsole();
                setResCode(magic.dataResult());
                setDrawData(magic.dataForDrawing());
            }
        }else
            System.out.println("ERROR (SUM < 1)");
        //пойдет во view
//        if (resCode.size() == drawData.size()) {
//            for (int i = 0; i < resCode.size(); i++) {
//                System.out.println();
//                for (int j = 0; j < drawData.get(i).size(); j++){
//                    System.out.print(drawData.get(i).get(j).getNameS() + " ");
//                }
//                System.out.println(": " + resCode.get(i));
//            }
//        }
    }
}
