package Practice.UI.supporting;

import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.NumberFormat;

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
        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        button.setFont(buttonFont);
        button.setHideActionText(true);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setText(text);
        button.addActionListener(actionListener);
        return button;
    }

    public static JSpinner createSpinner(int min, int max, int defValue, ChangeListener listener){
        JSpinner spinner = new JSpinner();
        SpinnerModel numbers = new SpinnerNumberModel(defValue, min, max, 1);
        spinner.setFont(new Font("Arial", Font.PLAIN, 14));
        spinner.setForeground(Color.cyan);
        spinner.setModel(numbers);
        spinner.addChangeListener(listener);
        return spinner;
    }

    public static JLabel createLabel(String text){
        JLabel jLabel = new JLabel();
        jLabel.setForeground(new Color(-16777216));
        Font font = new Font("Arial", Font.PLAIN, 16);
        jLabel.setFont(font);
        jLabel.setText(text);
        return jLabel;
    }

    public static JPanel createJPanel(int row, int column){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayoutManager(row, column,
                new Insets(0, 0, 0, 0), -1, -1));
        return panel;
    }

    public static JTextField createJTextField(boolean isChar){
        JTextField textField;
        if (!isChar) {
            textField = new DoubleJTextField();
            textField.setText("0.");
        }
        else {
            textField = new StringJTextField();
            textField.setText("X");
        }
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setForeground(new Color(-16777216));
        return textField;
    }


}
