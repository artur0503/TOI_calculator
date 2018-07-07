package Practice.UI.panels;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {

    private JPanel menuPanel;
    private JButton huf;
    private JButton shen;
    private JButton arithm;
    private JButton arithmDec;

    private String title;


    public MenuPanel(String title) {
        this.title = title;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public void createMenuPanel(){
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayoutManager(4, 1,
                new Insets(0, 0, 0, 0), -1, -1));

        /*create label and add it to menu panel*/
        menuPanel.add(createTitleLabel(title),
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));


        /*create spacer and add it to menu panel*/
        menuPanel.add(createSpacer(),
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, 1,
                        GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 10),
                        new Dimension(-1, 30), new Dimension(-1, 100), 0, false));

        /*create panel for buttons and add it to menu panel*/
        JPanel jPanel = createJPanel();
        menuPanel.add(jPanel,
                new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        /*create buttons and add it to menu panel*/
        addButtons(jPanel);

        /*create spacer and add it to menu panel*/
        menuPanel.add(createSpacer(),
                new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, 1,
                        GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 40),
                        new Dimension(-1, 40), new Dimension(-1, 40), 0, false));


    }

    private void addButtons(JPanel jPanel){

        huf = createButton("Метод Хаффмана");
        jPanel.add(huf,
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1),
                        new Dimension(300, -1), new Dimension(400, -1), 0, false));


        shen = createButton("Метод Шеннона-Фано");
        jPanel.add(shen,
                new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), new Dimension(300, -1),
                        new Dimension(400, -1), 0, false));


        arithm = createButton("Арифметическое кодирование");
        jPanel.add(arithm,
                new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1),
                        new Dimension(300, -1), new Dimension(400, -1), 0, false));


        arithmDec = createButton("Арифметическое декодирование");
        jPanel.add(arithmDec,
                new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), new Dimension(300, -1),
                        new Dimension(400, -1), 0, false));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == huf){
            listener.onClick(true);
        }
        else if (e.getSource() == shen){
            listener.onClick(true);
        }
        else if (e.getSource() == arithm){
            listener.onClick(true);
        }
        else if (e.getSource() == arithmDec){
            listener.onClick(true);
        }
    }

    private JLabel createTitleLabel(String title){
        JLabel label = new JLabel();
        label.setBackground(new Color(-12070914));
        Font label1Font = new Font("Arial", Font.BOLD, 22);
        label.setFont(label1Font);
        label.setForeground(new Color(-16777216));
        label.setText(title);
        return label;
    }

    private JPanel createJPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayoutManager(4, 1,
                new Insets(0, 0, 0, 0), -1, -1));
        return panel;
    }

    private Spacer createSpacer(){
        return new Spacer();
    }

    private JButton createButton(String text){
        JButton button = new JButton();
        button.setBackground(new Color(-12070914));
        Font huffButtonFont = new Font("Arial", Font.PLAIN, 16);
        button.setFont(huffButtonFont);
        button.setHideActionText(true);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setText(text);
        button.addActionListener(this);
        return button;
    }

    public interface OnMenuClickListener{
        void onClick(boolean flag);
    }

    private OnMenuClickListener listener;

    public void setOnMenuClickListener(OnMenuClickListener listener) {
        this.listener = listener;
    }
}
