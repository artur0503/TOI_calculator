package App.core.interfaces.model.coding;

import App.core.classes.model.models.Data;

import java.util.LinkedList;

public interface ModelCodingArithmetic extends ModelCoding {

    LinkedList<Data> dataForDrawingArithm();

    void coding();

    void textForCoding(String text);

    double resultCode();

    void showConsole();

    boolean check();

}
