package App.interfaces.controller;

import App.classes.model.POJO.Data;

import java.util.LinkedList;

/**
 * Created by Arthur 31.01.2018 15:34.
 */
public interface Controller {

    void execute();

    LinkedList<Data> getDataFromView();

    LinkedList<String> getCodeToDraw();

    LinkedList<LinkedList<Data>> getDataToDraw();

}
