package App.UI.panels.functional.arithmetic;

import App.core.classes.model.POJO.Data;
import App.UI.listeners.OnClickListener;
import App.UI.listeners.OnInputListener;
import App.UI.supporting.Components;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ArithmeticPanel {

    private JPanel arithmeticPanel;
    private JTextArea codingResultsTextArea;
    private JTextArea formulaResultTextArea;
    private JButton nextStepButton;
    private JButton prevStepButton;
    private JButton backButton;
    private JButton homeButton;
    private JButton decodingButton;

    private OnInputListener listener1;
    private OnClickListener listener2;

    public static final int INPUT_MENU = 4129;
    public static final int MAIN_MENU = 5894;

    private void createButtonPanel(){

    }

    public String getText(){
        return "АБВГД";
    }

    public JPanel getArithmeticPanel() {
        return arithmeticPanel;
    }

    public void createArithmeticCoding(String title){
        arithmeticPanel = new JPanel();
        arithmeticPanel.setLayout(new BorderLayout(0, 0));
        arithmeticPanel.setBorder(Components.createTitleBorder(title));
        arithmeticPanel.setSize(new Dimension(500, 500));

    }

    private String convertListToString(LinkedList<Data> input){
        String str = "";
        for (Data data : input){
            str = str + "\n  " + data.getNameS()
                    + " (" + data.getCodeBinary() + ") "
                    + data.getInterval()[0] + "-" + data.getInterval()[1];
        }
        return str;
    }

//    public void createResultPanel(JPanel rootPanel, LinkedList<Data> data){
////        HuffmanDrawingPanel panel = new HuffmanDrawingPanel(data, data.size());
////        arithmeticPanel.add(panel, BorderLayout.CENTER);
////        panel.setCharToDraw();
//    }



}
