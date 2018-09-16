package Practice.UI.panels.menu;

import Practice.UI.listeners.OnClickListener;
import Practice.UI.supporting.Components;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsPanel implements ActionListener {

    public final static int INPUT = 1;
    public final static int VAR_1 = 2;
    public final static int VAR_2 = 3;
    public final static int VAR_3 = 4;

    private JPanel inputPanel;
    private JButton input;
    private JButton var1;
    private JButton var2;
    private JButton var3;

    private String title;
    private OnClickListener listener;

    public void setOnMenuClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public OptionsPanel(String title) {
        this.title = title;
    }

    public JPanel getInputPanel() {
        return inputPanel;
    }

    public void createOptionsPanel(){
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayoutManager(4, 1,
                new Insets(0, 0, 0, 0), -1, -1));

        /*create spacer and add it to menu panel*/
        inputPanel.add(Components.createSpacer(),
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, 1,
                        GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 10),
                        new Dimension(-1, 30), new Dimension(-1, 100), 0, false));

        /*create panel for buttons and add it to menu panel*/
        JPanel jPanel = Components.createJPanel(4, 1);
        inputPanel.add(jPanel,
                new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        /*create buttons and add it to menu panel*/
        addButtons(jPanel);

        /*create spacer and add it to menu panel*/
        inputPanel.add(Components.createSpacer(),
                new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, 1,
                        GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 40),
                        new Dimension(-1, 40), new Dimension(-1, 40), 0, false));

        /*create label and add it to menu panel*/
        inputPanel.add(Components.createTitleLabel(title),
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));



    }

    private void addButtons(JPanel jPanel){

        input = Components.createButton("Ручной ввод", this);
        jPanel.add(input,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1),
                        new Dimension(300, -1), new Dimension(400, -1), 0, false));


        var1 = Components.createButton("Вариант 1", this);
        jPanel.add(var1,
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), new Dimension(300, -1),
                        new Dimension(400, -1), 0, false));


        var2 = Components.createButton("Вариант 2", this);
        jPanel.add(var2,
                new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1),
                        new Dimension(300, -1), new Dimension(400, -1), 0, false));


        var3 = Components.createButton("Вариант 3", this);
        jPanel.add(var3,
                new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), new Dimension(300, -1),
                        new Dimension(400, -1), 0, false));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == input) {
            listener.onClick(true, INPUT);
        } else if (e.getSource() == var1) {
            listener.onClick(true, VAR_1);
        } else if (e.getSource() == var2) {
            listener.onClick(true, VAR_2);
        } else if (e.getSource() == var3) {
            listener.onClick(true, VAR_3);
        }
    }

}
