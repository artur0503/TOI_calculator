package App.UI.panels.functional.arithmetic;

import App.core.classes.model.POJO.Data;
import App.core.interfaces.controller.ControllerFormulas;
import App.UI.supporting.Components;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ArithmeticDecodingPanel {

    private JPanel rootPanel;

    public void createArithmDecoding(String text, LinkedList<Data> input, LinkedList<Data> draw, ControllerFormulas formulas){
        rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));
        rootPanel.setBorder(Components.createTitleBorder(text));
    }

}
