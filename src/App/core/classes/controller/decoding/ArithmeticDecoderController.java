package App.core.classes.controller.decoding;

import App.core.classes.model.models.Data;
import App.core.classes.model.logic.decoding.ArithmeticDecoder;
import App.core.interfaces.controller.ControllerDecoding;
import App.core.interfaces.model.decoding.ModelDecoding;

import java.util.LinkedList;

public class ArithmeticDecoderController implements ControllerDecoding {

    private double text;
    private String res;
    private int count;
    private LinkedList<Data> listData;

    public ArithmeticDecoderController(double text, int count, LinkedList<Data> listData) {
        this.text = text;
        this.count = count;
        this.listData = listData;
    }

    private double getText() {
        return text;
    }

    private int getCount() {
        return count;
    }

    private LinkedList<Data> getListData() {
        return listData;
    }

    private String getRes() {
        return res;
    }

    private void setRes(String res) {
        this.res = res;
    }

    @Override
    public void execute() {
        ModelDecoding decoder = new ArithmeticDecoder(getText(), getCount(), getListData());
        decoder.decoding();
        setRes(decoder.getResult());
    }

    @Override
    public String getDecodingResult() {
        return getRes();
    }


}
