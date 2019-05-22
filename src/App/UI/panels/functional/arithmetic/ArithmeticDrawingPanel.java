package App.UI.panels.functional.arithmetic;

import App.UI.supporting.DrawingPanel;
import App.core.classes.model.models.Data;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ArithmeticDrawingPanel extends DrawingPanel {

    private LinkedList<Data> list;
    private LinkedList<JLabel> labelList;
    private int n;
    private Dimension size;

    ArithmeticDrawingPanel(LinkedList<Data> list, int n, Dimension size) {
        this.list = list;
        this.n = n;
        this.size = size;
        setLayout(null);
    }


    private void setCharToDraw(int iteration){
        if (iteration == 2){
            System.out.println(2);
        }
        labelList = new LinkedList<>();
        int step = (getPreferredSize().width / n);
        int j = 0;
        for (int i = step / 2; i < getPreferredSize().width; i = i + (step)) {
            if (j < list.size()) {
                JLabel label = new JLabel();
                add(label);
                label.setBounds(i, 20, 30, 20);
                label.setText(list.get(j).getNameS());
                labelList.add(label);
                j++;
            }
        }
    }


    @Override
    public void getIteration(int iteration) {
        setCharToDraw(iteration);
    }

    @Override
    public Dimension getPreferredSize() {
        return size;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawLine(0, 50, getPreferredSize().width, 50);
        double all = getPreferredSize().width;
        int step = getPreferredSize().width / n;
        for (int i = step; i < all; i = i + step) {
            g2d.drawLine(i, 45, i, 55);
        }
        g2d.dispose();
    }

}