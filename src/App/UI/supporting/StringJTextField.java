package App.UI.supporting;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class StringJTextField extends JTextField {

    StringJTextField() {
        addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (getText().length() > 3) {
                    e.consume();
                }
            }
        });
    }
}
