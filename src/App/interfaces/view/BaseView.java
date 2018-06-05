package App.interfaces.view;

import App.classes.model.POJO.Data;

import java.util.LinkedList;

/**
 * Created by Arthur 31.01.2018 15:57.
 */
public interface BaseView {

    void execute();

    void afterAction();

    void setInputData(LinkedList<Data> list);

    LinkedList getInputData();

}
