package App.interfaces.model.coding;

import App.classes.model.POJO.Data;
import App.interfaces.model.BaseModel;

import java.util.LinkedList;

/**
 * Created by Arthur 31.01.2018 15:14.
 */
public interface ModelCoding extends BaseModel {

    LinkedList<Data> dataForDrawing();

    LinkedList<Data> dataResult();

    void create(LinkedList<Data> list);
}
