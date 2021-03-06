package App.classes.controller;

import App.classes.model.POJO.Data;
import App.classes.model.core.ShenonFano;
import App.interfaces.controller.Controller;
import App.interfaces.model.ShenonModel;

import java.util.LinkedList;

/**
 * Created by Arthur 31.01.2018 15:30.
 */
public class ControllerShenon implements Controller {

    private LinkedList<Data> resData;
    private LinkedList<String> drawCode;
    private LinkedList<LinkedList<Data>> drawData;
    private String text;

    public ControllerShenon(LinkedList<Data> resData) {
        this.resData = resData;
    }

    @Override
    public LinkedList<Data> getDataFromView() {
        return resData;
    }

    @Override
    public LinkedList<String> getCodeToDraw() {
        return drawCode;
    }

    @Override
    public LinkedList<LinkedList<Data>> getDataToDraw() {
        return drawData;
    }

    public void setDrawCode(LinkedList<String> drawCode) {
        this.drawCode = drawCode;
    }

    public void setDrawData(LinkedList<LinkedList<Data>> drawData) {
        this.drawData = drawData;
    }

    @Override
    public void execute() {
        ShenonModel magic = new ShenonFano();
        if (getDataFromView() != null) {
            magic.create(getDataFromView());
            if (magic.check()) {
                magic.sortCh();
                magic.tree();
                magic.sortCh();
                System.out.println();
                magic.show();
            }
        }
//            convertToDraw(magic);
//

//                ДЕКОДИРОВАНИЕ

//                if (!text.equals(""))
//                    System.out.println("Результат: " + new Decoder(text, magic.dataResult()).getResult());
////            else System.out.println("Невоможно декодировать");
//            } else
//                System.out.println("сумма не равна 1");
//        }
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
//
//    private void convertToDraw(Model magic){
//        Iterator<String> iterator = magic.dataForDrawing().keySet().iterator();
//        drawData = new LinkedList<>();
//        drawCode = new LinkedList<>();
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            drawData.add(magic.dataForDrawing().get(key));
//            drawCode.add(key);
//        }
//    }
}
