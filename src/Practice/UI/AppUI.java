package Practice.UI;

import App.core.classes.model.POJO.Data;
import App.core.interfaces.view.BaseView;
import Practice.UI.panels.RootPanel;
import Practice.UI.panels.functional.InputPanel;
import Practice.UI.panels.menu.OptionsPanel;
import Practice.UI.panels.menu.MenuPanel;
import Testing.Test;
import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;

public class AppUI extends JFrame implements BaseView, WindowListener {

    @Override
    public void execute() {
        setVisible(true);
        RootPanel rootPanel = new RootPanel();
        rootPanel.createRootPanel();
        add(rootPanel.getRootPanel());
        optionsMenuScreen(rootPanel.getRootPanel());
    }

    @Override
    public void afterAction() {

    }

    @Override
    public void setInputData(LinkedList<Data> list) {

    }

    @Override
    public LinkedList getInputData() {
        return null;
    }

    public AppUI() {
        this.addWindowListener(this);
        setTitle("TOI Calculator");
        setSize(700, 500);
        setResizable(false);
    }

    private void optionsMenuScreen(final JPanel rootPanel){
        OptionsPanel optionsPanel = new OptionsPanel("Выберите вариант:");
        optionsPanel.createOptionsPanel();
        optionsPanel.setOnMenuClickListener((flag, name) -> {
            if (flag){
                optionsPanel.getInputPanel().setVisible(false);
                if (name == OptionsPanel.INPUT){
                    setSize(350, 500);
                    optionsPanel.getInputPanel().setVisible(false);
                    inputScreen(rootPanel);
                }
                else if (name == OptionsPanel.VAR_1) {
                    //OPEN MAIN MENU WITH VAR_1
                    setInputData(new Test().test0());
                    mainMenuScreen(rootPanel, optionsPanel.getInputPanel(), "Вариант 1", getInputData());
                }
                else if (name == OptionsPanel.VAR_2){
                    //OPEN MAIN MENU WITH VAR_2
                    setInputData(new Test().test0());
                    mainMenuScreen(rootPanel, optionsPanel.getInputPanel(), "Вариант 2", getInputData());
                }
                else if (name == OptionsPanel.VAR_3){
                    //OPEN MAIN MENU WITH VAR_3
                    setInputData(new Test().test0());
                    mainMenuScreen(rootPanel, optionsPanel.getInputPanel(), "Вариант 3", getInputData());
                }
            }
        });
        rootPanel.add(optionsPanel.getInputPanel(),
                new GridConstraints(
                        0, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH,
                        GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false
                ));
    }

    private void mainMenuScreen(JPanel rootPanel, JPanel inputPanel, String var, LinkedList<Data> inputData){
        MenuPanel menuPanel = new MenuPanel(inputData, "<html>Алгоритмы сжатия информации<br> "+ var + "</html>");
        menuPanel.createMenuPanel();
        menuPanel.setOnMenuClickListener((flag, name) -> {
            if (flag){
                menuPanel.getMenuPanel().setVisible(false);
                setSize(1000, 700);
                if (name == MenuPanel.HUFFMAN){
                    //OPEN HUFFMAN
                }
                else if (name == MenuPanel.SHENON) {
                    //OPEN SHENON
                }
                else if (name == MenuPanel.ARITHMETIC){
                    //OPEN ARITHMETIC
                }
                else if (name == MenuPanel.ARITHM_DECODING){
                    //OPEN DECODING
                }
            }
            else {
                menuPanel.getMenuPanel().setVisible(false);
                inputPanel.setVisible(true);
            }
        });
        rootPanel.add(menuPanel.getMenuPanel(),
                new GridConstraints(
                        0, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH,
                        GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false
                ));
    }

    private void inputScreen(JPanel rootPanel){
        InputPanel inputPanel = new InputPanel();
        inputPanel.createInputPanel();
        rootPanel.add(inputPanel.getInputPanel(),
                new GridConstraints(
                        0, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH,
                        GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false
                ));
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    //close app
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
