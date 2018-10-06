package App.UI.panels.functional.binary.shennon_fano;

import App.UI.panels.functional.binary.BinaryCodingPanel;
import App.UI.supporting.DrawingPanel;
import App.core.classes.model.POJO.Data;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class ShenonPanel extends BinaryCodingPanel {

    @Override
    public DrawingPanel drawingPanel(LinkedList<Data> list, HashMap<Integer, String[]> draw) {
        DrawingPanel drawingPanel = new ShenonDrawingPanel(list, draw, new Dimension(1000, 1000));
        drawingPanel.getIteration(0);
        return drawingPanel;
    }
}
