package App.UI.panels.functional.arithmetic;

import App.UI.listeners.OnClickListener;
import App.UI.supporting.Components;
import App.UI.supporting.DrawingPanel;
import App.core.classes.model.models.Data;
import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ArithmeticDecodingPanel implements ActionListener, DocumentListener {

    private JPanel rootPanel;

    private JTextArea formulasTextArea;
    private JTextArea resultTextArea;
    private JButton previousButton;
    private JButton nextButton;
    private JButton backButton;
    private JButton menuButton;
    private JButton okButton;
    private JTextField countDecTextField;
    private JPanel workPanel;

    public static final int INPUT_MENU = 15;
    public static final int MAIN_MENU = 8;

    private OnClickListener listener;

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void createArithmDecoding(double res, LinkedList<Data> input){
        rootPanel = Components.createJPanel(2, 1);
        rootPanel.setBorder(Components.createTitleBorder("Арефметическое Декодирование"));
        createPanel(rootPanel, res, input);
        workPanel.setVisible(false);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createPanel(JPanel rootPanel, double res, LinkedList<Data> input){
        JPanel headerPanel = Components.createJPanel(3, 1);
        rootPanel.add(headerPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JPanel inputPanel = Components.createJPanel(1, 4);
        headerPanel.add(inputPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JPanel resLabelPanel = Components.createJPanel(1, 3);
        inputPanel.add(resLabelPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JLabel label1 = Components.createLabel("Результат кодирования:");
        resLabelPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel label2 = Components.createLabel(String.valueOf(res));
        resLabelPanel.add(label2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        resLabelPanel.add(Components.createSpacer(), new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));

        JPanel countPanel = Components.createJPanel(2, 1);
        inputPanel.add(countPanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        JPanel panel1 = Components.createJPanel(1, 1);
        countPanel.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        countDecTextField = Components.createIntegerJTextField();
        panel1.add(countDecTextField,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, 1,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(40, 20),
                        new Dimension(40, 20), new Dimension(40, 20),
                        0, false));
        countDecTextField.getDocument().addDocumentListener(this);

        JLabel label3 = Components.createLabel("<html><div style='text-align: center;'>Введите количество символов, которые необходимо<br>декодировать:</div></html>");
        countPanel.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        inputPanel.add(Components.createSpacer(), new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, 1, 1, new Dimension(30, 0), new Dimension(30, 0), new Dimension(30, 0), 0, false));

        inputPanel.add(Components.createSpacer(), new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, 1, 1, new Dimension(30, 0), new Dimension(30, 0), new Dimension(30, 0), 0, false));

        JPanel drawingPanel = Components.createJPanel(1, 1);
        headerPanel.add(drawingPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(720, 100), new Dimension(720, 100), new Dimension(720, 100), 0, false));

        JScrollPane drawingScroll = new JScrollPane();
        drawingPanel.add(drawingScroll, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));

        JPanel drawingPanel2 = Components.createJPanel(1, 1);
        drawingScroll.setViewportView(drawingPanel2);

        DrawingPanel drawingCustomPanel = new ArithmeticDrawingPanel(input, input.size(), new Dimension(drawingPanel2.getWidth(), drawingPanel2.getHeight()));
        drawingPanel2.add(drawingCustomPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        drawingCustomPanel.getIteration(2);

        JPanel buttonPanel = Components.createJPanel(1, 7);
        headerPanel.add(buttonPanel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        previousButton = Components.createJButton("<", this);
        buttonPanel.add(previousButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        previousButton.setVisible(false);

        nextButton = Components.createJButton(">", this);
        buttonPanel.add(nextButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nextButton.setVisible(false);


        buttonPanel.add(Components.createSpacer(), new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        buttonPanel.add(Components.createSpacer(), new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));

        okButton = Components.createJButton("OK", this);
        buttonPanel.add(okButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        okButton.setEnabled(false);

        backButton = Components.createJButton("Назад", this);
        buttonPanel.add(backButton, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        menuButton = Components.createJButton("Меню", this);
        buttonPanel.add(menuButton, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        workPanel = Components.createJPanel(1, 3);
        rootPanel.add(workPanel,
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        new Dimension(70, 300),
                        new Dimension(700, 300),
                        new Dimension(700, 300),
                        0, false));
        workPanel.setBorder(BorderFactory.createTitledBorder(""));

//        JPanel formulasPanel = Components.createJPanel(1, 1);
//        workPanel.add(formulasPanel,
//                new GridConstraints(0, 0, 1, 1,
//                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
//                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
//                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
//                        null, null, null, 0, false));

//        JScrollPane scrollPane1 = new JScrollPane();
//        formulasPanel.add(scrollPane1, new GridConstraints(0, 0, 1, 1,
//                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
//                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
//                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
//                null, null, null,
//                0, false));
//
//        formulasTextArea = Components.createJTextArea("");
//        scrollPane1.setViewportView(formulasTextArea);

        JPanel resultPanel = Components.createJPanel(1, 1);
        workPanel.add(resultPanel,
                new GridConstraints(0, 2, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        JScrollPane scrollPane2 = new JScrollPane();
        resultPanel.add(scrollPane2,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        null, null, null, 0, false));

        resultTextArea = Components.createJTextArea("");
        scrollPane2.setViewportView(resultTextArea);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton){
            if (Integer.parseInt(countDecTextField.getText()) == 0){
                workPanel.setVisible(false);
                JOptionPane.showMessageDialog(new Frame(), "Меньше 1");
            }
            else {
                if (Integer.parseInt(countDecTextField.getText()) <= 15){
                    listener.onClick(true, Integer.parseInt(countDecTextField.getText()));
                    workPanel.setVisible(true);
                    nextButton.setVisible(true);
                    previousButton.setVisible(true);
                    okButton.setVisible(false);
                }
                else {
                    workPanel.setVisible(false);
                    JOptionPane.showMessageDialog(new Frame(), "Больше 15");
                }
            }
        }
        else if (e.getSource() == nextButton){

        }
        else if (e.getSource() == previousButton){

        }
        else if (e.getSource() == backButton){
            listener.onClick(false, MAIN_MENU);
        }
        else if (e.getSource() == menuButton){
            listener.onClick(false, INPUT_MENU);
        }
    }

    public void setResult(String text){
        resultTextArea.setText(text);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (countDecTextField.getText().length() > 0) {
            okButton.setEnabled(true);
        }
        else {
            okButton.setEnabled(false);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        workPanel.setVisible(false);
        nextButton.setVisible(false);
        previousButton.setVisible(false);
        okButton.setVisible(true);
        if (countDecTextField.getText().length() == 0)
            okButton.setEnabled(false);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
