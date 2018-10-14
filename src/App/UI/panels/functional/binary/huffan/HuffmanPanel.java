package App.UI.panels.functional.binary.huffan;

import App.UI.panels.functional.binary.BinaryCodingPanel;
import App.UI.supporting.DrawingPanel;
import App.core.classes.model.models.Data;
import App.core.classes.model.models.DataDraw;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class HuffmanPanel extends BinaryCodingPanel {

    private LinkedList<LinkedList<DataDraw>> lastSumList;

    public HuffmanPanel(LinkedList<LinkedList<DataDraw>> lastSumList) {
        this.lastSumList = lastSumList;
    }

    private LinkedList<LinkedList<DataDraw>> getLastSumList() {
        return lastSumList;
    }

    @Override
    public int getCountIteration(LinkedList<Data> linkedList) {
        return linkedList.size() - 1;
    }

    @Override
    public DrawingPanel drawingPanel(LinkedList<Data> list, HashMap<Integer, String[]> draw) {
        setIterationMax(getCountIteration(list));
        HuffmanDrawingPanel drawingPanel = new HuffmanDrawingPanel(list, draw, getLastSumList(), new Dimension(1500, 500));
        drawingPanel.getIteration(0);
        return drawingPanel;
    }
}
