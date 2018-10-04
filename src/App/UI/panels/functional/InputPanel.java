package App.UI.panels.functional;

import App.core.classes.model.POJO.Data;
import App.UI.listeners.OnInputListener;
import App.UI.supporting.Components;
import App.validation.ValidationUI;
import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class InputPanel implements ActionListener, ChangeListener {

    private final static int DEFAULT = 16;
    private int now = 2;

    private JPanel inputPanel;
    private ArrayList<JPanel> arrPanels;
    private JButton backButton;
    private JButton nextButton;
    private OnInputListener listener;

    public void setOnInputListener(OnInputListener listener) {
        this.listener = listener;
    }

    public JPanel getInputPanel() {
        return inputPanel;
    }

    private void addSpacer(JPanel panel, int column, Dimension size){
        panel.add(Components.createSpacer(),
                new GridConstraints(0, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1,
                        size, size, size, 0, false));
    }

    private void addSpacer(JPanel panel){
        panel.add(Components.createSpacer(),
                new GridConstraints(InputPanel.DEFAULT, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 2,
                        null, null, null, 0, false));
    }

    private void addButton(JPanel panel, JButton button, int column){

        panel.add(button,
                new GridConstraints(0, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        button.addActionListener(this);
    }

    private void addLabel(JPanel panel, String text, int column){
        JLabel labelCount = Components.createLabel(text);
        panel.add(labelCount,
                new GridConstraints(0, column, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null,
                        0, false));
    }

    private void addSpinner(JPanel panel, JSpinner spinner){
        panel.add(spinner,
                new GridConstraints(0, 2, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED,
                        new Dimension(40, 30),
                        new Dimension(40, 30),
                        new Dimension(40, 30),
                        0, false));
        spinner.addChangeListener(this);
        ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
    }

    private void addScrollPane(JPanel panel, JScrollPane scrollPane){
        panel.add(scrollPane,
                new GridConstraints(2, 0, 1, 12,
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

    private void addTextField(JPanel panel, int column, boolean isChar, int number){
        JTextField textField = Components.createJTextField(isChar);
        panel.add(textField,
                new GridConstraints(0, column, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED,
                        new Dimension(45, 25), new Dimension(45, 25),
                        new Dimension(45, 25), 0, false));
        if (isChar)
            textField.setText(String.valueOf(number));
    }

    public void createInputPanel(){
        arrPanels = new ArrayList<>();
        inputPanel = Components.createJPanel(4, 17);
        backButton = Components.createJButton("Назад", this);
        nextButton = Components.createJButton("Далее", this);
        JSpinner spinner = Components.createSpinner(1, DEFAULT - 1, now, this);
        JPanel textPanel = Components.createJPanel(DEFAULT + 1, 1);
        JPanel jPanel1 = Components.createJPanel(1, 2);
        JPanel jPanel2 = Components.createJPanel(1, 3);

        JScrollPane scrollPane = new JScrollPane();
        addPanel(inputPanel, jPanel2, 0, 0);
        addSpacer(jPanel2, 0, null);
        addLabel(jPanel2, "Кол-во:", 1);
        addSpinner(jPanel2, spinner);

        addPanel(inputPanel, jPanel1, 0, 1);
        addButton(jPanel1, backButton, 0);
        addButton(jPanel1, nextButton, 1);

        addSpacer(inputPanel, 4, null);
        addScrollPane(inputPanel, scrollPane);
        scrollPane.setViewportView(textPanel);
        addInput(textPanel, now);
    }

    private void addInput(JPanel textPanel, int now){
        addSpacer(textPanel, 0, new Dimension(20, 0));
        JPanel jPanel3 = Components.createJPanel(1, 4);
        addPanel(textPanel, jPanel3, 0, 0);
        addSpacer(jPanel3, 1, null);
        addLabel(jPanel3, "Символ:", 0);
        addLabel(jPanel3, "Вер-сть:", 2);
        addSpacer(jPanel3, 2, new Dimension(160, 0));
        addSpacer(textPanel);

        for (int i = 1; i < DEFAULT; i++){
            addChance(textPanel, i);
            if (i <= now ){
                arrPanels.get(i - 1 ).setVisible(true);
            }
        }
    }

    private void addChance(JPanel textPanel, int i){
        JPanel jPanel4 = Components.createJPanel(1, 4);
        addPanel(textPanel, jPanel4, i, 0);
        addTextField(jPanel4, 1, true, i);
        addTextField(jPanel4, 2, false, 0);
        arrPanels.add(jPanel4);
        addSpacer(jPanel4, 3, new Dimension(50, 0));
        jPanel4.setVisible(false);
    }

    private ArrayList<Double> prepareToValidate(){
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < now; i++){
            arrayList.add(Double.parseDouble(((JTextField) arrPanels.get(i).getComponent(1)).getText()));
        }
        return arrayList;
    }

    private LinkedList<Data> prepareModelList(){
        LinkedList<Data> chanceModels = new LinkedList<>();
        for (int i = 0; i < now; i++){
            double chance = Double.parseDouble(((JTextField) arrPanels.get(i).getComponent(1)).getText());
            String mChar = (((JTextField) arrPanels.get(i).getComponent(0)).getText());
            chanceModels.add(new Data(chance, mChar, i));
        }
        return chanceModels;
    }

    private boolean flag;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton){
            ValidationUI validation = new ValidationUI(prepareToValidate());
            if (validation.isValid()){
                listener.OnInput(true, prepareModelList());
            }
            else {
                if (!flag) {
                    JOptionPane.showMessageDialog(new Frame(), "Сумма равна: " + validation.getWrongSum());
                    flag = true;
                }
                else
                    flag = false;
            }
        }
        if (e.getSource() == backButton){
            listener.OnInput(false, null);
        }
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        JSpinner spinner = (JSpinner) e.getSource();
        if (((int) spinner.getValue()) > now) {
            now = (int) spinner.getValue();
            arrPanels.get(now - 1).setVisible(true);
        } else if (((int) spinner.getValue()) < now) {
            now = (int) spinner.getValue();
            System.out.println(now);
            ((JTextField) arrPanels.get(now).getComponent(0)).setText(String.valueOf((now + 1)));
            ((JTextField) arrPanels.get(now).getComponent(1)).setText("0.");
            arrPanels.get(now).setVisible(false);
        }
    }
}
