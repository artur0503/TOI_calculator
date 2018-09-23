package Practice.UI.panels.functional;

import App.core.classes.model.POJO.Data;
import Practice.UI.listeners.OnClickListener;
import Practice.UI.listeners.OnInputListener;
import Practice.UI.supporting.Components;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class HuffmanPanel implements ActionListener {

    private JPanel huffmanPanel;

    private JTextArea codingResultsTextArea;
    private JTextArea formulaResultTextArea;
    private JTextArea codingTextArea;
    private JTextArea formulaTextArea;
    private JButton nextStepButton;
    private JButton prevStepButton;
    private JButton backButton;
    private JButton homeButton;
    private JButton decodingButton;

    private String[] stringArr = new String[]{
            "1. Кол-во сообщений N",
            "2. Макс. энтропия H(x)max",
            "3. Энтропия H(x)",
            "4. Ср. длинна кодовых сообщений m cp",
            "5. Избыточность R"
    };
    private OnInputListener listener1;
    private OnClickListener listener2;

    public static final int INPUT_MENU = 4129;
    public static final int MAIN_MENU = 5894;

    private LinkedList<Data> dataList;

    public HuffmanPanel(LinkedList<Data> dataList) {
        this.dataList = dataList;
    }

    public HuffmanPanel() {
    }

    public LinkedList<Data> getDataList() {
        return dataList;
    }

    public void setOnInputListener(OnInputListener listener) {
        this.listener1 = listener;
    }

    public void setOnClickListener(OnClickListener listener2) {
        this.listener2 = listener2;
    }

    public JPanel getHuffmanPanel() {
        return huffmanPanel;
    }

    private void addSpacer(JPanel panel, int row, int column, Dimension size){
        panel.add(Components.createSpacer(),
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1,
                        size, size, size, 0, false));
    }

    private void addLabel(JPanel panel, String text){
        JPanel labelChancePanel = new JPanel();
        labelChancePanel.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(labelChancePanel,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK, GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        null, null, null, 0, false));

        JLabel label =  Components.createLabel(text);

        labelChancePanel.add(label,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK, GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        null, null, null, 0, false));

        addSpacer(labelChancePanel, 0, 0, null);
        addSpacer(labelChancePanel, 0, 2, null);
    }

    private void addPanel(JPanel parentPanel, JPanel panel, JTextArea textArea, int row, Dimension dim){
        parentPanel.add(panel,
                new GridConstraints(row, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        JScrollPane codingResultScroll = new JScrollPane();
        panel.add(codingResultScroll,
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        dim, dim, dim, 1, false));
        codingResultScroll.setViewportView(textArea);
    }

    private void addInfoPanel(JPanel parentPanel, JPanel panel, JTextArea textArea, int row, int column, Dimension dim){
        parentPanel.add(panel,
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        JScrollPane codingResultScroll = new JScrollPane();
        panel.add(codingResultScroll,
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        dim, dim, dim, 1, false));
        codingResultScroll.setViewportView(textArea);
    }

    private void addLabelPanel(JPanel rootPanel){
        JPanel panel = Components.createJPanel(7, 1);
        rootPanel.add(panel,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        addSpacer(panel, 0, 0, new Dimension(0, 27));
        int i = 1;
        while(i <= 5){
            addLabel(panel, i, stringArr[i - 1]);
            i++;
        }

    }

    private void addButton(JPanel panel, JButton button, int row, int column, Dimension dim){
        panel.add(button,
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        dim, dim, dim, 0, false));
    }

    private void addButtonPanel(JPanel rootPanel){
        JPanel panel = Components.createJPanel(4, 1);
        rootPanel.add(panel,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        addSpacer(panel, 1, 0, new Dimension(0, 40));

        JPanel panel1 = Components.createJPanel(1, 2);
        panel.add(panel1,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        prevStepButton = Components.createButton("<", this);
        addButton(panel1, prevStepButton, 0, 0, new Dimension(90, 40));
        nextStepButton = Components.createButton(">", this);
        addButton(panel1, nextStepButton, 0, 1, new Dimension(90, 40));


        JPanel panel2 = Components.createJPanel(1, 2);
        panel.add(panel2,
                new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        backButton = Components.createButton("Назад", this);
        addButton(panel2, backButton, 0, 0, new Dimension(90, 40));
        homeButton = Components.createButton("Вариант", this);
        addButton(panel2, homeButton, 0, 1, new Dimension(90, 40));



        JPanel panel3 = Components.createJPanel(1, 2);
        panel.add(panel3,
                new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        decodingButton = Components.createButton("ОК", this);
        addButton(panel3, decodingButton, 0, 1, new Dimension(75, 30));
        addLabel(panel3, "Декодировать?");

    }

    private void addLabel(JPanel panel, int i, String text){
        panel.add(Components.createLabel(text),
                new GridConstraints(i + 1, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null, 0, false));
        panel.add(Components.createSpacer(),new GridConstraints(i, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null, 0, false));
    }

    private void createResultPanel(JPanel rootPanel){
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(
                new GridLayoutManager(2, 1,
                        new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(resultPanel, BorderLayout.EAST);

        codingResultsTextArea = Components.createJTextArea("\n  fefsgg\n  erw\n  erew\n");
        JPanel codingResultPanel = Components.createJPanel(2, 1);
        addPanel(resultPanel, codingResultPanel, codingResultsTextArea, 0, new Dimension(230, 360));
        addLabel(codingResultPanel, "Результат кодирования");

        formulaResultTextArea = Components.createJTextArea("\n 1\n\n  2\n\n  3\n\n  4\n\n  5");
        JPanel formulasResultPanel = Components.createJPanel(2, 1);
        addPanel(resultPanel, formulasResultPanel, formulaResultTextArea, 1, new Dimension(230, 195));
        addLabel(formulasResultPanel, "Результат формул");
    }

    private void createInfoPanel(JPanel rootPanel){
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(
                new GridLayoutManager(3, 1,
                        new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(infoPanel, BorderLayout.CENTER);

        JPanel codingPanel = Components.createJPanel(2, 1);
        codingTextArea = Components.createJTextArea("efwfew");
        addInfoPanel(infoPanel, codingPanel, codingTextArea, 1, 0, new Dimension(720, 360));
        addLabel(infoPanel, "Кодирование");

        JPanel formulasInfoPanel = new JPanel();
        formulasInfoPanel.setLayout(new GridLayoutManager(1, 3,
                        new Insets(0, 0, 0, 0), -1, -1));

        infoPanel.add(formulasInfoPanel,
                new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        formulaTextArea = Components.createJTextArea("\n  1 Формула\n\n  2 Формула\n\n  3 Формула\n\n  4 Формула\n\n  5 Формула");
        JPanel formulasPanel = Components.createJPanel(2, 1);
        addInfoPanel(formulasInfoPanel, formulasPanel,formulaTextArea, 0, 2, new Dimension(230, 195));
        addLabel(formulasPanel, "Формулы");

        addLabelPanel(formulasInfoPanel);
        addButtonPanel(formulasInfoPanel);
    }

    public void createHuffmanPanel(){
        huffmanPanel = new JPanel();
        huffmanPanel.setLayout(new BorderLayout(0, 0));
        huffmanPanel.setBorder(Components.createTitleBorder("Метод Хаффмана"));
        createResultPanel(huffmanPanel);
        createInfoPanel(huffmanPanel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            listener2.onClick(false, MAIN_MENU);
        }
        else if (e.getSource() == homeButton){
            listener2.onClick(false, INPUT_MENU);
        }
        else if (e.getSource() == prevStepButton){
            //TODO:Предыдщий шаг
        }
        else if (e.getSource() == nextStepButton){
            //TODO:Следующий шаг
        }
        else if (e.getSource() == decodingButton){
            listener1.OnInput(true, getDataList());
        }
    }
}
