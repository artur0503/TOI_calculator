package App.interfaces.model;

import App.classes.model.POJO.Data;

import java.util.LinkedList;

public interface ShenonModel extends Model {

    LinkedList<Data> dataForDrawing();

    LinkedList<Data> dataResult();

    void create(LinkedList<Data> list);

    void sortCh();

    void sortInd();

    void tree();

    void show();

    boolean check();

}
