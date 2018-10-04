package App.UI.supporting;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class IntegerJTextField extends JTextField {

    IntegerJTextField(){
        addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                if (!isNumber(ch)) {
                    e.consume();
                }
            }
        });

    }

    private boolean isNumber(char ch){
        return ch >= '0' && ch <= '9';
    }

}