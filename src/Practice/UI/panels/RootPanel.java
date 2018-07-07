package Practice.UI.panels;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RootPanel {

    private JPanel rootPanel;


    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void createRootPanel(){
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(1, 1,
                new Insets(0, 0, 0, 0), -1, -1, true, true));
        rootPanel.setForeground(new Color(-1));
        rootPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(-1)), null,
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, new Color(-1)));

        String info = " Харьковский университет имени В. Н. Каразина, ФКН, кафедра ТПС, 2018г.";
        rootPanel.add(createDevelopInfo(info),
                new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_SOUTHEAST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));

    }

    private JLabel createDevelopInfo(String text){
        JLabel label = new JLabel();
        Font label1Font = new Font("Arial", Font.PLAIN, 10);
        label.setFont(label1Font);
        label.setText(text);
        return label;
    }

}
