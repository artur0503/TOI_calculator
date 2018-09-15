package Practice.UI.supporting;

import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Components {

    public static JLabel createTitleLabel(String title){
        JLabel label = new JLabel();
        label.setBackground(new Color(-12070914));
        Font label1Font = new Font("Arial", Font.BOLD, 22);
        label.setFont(label1Font);
        label.setForeground(new Color(-16777216));
        label.setText(title);
        return label;
    }

    public static Spacer createSpacer(){
        return new Spacer();
    }

    public static JButton createButton(String text, ActionListener actionListener){
        JButton button = new JButton();
        button.setBackground(new Color(-12070914));
        Font huffButtonFont = new Font("Arial", Font.PLAIN, 16);
        button.setFont(huffButtonFont);
        button.setHideActionText(true);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setText(text);
        button.addActionListener(actionListener);
        return button;
    }

    public static JPanel createJPanel(int row, int column){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayoutManager(row, column,
                new Insets(0, 0, 0, 0), -1, -1));
        return panel;
    }


}
