package Practice.UI.panels.functional.binary;

import App.core.classes.model.POJO.Data;
import Practice.UI.listeners.OnClickListener;
import Practice.UI.supporting.Components;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class BinaryDecodingPanel implements ActionListener {

    private JPanel binaryDecodingPanel;
    private JTextArea chanceArea;
    private JTextField inputTextField;
    private JButton okButton;
    private JPanel chancePanel;
    private JPanel functionsPanel;
    private JPanel inputTextPanel;
    private JButton homeButton;
    private JButton backButton;
    private JTextArea textArea1;
    private JPanel chanceLabelPanel;
    private JPanel resultPanel;
    private JPanel buttonPanel;

    public static final int INPUT_MENU = 4129;
    public static final int MAIN_MENU = 5894;


    private OnClickListener listener;

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public JPanel getBinaryDecodingPanel() {
        return binaryDecodingPanel;
    }

    private void addButton(JPanel panel, int row, int column, String text){
        JButton button = Components.createButton(text, this);
        panel.add(button, new GridConstraints(row, column, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_FIXED,
                null, null, null, 0, false));

    }

    private void addScrollPane(JPanel panel, JScrollPane scrollPane){
        panel.add(scrollPane,
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
                        new Dimension(150, 500), new Dimension(150, 500), new Dimension(150, 500), 0, false));
    }

    private void addSpacer(JPanel panel, int row, int column, Dimension size){
        panel.add(Components.createSpacer(),
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1,
                        size, size, size, 0, false));
    }

    private void addPanel(JPanel rootPanel, JPanel panel, int row, int column){
        rootPanel.add(panel,
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

    }

    private void addLabel(JPanel rootPanel, JLabel label, int row, int column){
        rootPanel.add(label,
                new GridConstraints(row, column, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));
    }

    private void createChancePanel(JPanel rootPanel, String chances){
        JPanel chancePanel = Components.createJPanel(2, 1);
        rootPanel.add(chancePanel, BorderLayout.WEST);
        JScrollPane scrollPane1 = new JScrollPane();
        addScrollPane(chancePanel, scrollPane1);
        JTextArea chanceArea = Components.createJTextArea(chances);
        scrollPane1.setViewportView(chanceArea);
        JPanel chanceLabelPanel = Components.createJPanel(1, 3);
        addPanel(chancePanel, chanceLabelPanel, 0, 0);
        JLabel label = Components.createLabel("Вероятности");
        addLabel(chanceLabelPanel, label, 0, 1);
        addSpacer(chanceLabelPanel, 0, 0, null);
        addSpacer(chanceLabelPanel, 0, 2, null);
    }

    private void createInputPanel(JPanel rootPanel){
        inputTextPanel = new JPanel();
        inputTextPanel.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        functionsPanel.add(inputTextPanel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        inputTextField = new JTextField();
        inputTextPanel.add(inputTextField, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        inputTextPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel1.add(spacer3, new GridConstraints(0, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Декодировать");
        panel1.add(label2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        panel1.add(spacer4, new GridConstraints(0, 2, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        inputTextPanel.add(panel2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

        addButton(panel2, 0, 1, "ОК");

        final Spacer spacer5 = new Spacer();
        panel2.add(spacer5, new GridConstraints(0, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        panel2.add(spacer6, new GridConstraints(0, 2, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));

    }

    private void createResultPanel(JPanel rootPanel){
        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        functionsPanel.add(resultPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane2 = new JScrollPane();
        resultPanel.add(scrollPane2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textArea1 = new JTextArea();
        scrollPane2.setViewportView(textArea1);
        final Spacer spacer7 = new Spacer();
        resultPanel.add(spacer7, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));

    }

    private void createButtonPanel(JPanel rootPanel){
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        functionsPanel.add(buttonPanel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        homeButton = new JButton();
        homeButton.setText("Button");
        buttonPanel.add(homeButton, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        buttonPanel.add(spacer8, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer9 = new Spacer();
        buttonPanel.add(spacer9, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setText("Button");
        buttonPanel.add(backButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer10 = new Spacer();
        functionsPanel.add(spacer10, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer11 = new Spacer();
        functionsPanel.add(spacer11, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    private String convertListToString(LinkedList<Data> input){
        String str = "";
        for (Data data : input){
            str = str + "\n  " + data.getNameS() + " " + data.getCodeBinary();
        }
        return str;
    }

    public void createDecoding(LinkedList<Data> data, String title) {
        binaryDecodingPanel = new JPanel();
        binaryDecodingPanel.setLayout(new BorderLayout(0, 0));
        binaryDecodingPanel.setBorder(BorderFactory.createTitledBorder(title));



        functionsPanel = new JPanel();
        functionsPanel.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        functionsPanel.setPreferredSize(new Dimension(400, 400));
        functionsPanel.setRequestFocusEnabled(false);
        binaryDecodingPanel.add(functionsPanel, BorderLayout.CENTER);

        createChancePanel(binaryDecodingPanel, convertListToString(data));
        createInputPanel(binaryDecodingPanel);
        createResultPanel(binaryDecodingPanel);
        createButtonPanel(binaryDecodingPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
