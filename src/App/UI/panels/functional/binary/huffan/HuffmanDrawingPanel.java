package App.UI.panels.functional.binary.huffan;

import App.UI.supporting.Components;
import App.UI.supporting.DrawingPanel;
import App.core.classes.model.POJO.Data;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class HuffmanDrawingPanel extends DrawingPanel {

    private LinkedList<Data> list;
    private HashMap<Integer, String[]> draw;
    private LinkedList<JLabel> labelList;
    private Dimension size;
    private int n;

    HuffmanDrawingPanel(LinkedList<Data> list, HashMap<Integer, String[]> draw, int n, Dimension size) {
        this.list = list;
        this.n = n;
        this.size = size;
        this.draw = draw;
        setLayout(null);
    }

    private void setCharToDraw(int iteration){
//        setBackground(Color.BLUE);
        System.out.println("Итерация: " + iteration);
        labelList = new LinkedList<>();
        int step = 30;
        int x = 30;
        int j = 0;
        for (int i = step / 2; i < getPreferredSize().width; i = i + (step)) {
            if (iteration == 1) {
                if (j != list.size()) {
                    addLabel(list.get(j).getNameS(), x * iteration, i);
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
                if (iteration != draw.size()) {
                    String[] column = draw.get(iteration);
                    if (j != column.length) {
                        addLabel(column[j], 40 * iteration, i);
                        j++;
                    }
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
//        setCharToDraw(iteration);
//        for (int i = 1; i < draw.size(); i++) {
//            setCharToDraw(i);
//        }

        for (int i = 0; i < draw.size(); i++){
            System.out.println(Arrays.toString(draw.get(i + 2)));
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.dispose();
    }

}