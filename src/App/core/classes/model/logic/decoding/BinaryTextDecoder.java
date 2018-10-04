package App.core.classes.model.logic.decoding;

import App.core.classes.model.POJO.Data;
import App.core.interfaces.model.decoding.ModelDecodingBinary;

import java.util.LinkedList;

public class BinaryTextDecoder implements ModelDecodingBinary {

    private String text;
    private LinkedList<Data> code;
    private String res = "";

    public BinaryTextDecoder(String text, LinkedList<Data> code) {
        this.text = text;
        this.code = code;
    }

    @Override
    public void decoding() {
        if (check(text))
            decoding(code, text);
        else
            setRes("Error");
    }

    @Override
    public String getResult() {
        return getDecoding();
    }

    public void setRes(String res) {
        this.res = res;
    }

    private void decoding(LinkedList<Data> code, String text) {
        String res = "";
        for (String str : text.split("")){
            for (Data data : code) {
                if (data.getNameS().equals(str)) {
                    res = res + data.getCodeBinary();
                    break;
                }
            }
        }
        System.out.println(res);
        setRes(res);
    }

    private boolean check(String str){
        return !str.equals("");
    }

    private String getDecoding() {
        return res;
    }

}
