package Practice.UI.panels.functional;

import Practice.UI.supporting.Components;
import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InputPanel implements ActionListener, ChangeListener {


    private final static int DEFAULT = 16;

    private int now = 15;

    private JPanel inputPanel;
    private JPanel charPanel;
    private JPanel chancePanel;
    private JPanel textPanel;

    private ArrayList<JPanel> arrPanels;

    private JButton backButton;
    private JButton nextButton;
    private JSpinner spinner;

    public JPanel getInputPanel() {
        return inputPanel;
    }

    private void addSpacer(JPanel panel, int row, int column, Dimension size){
        panel.add(Components.createSpacer(),
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1,
                        size, size, size, 0, false));
    }

    private void addSpacer(JPanel panel, int row, int column, Dimension size, int type){
        panel.add(Components.createSpacer(),
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, type,
                        size, size, size, 0, false));
    }

    private void addButton(JPanel panel, JButton button, int column){

        panel.add(button,
                new GridConstraints(0, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        button.addActionListener(this);
    }

    private void addLabel(JPanel panel, String text, int row, int column){
        JLabel labelCount = Components.createLabel(text);
        panel.add(labelCount,
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null,
                        0, false));
    }

    private void addSpinner(JPanel panel, JSpinner spinner, int row, int column){
        panel.add(spinner,
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED,
                        new Dimension(40, 30),
                        new Dimension(40, 30),
                        new Dimension(40, 30),
                        0, false));
        spinner.addChangeListener(this);
        ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
    }

    private void addScrollPane(JPanel panel, JScrollPane scrollPane, int row, int column){
        panel.add(scrollPane,
                new GridConstraints(row, column, 1, 12,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        new Dimension(285, 400), new Dimension(285, 400), new Dimension(285, 400), 0, false));

    }

    private void addPanel(JPanel panel, JPanel newPanel, int row, int column){
        panel.add(newPanel,
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        1, null, null, null, 0, false));

    }

    private void addTextField(JPanel panel, int row, int column){
        JTextField textField = Components.createJTextField();
        panel.add(textField,
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED,
                        new Dimension(40, 20), new Dimension(40, 20),
                        new Dimension(40, 20), 0, false));

    }

    public void createInputPanel(){
        arrPanels = new ArrayList<>();
        inputPanel = Components.createJPanel(4, 17);
        backButton = Components.createButton("Назад", this);
        nextButton = Components.createButton("Далее", this);
        spinner = Components.createSpinner(1, DEFAULT - 1, now, this);
        textPanel = Components.createJPanel(DEFAULT + 1, 1);
        JPanel jPanel1 = Components.createJPanel(1, 2);
        JPanel jPanel2 = Components.createJPanel(1, 3);

        JScrollPane scrollPane = new JScrollPane();
        addPanel(inputPanel, jPanel2, 0, 0);
        addSpacer(jPanel2, 0, 0, null);
        addLabel(jPanel2, "Кол-во:", 0, 1);
        addSpinner(jPanel2, spinner, 0, 2);

        addPanel(inputPanel, jPanel1, 0, 1);
        addButton(jPanel1, backButton, 0);
        addButton(jPanel1, nextButton, 1);

        addSpacer(inputPanel, 0, 4, null);
        addScrollPane(inputPanel, scrollPane, 2, 0);
        scrollPane.setViewportView(textPanel);
        addInput(textPanel, now);
    }

    private void addInput(JPanel textPanel, int now){
        addSpacer(textPanel, 0, 0, new Dimension(20, 0));
        JPanel jPanel3 = Components.createJPanel(1, 4);
        addPanel(textPanel, jPanel3, 0, 0);
        addSpacer(jPanel3, 0, 1, null);
        addLabel(jPanel3, "Символ:", 0, 0);
        addLabel(jPanel3, "Вер-сть:", 0, 2);
        addSpacer(jPanel3, 0,  2, new Dimension(160, 0));
        addSpacer(textPanel, DEFAULT, 0, null, 2);

        for (int i = 1; i < DEFAULT  ; i++){
            addChance(textPanel, i);
            if (i <= now ){
                arrPanels.get(i - 1 ).setVisible(true);
            }
        }
        arrPanels.get(0).setBackground(Color.cyan);
        System.out.println(arrPanels.size());
    }

    private void addChance(JPanel textPanel, int i){
        JPanel jPanel4 = Components.createJPanel(1, 4);
        addPanel(textPanel, jPanel4, i, 0);
        addTextField(jPanel4, 0, 1);
        addTextField(jPanel4, 0, 2);
        arrPanels.add(jPanel4);
        addSpacer(jPanel4, 0,  3, new Dimension(50, 0));
        jPanel4.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    @Override
    public void stateChanged(ChangeEvent e) {
        JSpinner spinner = (JSpinner) e.getSource();
//        ((JTextField)arrPanels.get(0).getComponent(0)).setText("suka");
        if (((int) spinner.getValue()) > now) {
            now = (int) spinner.getValue();
            arrPanels.get(now - 1).setVisible(true);
            ((JTextField)arrPanels.get(now - 1).getComponent(0)).setText("blaaa");
        } else if (((int) spinner.getValue()) < now) {
            now = (int) spinner.getValue();
            System.out.println(now);
            arrPanels.get(now).setVisible(false);
        }
    }
}
