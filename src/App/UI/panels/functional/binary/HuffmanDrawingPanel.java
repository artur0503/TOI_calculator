package App.UI.panels.functional.binary;

import App.core.classes.model.POJO.Data;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class HuffmanDrawingPanel extends JPanel {

    private LinkedList<Data> list;
    private LinkedList<JLabel> labelList;
    private int n;

    HuffmanDrawingPanel(LinkedList<Data> list, int n) {
        this.list = list;
        this.n = n;
        setLayout(null);
    }


    void setCharToDraw(){
        labelList = new LinkedList<>();
        int step = 30;
        int j = 0;
        for (int i = step / 2; i < getHeight(); i = i + (step)) {
            JLabel label = new JLabel();
            add(label);
            label.setBounds(getWidth()/2, i, 30, 20);
            label.setText(list.get(j).getNameS());
            labelList.add(label);
            j++;
        }
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 100);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.dispose();
    }

}