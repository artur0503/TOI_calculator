package App.core.interfaces.model.coding;

import App.core.classes.model.models.Data;
import App.core.interfaces.model.BaseModel;

import java.util.LinkedList;

/**
 * Created by Arthur 31.01.2018 15:14.
 */
public interface ModelCoding extends BaseModel {

    LinkedList<String[]> dataForDrawing();

    LinkedList<Data> dataResult();

    void create(LinkedList<Data> list);
}
