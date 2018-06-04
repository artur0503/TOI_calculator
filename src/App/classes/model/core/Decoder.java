package App.classes.model.core;

import App.classes.model.POJO.Data;

import java.util.ArrayList;
import java.util.LinkedList;

public class Decoder {

    private String text;
    private LinkedList<Data> code;
    private String res = "";

    public Decoder(String text, LinkedList<Data> code) {
        this.text = text;
        this.code = code;
    }

    private int getMaxByte(ArrayList<String[]> splitCode){
        int maxByte = 0;
        for (int i = 0; i < splitCode.size(); i++){
            for (int j = i; j < splitCode.size();j++){
                maxByte = (splitCode.get(i).length - 1);
                if ((splitCode.get(j).length - 1) >= maxByte)
                    maxByte = (splitCode.get(j).length - 1);
            }
        }
        return maxByte;
    }

    private ArrayList<String[]> convertCode(LinkedList<Data> code){
        ArrayList<String[]> splitCode = new ArrayList<>();
        for (Data aCode : code) {
            splitCode.add(aCode.getCode().split(""));
        }
        return splitCode;
    }

    private ArrayList<String[]> getConvertCode(){
        return convertCode(code);
    }

    private String removeFirstChar(String str) {
        return str.substring(0, 0) + str.substring(1);
    }

    private void decoding(ArrayList<String[]> splitCode, String text) {
        StringBuilder lastEl = new StringBuilder();
        int a = 0;
        int c = 0;

        try {
            String[] codeText = text.split("");
            r:
            while (c != codeText.length) {
                for (int j = 0; j < splitCode.size(); ) {
                    while (j != splitCode.size()) {
                        if (a > splitCode.get(j).length - 1)
                            j++;
                        else {
                            if (!splitCode.get(j)[a].equals(codeText[c])) {
                                splitCode.remove(j);
                                j--;
                            }
                            j++;
                        }
                    }
                    if (a >= getMaxByte(splitCode)) break r;
                    else {
                        a++;
                        c++;
                        j = 0;
                    }
                }
            }
            if (splitCode.size() == 1) {
                for (int i = 0; i < splitCode.get(0).length; i++) {
                    lastEl.append(splitCode.get(0)[i]);
                }
            }
            for (Data aCode : code) {
                if (aCode.getCode().equals(lastEl.toString()))
                    res = res + aCode.getNameS();
            }
            if (!res.equals("")) {
                int count = lastEl.toString().split("").length;
                String newText = text;
                if (newText.split("").length > 0) {
                    if (!newText.equals("")) {
                        for (int i = 0; i < count; i++) {
                            newText = removeFirstChar(newText);
                        }
                        decoding(getConvertCode(), newText);
                    }
                }
            }
        }catch (Exception e){
            res = "ERROR";
        }
    }

    private String getDecoding(){
        decoding(getConvertCode(), text);
        return res;
    }

    public String getResult() {
        return getDecoding();
    }

}
