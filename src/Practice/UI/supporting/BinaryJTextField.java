package Practice.UI.supporting;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class BinaryJTextField extends JTextField {

    BinaryJTextField(){
        addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                //TODO:Решить проблему с "0."
                char ch = e.getKeyChar();
                if (!isNumber(ch)) {
                    e.consume();
                }
            }
        });

    }

    private boolean isNumber(char ch){
        return ch >= '0' && ch <= '1';
    }

}