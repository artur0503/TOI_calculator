package App.UI.panels.functional.arithmetic;

import App.UI.listeners.OnDecodingListener;
import App.UI.listeners.OnInputListener;
import App.UI.supporting.Components;
import App.UI.supporting.DrawingPanel;
import App.core.classes.model.POJO.Data;
import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ArithmeticPanel implements ActionListener, DocumentListener {

    private JPanel headerPanel;
    private JPanel labelPanel;
    private JPanel buttonPanel;
    private JPanel inputPanel;
    private JPanel resultPanel;
    private JPanel codingPanel;
    private JPanel functionalPanel;
    private JPanel infoListPanel;
    private JScrollPane scrollPane1;

    private JButton previousButton;
    private JButton nextButton;
    private JButton decodingButton;
    private JButton backButton;
    private JButton menuButton;
    private JButton okButton;

    private JPanel arithmeticPanel;
    private JPanel mainPanel;

    private JLabel codingResultLabel;
    private JTextField input;
    private JTextArea dataListTextArea;

    private OnInputListener listener1;
    private OnDecodingListener listener2;

    public static final String INPUT_MENU = "adi201i";
    public static final String MAIN_MENU = "fidelio210a";

    public void setOnInputListener(OnInputListener listener1) {
        this.listener1 = listener1;
    }

    public void setOnDecodingListener(OnDecodingListener listener2) {
        this.listener2 = listener2;
    }

    private void createResultPanel(){

    }

    private void createButtonPanel(){

    }

    private void createInfoPanel(JPanel panel1){
        headerPanel = Components.createJPanel(2,1);
        panel1.add(headerPanel,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        headerPanel.setBorder(BorderFactory.createTitledBorder(""));

        labelPanel = Components.createJPanel(1, 3);
        headerPanel.add(labelPanel,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        JLabel label1 = Components.createLabel("Введите фразу или комбинацию символов, которые необходимо закодировать:");

        labelPanel.add(label1,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED,
                        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));


        labelPanel.add(Components.createSpacer(),
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1,
                        null, null, null, 0, false));


        labelPanel.add(Components.createSpacer(),
                new GridConstraints(0, 2, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW,
                        1, null, null, null, 0, false));

        JPanel panel2 = Components.createJPanel(2, 1);
        headerPanel.add(panel2,
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        buttonPanel = Components.createJPanel(1, 5);
        panel2.add(buttonPanel,
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        okButton = Components.createJButton("OK", this);
        buttonPanel.add(okButton,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));
        okButton.setEnabled(false);

        buttonPanel.add(Components.createSpacer(),
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1,
                        null, null, null, 0, false));

        buttonPanel.add(Components.createSpacer(),
                new GridConstraints(0, 4, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1,
                        null, null, null, 0, false));

        backButton = Components.createJButton("Назад", this);
        buttonPanel.add(backButton,
                new GridConstraints(0, 2, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));

        menuButton = Components.createJButton("Меню", this);
        buttonPanel.add(menuButton,
                new GridConstraints(0, 3, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));

        inputPanel = Components.createJPanel(1, 3);
        panel2.add(inputPanel,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        input = Components.createInputJTextField();
        inputPanel.add(input,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED,
                        null, new Dimension(150, -1), null, 0, false));
        input.getDocument().addDocumentListener(this);

        inputPanel.add(Components.createSpacer(),
                new GridConstraints(0, 2, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        1, 1, new Dimension(40, 0),
                        new Dimension(40, 0), new Dimension(40, 0), 0, false));

        inputPanel.add(Components.createSpacer(),
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        1, 1, new Dimension(40, 0),
                        new Dimension(40, 0), new Dimension(40, 0), 0, false));

        mainPanel = Components.createJPanel(1, 1);
        panel1.add(mainPanel,
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));
        mainPanel.setBorder(Components.createPreTitleBorder("Результат"));

        JPanel panel4 = Components.createJPanel(2, 2);
        mainPanel.add(panel4,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        resultPanel = Components.createJPanel(3, 2);
        panel4.add(resultPanel,
                new GridConstraints(0, 0, 2, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        codingPanel = Components.createJPanel(1, 2);
        resultPanel.add(codingPanel,
                new GridConstraints(0, 0, 1, 2,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        new Dimension(750, 300), new Dimension(750, 300),
                        new Dimension(750, 300), 0, false));

        scrollPane1 = new JScrollPane();
        codingPanel.add(scrollPane1,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        null, null, null, 0, false));



        codingPanel.add(Components.createSpacer(),
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, 1, 1,
                        null, null, null, 0, false));


        functionalPanel = Components.createJPanel(1, 1);
        resultPanel.add(functionalPanel,
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        JPanel panel6 = Components.createJPanel(1, 7);
        functionalPanel.add(panel6,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        JPanel panel7 = Components.createJPanel(1, 2);
        panel6.add(panel7,
                new GridConstraints(0, 5, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        JLabel label2 = Components.createLabel("Результат кодирования:");
        panel7.add(label2,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));

        codingResultLabel = Components.createLabel("");
        panel7.add(codingResultLabel,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));

        JPanel panel8 = Components.createJPanel(1, 2);
        panel6.add(panel8,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        JLabel label4 = Components.createLabel("Декодировать?");
        panel8.add(label4,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));

        decodingButton = Components.createJButton("ОК", this);
        panel8.add(decodingButton,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));

        panel6.add(Components.createSpacer(),
                new GridConstraints(0, 6, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1,
                        null, null, null, 0, false));
        panel6.add(Components.createSpacer(),
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, 1, 1,
                        new Dimension(20, 0),
                        new Dimension(20, 0),
                        new Dimension(20, 0), 0, false));

        panel6.add(Components.createSpacer(),
                new GridConstraints(0, 4, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1,
                        null, null, null, 0, false));

        JPanel panel9 = Components.createJPanel(1,2);
        panel6.add(panel9,
                new GridConstraints(0, 3, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        previousButton = Components.createJButton("<", this);
        panel9.add(previousButton,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));

        nextButton = Components.createJButton(">", this);
        panel9.add(nextButton,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));

        panel6.add(Components.createSpacer(),
                new GridConstraints(0, 2, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1,
                        null, null, null, 0, false));

        resultPanel.add(Components.createSpacer(),
                new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1,
                        GridConstraints.SIZEPOLICY_WANT_GROW,
                        null, null, null, 0, false));

        infoListPanel = Components.createJPanel(1, 2);
        panel4.add(infoListPanel,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        new Dimension(200, 380), new Dimension(200, 380),
                        new Dimension(200, 380), 0, false));

        JScrollPane scrollPane2 = new JScrollPane();
        infoListPanel.add(scrollPane2,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        null, null, null, 0, false));

        dataListTextArea = Components.createJTextArea("");
        scrollPane2.setViewportView(dataListTextArea);

        infoListPanel.add(Components.createSpacer(),
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, 1, 1,
                        new Dimension(20, 0), new Dimension(20, 0),
                        new Dimension(20, 0), 0, false));

        panel4.add(Components.createSpacer(),
                new GridConstraints(1, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, 1,
                        new Dimension(0, 20), new Dimension(0, 20),
                        new Dimension(0, 20), 0, false));
    }

    public String getText(){
        return "АБВГД";
    }

    public JPanel getRootPanel() {
        return arithmeticPanel;
    }

    public void createArithmeticCoding(String title){
        arithmeticPanel = Components.createJPanel(2, 1);
        arithmeticPanel.setBorder(Components.createTitleBorder(title));
        createInfoPanel(arithmeticPanel);
        mainPanel.setVisible(false);
    }

    private LinkedList<Data> list;

    public void setData(double res, LinkedList<Data> list){
        if (res > 0) {
            codingResultLabel.setText(String.valueOf(res));
            dataListTextArea.setText(convertListToString(list));
            DrawingPanel arithmeticDrawingPanel = new ArithmeticDrawingPanel(list, list.size(), codingPanel.getSize(new Dimension()));
            scrollPane1.setViewportView(arithmeticDrawingPanel);
            arithmeticDrawingPanel.getIteration(0);
            this.list = list;
        }
        else {
            JOptionPane.showMessageDialog(new Frame(), "Неверные символы");
            mainPanel.setVisible(false);
        }
    }

    private String convertListToString(LinkedList<Data> input){
        String str = "";
        for (Data data : input){
            str = str + "\n  " + data.getNameS()
                    + " (" + data.getChance() + ")  "
                    + data.getInterval()[0] + " - " + data.getInterval()[1];
        }
        return str;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton){
            if (!input.getText().equals("")) {
                mainPanel.setVisible(true);
                listener2.OnDecoding(true, input.getText(), true);
            }
        }
        else if (e.getSource() == backButton){
            listener2.OnDecoding(false, MAIN_MENU, true);
        }
        else if (e.getSource() == menuButton){
            listener2.OnDecoding(false, INPUT_MENU, true);
        }
        else if (e.getSource() == decodingButton){
            listener1.OnInput(true, list);
        }
        else if (e.getSource() == previousButton){
            //TODO:PREVIOUS ITERATION
        }
        else if(e.getSource() == nextButton){
            //TODO:NEXT ITERATION
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if(input.getText().length() > 0){
            okButton.setEnabled(true);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (input.getText().length() == 0){
            okButton.setEnabled(false);
        }
        codingResultLabel.setText("");
        mainPanel.setVisible(false);
    }
    @Override
    public void changedUpdate(DocumentEvent e) {

    }


//    public void createResultPanel(JPanel rootPanel, LinkedList<Data> data){
////        HuffmanDrawingPanel panel = new HuffmanDrawingPanel(data, data.size());
////        arithmeticPanel.add(panel, BorderLayout.CENTER);
////        panel.setCharToDraw();
//    }



}
