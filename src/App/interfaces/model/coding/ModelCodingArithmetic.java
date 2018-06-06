package App.interfaces.model.coding;

import App.classes.model.POJO.Data;
import App.interfaces.model.coding.ModelCoding;

import java.util.Date;
import java.util.LinkedList;

public interface ModelCodingArithmetic extends ModelCoding {

    void coding();

    void textForCoding(String text);

    double resultCode();

    void showConsole();

    boolean check();

}
