package App.UI.panels.menu;

import App.core.classes.model.POJO.Data;
import App.UI.listeners.OnClickListener;
import App.UI.supporting.Components;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class MenuPanel implements ActionListener {

    private JPanel menuPanel;
    private JButton huf;
    private JButton shen;
    private JButton arithm;
    private JButton arithmDec;
    private JButton back;

    private LinkedList<Data> listChances;

    private String title;
    public final static int HUFFMAN = 1;
    public final static int SHENON = 2;
    public final static int ARITHMETIC = 3;
    public final static int ARITHM_DECODING = 4;

    public MenuPanel(LinkedList<Data> listChances, String title) {
        this.listChances = listChances;
        this.title = title;
    }

    public LinkedList<Data> getListChances() {
        return listChances;
    }

    public void setListChances(LinkedList<Data> listChances) {
        this.listChances = listChances;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public void createMenuPanel(){
        System.out.println(getListChances().size());

        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayoutManager(5, 1,
                new Insets(0, 0, 0, 0), -1, -1));

        /*create label and add it to menu panel*/
        menuPanel.add(Components.createTitleLabel(title),
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));


        /*create spacer and add it to menu panel*/
        menuPanel.add(Components.createSpacer(),
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, 1,
                        GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 10),
                        new Dimension(-1, 30), new Dimension(-1, 100), 0, false));

        /*create panel for buttons and add it to menu panel*/
        JPanel jPanel = Components.createJPanel(5, 1);
        menuPanel.add(jPanel,
                new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        /*create buttons and add it to menu panel*/
        addButtons(jPanel);

        /*create spacer and add it to menu panel*/
        menuPanel.add(Components.createSpacer(),
                new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, 1,
                        GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 40),
                        new Dimension(-1, 40), new Dimension(-1, 40), 0, false));

        /*create spacer and add it to menu panel*/
        menuPanel.add(Components.createSpacer(),
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, 1,
                        GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 10),
                        new Dimension(-1, 30), new Dimension(-1, 100), 0, false));

        /*create spacer and add it to menu panel*/
        menuPanel.add(Components.createSpacer(),
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW,
                        1, null, null, null,
                        0, false));

    }

    private void addButtons(JPanel jPanel){

        huf = createButton("Метод Хаффмана");
        jPanel.add(huf,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1),
                        new Dimension(300, -1), new Dimension(400, -1), 0, false));


        shen = createButton("Метод Шеннона-Фано");
        jPanel.add(shen,
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), new Dimension(300, -1),
                        new Dimension(400, -1), 0, false));


        arithm = createButton("Арифметическое кодирование");
        jPanel.add(arithm,
                new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1),
                        new Dimension(300, -1), new Dimension(400, -1), 0, false));


        arithmDec = createButton("Арифметическое декодирование");
        jPanel.add(arithmDec,
                new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), new Dimension(300, -1),
                        new Dimension(400, -1), 0, false));

        back = createButton("Назад");
        jPanel.add(back,
                new GridConstraints(4, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), new Dimension(300, -1),
                        new Dimension(400, -1), 0, false));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == huf){
            listener.onClick(true, HUFFMAN);
        }
        else if (e.getSource() == shen){
            listener.onClick(true, SHENON);
        }
        else if (e.getSource() == arithm){
            listener.onClick(true, ARITHMETIC);
        }
        else if (e.getSource() == arithmDec){
            listener.onClick(true, ARITHM_DECODING);
        }
        else if (e.getSource() == back){
            listener.onClick(false, 0);
        }

    }
    private JButton createButton(String text){
        return Components.createJButton(text, this);
    }

    private OnClickListener listener;

    public void setOnMenuClickListener(OnClickListener listener) {
        this.listener = listener;
    }
}
