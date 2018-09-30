package App.UI.panels.functional.arithmetic;

import App.core.classes.model.POJO.Data;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class DrawingPanel extends JPanel {

    private LinkedList<Data> list;
    private LinkedList<JLabel> labelList;
    private int n;

    DrawingPanel(LinkedList<Data> list, int n) {
        this.list = list;
        this.n = n;
        setLayout(null);
    }


    void setCharToDraw(){
        labelList = new LinkedList<>();
        int step = (getPreferredSize().width / n);
        int j = 0;
        for (int i = step / 2; i < getPreferredSize().width; i = i + (step)) {
            JLabel label = new JLabel();
            add(label);
            label.setBounds(i, 20, 30, 20);
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
        g2d.drawLine(0, 50, getPreferredSize().width, 50);
        double all = getPreferredSize().width;
        int step = getPreferredSize().width / n;
        for (int i = step; i < all - step; i = i + step) {
            g2d.drawLine(i, 45, i, 55);
        }
        if (labelList != null){
            if (!labelList.isEmpty()){
                g2d.drawLine(labelList.getFirst().getX() + (step / 2), 55, labelList.getFirst().getX(), 75);
            }
        }
        g2d.dispose();
    }

}