package App.UI.panels.functional.binary.huffan;

import App.UI.panels.functional.binary.BinaryCodingPanel;
import App.UI.supporting.DrawingPanel;
import App.core.classes.model.POJO.Data;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class HuffmanPanel extends BinaryCodingPanel {

    @Override
    public DrawingPanel drawingPanel(LinkedList<Data> list, HashMap<Integer, String[]> draw) {
        HuffmanDrawingPanel drawingPanel = new HuffmanDrawingPanel(list, draw, list.size(), new Dimension(1000, 1000));
        drawingPanel.getIteration(2);
        return drawingPanel;
    }
}
