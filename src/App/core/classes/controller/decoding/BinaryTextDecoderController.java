package App.core.classes.controller.decoding;

import App.core.classes.model.models.Data;
import App.core.classes.model.logic.decoding.BinaryTextDecoder;
import App.core.interfaces.controller.ControllerDecoding;
import App.core.interfaces.model.decoding.ModelDecodingBinary;

import java.util.LinkedList;

public class BinaryTextDecoderController implements ControllerDecoding {

    private String text;
    private LinkedList<Data> list;
    private String res;

    public BinaryTextDecoderController(String text, LinkedList<Data> list) {
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
        ModelDecodingBinary decoder = new BinaryTextDecoder(getText(), getList());
        decoder.decoding();
        setRes(decoder.getResult());
    }

    @Override
    public String getDecodingResult() {
        return getRes();
    }
}
