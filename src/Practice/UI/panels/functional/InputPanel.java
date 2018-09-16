package Practice.UI.panels.functional;

import Practice.UI.supporting.Components;
import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPanel implements ActionListener, ChangeListener {


    private final static int DEFAULT = 15;

    private int n = 5;

    private JPanel inputPanel;
    private JPanel charPanel;
    private JPanel chancePanel;
    private JPanel textPanel;


    private JButton backButton;
    private JButton nextButton;
    private JSpinner spinner;

    public JPanel getInputPanel() {
        return inputPanel;
    }

    private void addSpacer(JPanel panel, int row, int column){
        panel.add(Components.createSpacer(),
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1,
                        null, null, null, 0, false));
    }

    private void addButton(JPanel panel, JButton button, int column){

        panel.add(button,
                new GridConstraints(0, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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

    private void addSpinner(JPanel panel, JSpinner spinner){
        panel.add(spinner,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED,
                        new Dimension(40, 30),
                        new Dimension(40, 30),
                        new Dimension(40, 30),
                        0, false));
    }

    private void addScrollPane(JPanel panel, JScrollPane scrollPane){
        panel.add(scrollPane,
                new GridConstraints(2, 0, 1, 12,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        null, null, null, 0, false));

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
        inputPanel = Components.createJPanel(4, 17);
        backButton = Components.createButton("Назад", this);
        nextButton = Components.createButton("Далее", this);
        spinner = Components.createSpinner(0, 15, n - 1, this);
        JScrollPane scrollPane = new JScrollPane();
        charPanel = Components.createJPanel(DEFAULT, 1);
        chancePanel = Components.createJPanel(DEFAULT, 1);

        addLabel(inputPanel, "Кол-во:", 0, 0);
        addSpinner(inputPanel, spinner);
        addButton(inputPanel, backButton, 2);
        addButton(inputPanel, nextButton, 3);
        addSpacer(inputPanel, 0, 4);
        addSpacer(inputPanel, 0, 5);
        addSpacer(inputPanel, 0, 6);
        addSpacer(inputPanel, 0, 7);
        addScrollPane(inputPanel, scrollPane);
        addInput();
        scrollPane.setViewportView(textPanel);
    }

    private void addInput(){
        textPanel = Components.createJPanel(1, 2);
        addPanel(textPanel, charPanel, 0, 0);
        addPanel(textPanel, chancePanel, 0, 1);
        addLabel(charPanel, "Символ:", 0, 0);
        addLabel(chancePanel, "Вер-сть:", 0, 0);
        addSpacer(charPanel, n - 1, 0);
        addSpacer(chancePanel, n - 1, 0);
        addSpacer(inputPanel, 3, 0);

        for (int i = 1; i < n; i++){
            addTextField(charPanel, i, 0);
            addTextField(chancePanel, i, 0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {
    }
}
