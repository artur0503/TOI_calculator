package App.interfaces.controller;

import App.classes.model.POJO.Data;

import java.util.LinkedList;

public interface ControllerCoding extends BaseController {

    LinkedList<Data> getDataFromView();

    LinkedList<String> getCodeToDraw();

    LinkedList<LinkedList<Data>> getDataToDraw();

}
