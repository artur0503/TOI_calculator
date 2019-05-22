package App.UI.panels.functional.binary.huffan;

import App.UI.supporting.Components;
import App.UI.supporting.DrawingModel;
import App.UI.supporting.DrawingPanel;
import App.core.classes.model.models.Data;
import App.core.classes.model.models.DataDraw;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class HuffmanDrawingPanel extends DrawingPanel {

    private LinkedList<Data> list;
    private HashMap<Integer, String[]> draw;
    private LinkedList<LinkedList<DataDraw>> lastSumList;
    private Dimension size;
    private boolean isLine;
    private LinkedList<DrawingModel> modelList;
    private LinkedList<DrawingModel> sumList;
    private int lastIteration;
    private int temp = 0;
    private int stepTemp;


    HuffmanDrawingPanel(LinkedList<Data> list, HashMap<Integer, String[]> draw, LinkedList<LinkedList<DataDraw>> lastSumList, Dimension size) {
        this.list = list;
        this.size = size;
        this.draw = draw;
        this.lastSumList = lastSumList;
        setLayout(null);
    }

    private void setCharToDraw(int iteration){
        size.setSize(size.getWidth(), list.size() * 31);
        int step = 30;
        int middle = getPreferredSize().width / 3 - 50;
        int x = 30;
        int j1 = 0;
        int j2 = 0;
        for (int i = step / 2; i < getPreferredSize().width; i = i + (step)) {
            if (iteration == 1) {
                if (j1 != list.size()) {
                    addLabel(list.get(j1).getNameS(), middle, i);
                    isLine = false;
                    modelList = new LinkedList<>();
                    sumList = new LinkedList<>();
                    temp = 0;
                    stepTemp = 0;
                    lastIteration = 0;
                    j1++;
                }
                else
                    break;
            }
            else if (iteration == 2) {
                if (j1 != list.size()) {
                    addLabel(String.valueOf(list.get(j1).getChance()), middle + x, i);
                    if (j1 == list.size() - 2)
                        if (modelList.isEmpty()){
                            addModelForDrawing(iteration, j1, middle, x, i);
                        }
                    j1++;
                }
                else
                    break;
            }
            else if (iteration > 2){
                if (j1 != (list.size() - (iteration - 2))) {
                    int x1;
                    if (iteration == 3) {
                        x1 = middle + x * iteration;
                    }
                    else {
                        x1 = middle + (2 * x * iteration) - 100;
                    }
                    addLabel(String.valueOf(lastSumList.get(iteration - 2).get(j1).getChance()), x1, i);
                    if (lastSumList.get(iteration - 2).get(j1).isRes()) {
                        sumList.add(new DrawingModel(iteration, x1, i));
                    }
                    if (list.size() >= iteration) {
                        if (j1 == (list.size() - (iteration))) {
                            addModelForDrawing(lastIteration, j1, middle, temp - middle, stepTemp);
                            temp = x1;
                            stepTemp = i;
                            lastIteration = iteration;
                            isLine = true;
                        }
                    }
                    else
                        if (j1 == (list.size() - (iteration - 1))){
                            addModelForDrawing(lastIteration, j1, middle, temp - middle, stepTemp);
                        }
                    j1++;
                }
                if (j2 != (list.size())) {
                    int x2;
                    if (iteration == 3) {
                        x2 = middle - x;
                    } else {
                        x2 = middle - x * (iteration - 2);
                    }
                    if (j2 == 13) {
                        System.out.println();
                    }
                    addLabel(String.valueOf(draw.get(iteration)[j2]), x2, i);
                    j2++;
                }
            }
        }
    }



    private void addModelForDrawing(int iteration, int j, int middle, int x, int i){
        int size = 27;
        int xLine = 0;
        int yLine = 0;
        for (int o = 3; o <= 5; o++) {
            if (Double.toString(list.get(j).getChance()).length() <= Double.toString(list.get(j + 1).getChance()).length()) {
                if (Double.toString(list.get(j + 1).getChance()).length() == o) {
                    xLine = middle + x + size;
                    yLine = i;
                    break;
                }
                else
                    size = size + 9;
            }
            else {
                if (Double.toString(list.get(j).getChance()).length() == o) {
                    xLine = middle + x + size;
                    yLine = i;
                    break;
                }
                else
                    size = size + 9;
            }
        }

        if (iteration != 0)
            modelList.add(new DrawingModel(iteration, xLine, yLine));
    }

    private void addLabel(String text, int x, int y){
        JLabel label = Components.createLabel(text);
        add(label);
        label.setBounds(x, y, 40, 20);
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

    private void drawVerticalLine(Graphics2D graphics2D, LinkedList<DrawingModel> modelList, int lastIteration){
        int iterationCount = 2;
        for (DrawingModel model : modelList) {
            if (iterationCount <= lastIteration)
                graphics2D.drawLine(model.getXLine(), model.getYLine(), model.getXLine(), model.getYLine() + 50);
            iterationCount++;
        }
    }

    private void drawHorizontalLine(Graphics2D graphics2D, LinkedList<DrawingModel> modelList, int lastIteration){
        int iterationCount = 2;
        for (DrawingModel model : modelList) {
            if (iterationCount <= lastIteration)
                graphics2D.drawLine(model.getXLine(), model.getYLine() + 22, model.getXLine() + 25, model.getYLine() + 22);
            iterationCount++;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        if (isLine) {
            drawVerticalLine(g2d, modelList, lastIteration);
            drawHorizontalLine(g2d, sumList, lastIteration);
        }
    }

}