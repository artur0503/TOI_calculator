package App.UI.panels.functional.binary;

import App.UI.supporting.DrawingPanel;
import App.core.classes.model.models.Data;
import App.core.interfaces.controller.ControllerFormulas;
import App.UI.listeners.OnClickListener;
import App.UI.listeners.OnInputListener;
import App.UI.supporting.Components;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryCodingPanel implements ActionListener {

    private JPanel rootPanel;
    private DrawingPanel drawingPanel;

    private JTextArea codingResultsTextArea;
    private JTextArea formulaResultTextArea;
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

    private LinkedList<Data> getDataList() {
        return dataList;
    }

    private void setDataList(LinkedList<Data> dataList) {
        this.dataList = dataList;
    }

    public void setOnInputListener(OnInputListener listener) {
        this.listener1 = listener;
    }

    public void setOnClickListener(OnClickListener listener2) {
        this.listener2 = listener2;
    }

    public JPanel getRootPanel() {
        return rootPanel;
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

    private void addInfoPanel(JPanel parentPanel, JPanel panel, JPanel drawingPanel, int row, int column, Dimension dim){
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
        codingResultScroll.setViewportView(drawingPanel);
    }

    private void addLabelPanel(JPanel rootPanel){
        JPanel panel = Components.createJPanel(7, 1);
        rootPanel.add(panel,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        addSpacer(panel, 0, 0, new Dimension(0, 25));
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

    private void addButtonPanel(JPanel rootPanel, int countIter){
        JPanel panel = Components.createJPanel(4, 1);
        rootPanel.add(panel,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

//        addSpacer(panel, 1, 0, new Dimension(0, 0));

        JPanel panel1 = Components.createJPanel(1, 2);
        panel.add(panel1,
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        prevStepButton = Components.createJButton("<", this);
        addButton(panel1, prevStepButton, 0, 0, new Dimension(70, 30));
        nextStepButton = Components.createJButton(">", this);
        addButton(panel1, nextStepButton, 0, 1, new Dimension(70, 30));

        JPanel panel4 = Components.createJPanel(1, 2);
        panel.add(panel4,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

//        JLabel label = Components.createLabel("Кол-во итераций:" + countIter);

        addLabel(panel4,("Итерации: " + countIter));

        JPanel panel2 = Components.createJPanel(1, 2);
        panel.add(panel2,
                new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        backButton = Components.createJButton("Назад", this);
        addButton(panel2, backButton, 0, 0, new Dimension(90, 40));

        homeButton = Components.createJButton("Меню", this);
        addButton(panel2, homeButton, 0, 1, new Dimension(90, 40));


        JPanel panel3 = Components.createJPanel(1, 2);
        panel.add(panel3,
                new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        decodingButton = Components.createJButton("ОК", this);
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

    private String convertListToString(LinkedList<Data> input){
        String str = "";
        for (Data data : input){
            str = str + "\n  " + data.getNameS() + " (" + data.getChance() + ")  " + data.getCodeBinary();
        }
        return str;
    }

    private void createResultPanel(JPanel rootPanel, LinkedList<Data> input, ControllerFormulas formulas){
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(
                new GridLayoutManager(2, 1,
                        new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(resultPanel, BorderLayout.EAST);

        codingResultsTextArea = Components.createJTextArea(convertListToString(input));
        JPanel codingResultPanel = Components.createJPanel(2, 1);
        addPanel(resultPanel, codingResultPanel, codingResultsTextArea, 0, new Dimension(190, 360));
        addLabel(codingResultPanel, "Результат кодирования");

        formulaResultTextArea = Components.createJTextArea("\n  "
                + formulas.resCountMessage() + "\n\n  "
                + formulas.resMaxEntropy() + "\n\n  "
                + formulas.resEntropy() + "\n\n  "
                + formulas.resAverageLength() + "\n\n  "
                + formulas.resRedundancy());
        JPanel formulasResultPanel = Components.createJPanel(2, 1);
        addPanel(resultPanel, formulasResultPanel, formulaResultTextArea, 1, new Dimension(190, 210));
        addLabel(formulasResultPanel, "Результат");
    }

    private void createInfoPanel(JPanel rootPanel, HashMap<Integer, String[]> draw, LinkedList<Data> list){
        JPanel infoPanel = Components.createJPanel(3, 1);
        rootPanel.add(infoPanel, BorderLayout.CENTER);

        JPanel codingPanel = Components.createJPanel(2, 1);

        //TODO:CREATE PANEL RECOGNIZE

        drawingPanel = drawingPanel(list, draw);

        addInfoPanel(infoPanel, codingPanel, drawingPanel, 1, 0, new Dimension(785, 360));
        addLabel(infoPanel, "Кодирование");


        JPanel formulasInfoPanel = Components.createJPanel(1, 3);
        infoPanel.add(formulasInfoPanel,
                new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        formulaTextArea = Components.createJTextArea("\n  N = кол-во собщений\n\n" +
                "  H(X)max = log(N)\n\n" +
                "  H(X) = -∑ (p(xi) * log(xi)\n\n" +
                "  m ср = ∑ p(xi) * mi\n" +
                "         \n" +
                "  R = H(x)max - H(x) / H(x)max");
        JPanel formulasPanel = Components.createJPanel(2, 1);
        addInfoPanel(formulasInfoPanel, formulasPanel,formulaTextArea, 0, 2, new Dimension(250, 210));
        addLabel(formulasPanel, "Характеристики Кода");
        addLabelPanel(formulasInfoPanel);
        addButtonPanel(formulasInfoPanel, getCountIteration(list));
    }

    private HashMap<Integer, String[]> logicDrawing(LinkedList<String[]> draw) {
        HashMap<Integer, String[]> drawMap = new HashMap<>();
        if (draw != null)
            for (int i = 0; i < draw.size(); i++){
                drawMap.put(i + 3, draw.get(i));
            }
        return drawMap;
    }

    public DrawingPanel drawingPanel(LinkedList<Data> list, HashMap<Integer, String[]> draw){
        return null;
    }

    public int getCountIteration(LinkedList<Data> linkedList){
        return 0;
    }

    private int getIterationMax() {
        return iterationMax;
    }

    protected void setIterationMax(int iterationMax) {
        this.iterationMax = iterationMax;
    }

    public void createPanel(String text, LinkedList<Data> input, LinkedList<String[]> draw, ControllerFormulas formulas){
        setDataList(input);
        rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));
        rootPanel.setBorder(Components.createTitleBorder(text));
        createResultPanel(rootPanel, input, formulas);
        createInfoPanel(rootPanel, logicDrawing(draw), input);
    }

    private int iterationNow = 0;
    private int iterationMax;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            listener2.onClick(false, MAIN_MENU);
        }
        else if (e.getSource() == homeButton){
            listener2.onClick(false, INPUT_MENU);
        }
        else if (e.getSource() == prevStepButton){
            if (iterationNow != 0){
                drawingPanel.getIteration(--iterationNow);
            }
        }
        else if (e.getSource() == nextStepButton){
            if (iterationNow != getIterationMax()){
                drawingPanel.getIteration(++iterationNow);
            }
        }
        else if (e.getSource() == decodingButton){
            listener1.OnInput(true, getDataList());
        }
    }
}
