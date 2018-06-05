package App.classes.controller.decoding;

import App.classes.model.POJO.Data;
import App.classes.model.core.decoding.Decoder;
import App.interfaces.controller.ControllerDecoding;

import java.util.LinkedList;

public class BinaryDecoderController implements ControllerDecoding {

    private String text;
    private LinkedList<Data> list;

    @Override
    public void execute() {
        Decoder decoder = new Decoder(text, list);
        if (text != null)
            decoder.showConsole();
        else System.out.println("Невоможно декодировать");
    }

    @Override
    public String getDecodingResult() {
        return null;
    }
}
