package App.UI.panels.functional.binary.shennon_fano;

import App.UI.supporting.Components;
import App.UI.supporting.DrawingModel;
import App.UI.supporting.DrawingPanel;
import App.core.classes.model.models.Data;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class ShenonDrawingPanel extends DrawingPanel {

    private LinkedList<Data> list;
    private HashMap<Integer, String[]> draw;
    private LinkedList<JLabel> labelList;
    private Dimension size;
    private String  temp = "";
    private boolean isDivide;
    private boolean isLine;
    private LinkedList<DrawingModel> modelList;

    ShenonDrawingPanel(LinkedList<Data> list, HashMap<Integer, String[]> draw, Dimension size) {
        this.list = list;
        this.size = size;
        this.draw = draw;
        setLayout(null);
    }

    private boolean checkForDivide(String code){
        return code.equals("1") & temp.equals("0");
    }

    private void setCharToDraw(int iteration){
        labelList = new LinkedList<>();
        int step = 30;
        int x = 30;
        int j = 0;
        for (int i = step / 2; i < getPreferredSize().width; i = i + (step)) {
            if (iteration == 1) {
                if (j != list.size()) {
                    addLabel(list.get(j).getNameS(), x * iteration, i);
                    isDivide = false;
                    modelList = new LinkedList<>();
                    j++;
                }
                else
                    break;
            }
            else if (iteration == 2) {
                if (j != list.size()) {
                    addLabel(String.valueOf(list.get(j).getChance()), x * iteration, i);
                    j++;
                }
                else
                    break;
            }
            else {
                if (draw.get(iteration) != null)
                    isDivide = true;
                    if (j != draw.get(iteration).length) {
                        String[] column = draw.get(iteration);
                        if (checkForDivide(column[j])){
                            isLine = true;
                            modelList.add(new DrawingModel(iteration, (i - step) + 30));
                        }
                        addLabel(column[j], 40 * iteration, i);
                        temp = column[j];
                        j++;
                    }
                    else
                        break;
            }
        }
    }

    private void addLabel(String text, int x, int y){
        JLabel label = Components.createLabel(text);
        add(label);
        label.setBounds(x, y, 50, 20);
    }

    @Override
    public void getIteration(int iteration) {
        removeAll();
        setVisible(false);
        setVisible(true);
        for (int i = 1; i <= iteration + 2; i++) {
            setCharToDraw(i);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return size;
    }

    private void drawLine(Graphics2D graphics2D){
        if (isDivide) {
            int j = 0;
            for (DrawingModel model : modelList){
                if (j != list.size() - 1) {
                    if (isLine) {
                        graphics2D.drawLine(
                                30, model.getStep() - 5,
                                (model.getIteration() * 40) + 10, model.getStep() - 5);
                    }
                    j++;
                } else
                    break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        drawLine(g2d);
    }
}
