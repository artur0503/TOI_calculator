package App.core.classes.controller.decoding;

import App.core.classes.model.POJO.Data;
import App.core.classes.model.logic.decoding.BinaryDecoder;
import App.core.interfaces.controller.ControllerDecoding;
import App.core.interfaces.model.decoding.ModelDecodingBinary;

import java.util.LinkedList;

public class BinaryDecoderController implements ControllerDecoding {

    private String text;
    private LinkedList<Data> list;
    private String res;

    public BinaryDecoderController(String text, LinkedList<Data> list) {
        this.text = text;
        this.list = list;
    }

    private String getText() {
        return text;
    }

    private LinkedList<Data> getList() {
        return list;
    }

    private String getRes() {
        return res;
    }

    private void setRes(String res) {
        this.res = res;
    }

    @Override
    public void execute() {
        ModelDecodingBinary decoder = new BinaryDecoder(getText(), getList());
        decoder.decoding();
        setRes(decoder.getResult());
    }

    @Override
    public String getDecodingResult() {
        return getRes();
    }

}
