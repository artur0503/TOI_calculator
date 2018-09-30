package App.core.interfaces.controller;

import App.core.classes.model.POJO.Data;

import java.util.LinkedList;

public interface ControllerCoding extends BaseController {

    LinkedList<Data> getDataFromView();

    LinkedList<Data> getCodeToDraw();

    LinkedList<String[]> getDataToDraw();

}
