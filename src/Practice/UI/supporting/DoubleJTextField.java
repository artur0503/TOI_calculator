package Practice.UI.supporting;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class DoubleJTextField extends JTextField {

    DoubleJTextField(){
        addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                //TODO:Решить проблему с "0."
                char ch = e.getKeyChar();
                if (!isNumber(ch) && !isValidSignal(ch) && !validatePoint(ch)  && ch != '\b' && !getText().contains("0.")) {
                    e.consume();
                } else {
                    if (getText().length() > 4) {
                        e.consume();
                    }
                }
            }
        });

    }

    private boolean isNumber(char ch){
        return ch >= '0' && ch <= '9';
    }

    private boolean isValidSignal(char ch){
        if( (getText() == null || "".equals(getText().trim()) ) && ch == '-'){
            return true;
        }

        return false;
    }

    private boolean validatePoint(char ch){
        if(getText() == null || "0".equals(getText().trim()) || ".".equals(getText().trim()) || "".equals(getText().trim())){
            setText("0.");
            return false;
        }
        if (getText().contains("0.")) {
            setText("0.");
            return false;
        }
        return ch == '.';
    }
}