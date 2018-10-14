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
        int middle = getPreferredSize().width / 3 - 100;
        int x = 30;
        int j = 0;
        for (int i = step / 2; i < getPreferredSize().width; i = i + (step)) {
            if (iteration == 1) {
                if (j != list.size()) {
                    addLabel(list.get(j).getNameS(), middle, i);
                    isLine = false;
                    modelList = new LinkedList<>();
                    sumList = new LinkedList<>();
                    temp = 0;
                    stepTemp = 0;
                    lastIteration = 0;
                    j++;
                }
                else
                    break;
            }
            else if (iteration == 2) {
                if (j != list.size()) {
                    addLabel(String.valueOf(list.get(j).getChance()), middle + x, i);
                    if (j == list.size() - 2)
                        if (modelList.isEmpty()){
                            addModelForDrawing(iteration, j, middle, x, i);
                        }
                    j++;
                }
                else
                    break;
            }
            else if (iteration > 2){
                if (j != (list.size() - (iteration - 2))) {
                    int x1;
                    if (iteration == 3) {
                        x1 = middle + x * iteration;
                    }
                    else {
                        x1 = middle + (2 * x * iteration) - 100;
                    }
                    if (j == 13){
                        System.out.println();
                    }
                    addLabel(String.valueOf(lastSumList.get(iteration - 2).get(j).getChance()), x1, i);
                    if (lastSumList.get(iteration - 2).get(j).isRes()) {
                        sumList.add(new DrawingModel(iteration, x1, i));
                    }
                    if (list.size() >= iteration) {
                        if (j == (list.size() - (iteration))) {
                            addModelForDrawing(lastIteration, j, middle, temp - middle, stepTemp);
                            temp = x1;
                            stepTemp = i;
                            lastIteration = iteration;
                            isLine = true;
                        }
                    }
                    else
                        if (j == (list.size() - (iteration - 1))){
                            addModelForDrawing(lastIteration, j, middle, temp - middle, stepTemp);
                        }
                    j++;
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
                graphics2D.drawLine(model.getxLine(), model.getyLine(), model.getxLine(), model.getyLine() + 50);
            iterationCount++;
        }
    }

    private void drawHorizontalLine(Graphics2D graphics2D, LinkedList<DrawingModel> modelList, int lastIteration){
        int iterationCount = 2;
        for (DrawingModel model : modelList) {
            if (iterationCount <= lastIteration)
                graphics2D.drawLine(model.getxLine(), model.getyLine() + 22, model.getxLine() + 25, model.getyLine() + 22);
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