package Practice.UI.panels.functional;

import Practice.UI.supporting.Components;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;

public class HuffmanPanel {

    private JPanel huffmanPanel;
    private JPanel resultPanel;
    private JPanel infoPanel;
    private JPanel codingResultPanel;
    private JPanel formulasResultPanel;
    private JPanel codingPanel;
    private JPanel formulasInfoPanel;

    private JTextArea codingResults;
    private JTextArea formulaResult;

    private JScrollPane codingResultScroll;
    private JScrollPane formulasResultScroll;

    public JPanel getHuffmanPanel() {
        return huffmanPanel;
    }

    private void addSpacer(JPanel panel, int column, Dimension size){
        panel.add(Components.createSpacer(),
                new GridConstraints(0, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1,
                        size, size, size, 0, false));
    }

    private void addLabel(JPanel panel, String text){
        JPanel labelChancePanel = new JPanel();
        labelChancePanel.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(labelChancePanel,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        JLabel label =  Components.createLabel(text);

        labelChancePanel.add(label,
                new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        addSpacer(labelChancePanel, 0, null);
        addSpacer(labelChancePanel, 2, null);
    }

    private void addResultPanel(JPanel parentPanel, JPanel panel, JTextArea textArea, int row, Dimension dim){
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

    public HuffmanPanel() {
        huffmanPanel = new JPanel();
        huffmanPanel.setLayout(new BorderLayout(0, 0));
        huffmanPanel.setBorder(BorderFactory.createTitledBorder(""));

        resultPanel = new JPanel();
        resultPanel.setLayout(
                new GridLayoutManager(2, 1,
                        new Insets(0, 0, 0, 0), -1, -1));
        huffmanPanel.add(resultPanel, BorderLayout.EAST);

        codingResults = new JTextArea();
        codingResults.setText("");
        codingResultPanel = Components.createJPanel(2, 1);
        addResultPanel(resultPanel, codingResultPanel, codingResults, 0, new Dimension(230, 340));
        addLabel(codingResultPanel, "Результат кодирования");


        formulaResult = new JTextArea();
        formulaResult.setText("");
        formulasResultPanel = Components.createJPanel(2, 1);
        addResultPanel(resultPanel, formulasResultPanel, formulaResult, 1, new Dimension(230, 170));
        addLabel(formulasResultPanel, "Результат формул");


        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        huffmanPanel.add(infoPanel, BorderLayout.CENTER);


        
        codingPanel = new JPanel();
        codingPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        infoPanel.add(codingPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        formulasInfoPanel = new JPanel();
        formulasInfoPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        infoPanel.add(formulasInfoPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        formulasInfoPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        formulasInfoPanel.add(panel2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }
}
