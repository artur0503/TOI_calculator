package Practice.UI;

import App.core.classes.model.POJO.Data;
import App.core.interfaces.view.BaseView;
import Practice.UI.listeners.OnClickListener;
import Practice.UI.listeners.OnInputListener;
import Practice.UI.panels.RootPanel;
import Practice.UI.panels.functional.HuffmanPanel;
import Practice.UI.panels.functional.InputPanel;
import Practice.UI.panels.menu.MenuPanel;
import Practice.UI.panels.menu.OptionsPanel;
import Testing.Test;
import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;

public class AppUI extends JFrame implements BaseView {

    private LinkedList<Data> list;
    private String var = "";

    @Override
    public void execute() {
        setVisible(true);
        RootPanel rootPanel = new RootPanel();
        rootPanel.createRootPanel();
        add(rootPanel.getRootPanel());
        optionsMenuScreen(rootPanel.getRootPanel());
        setResizable(false);
    }

    @Override
    public void afterAction() {

    }

    @Override
    public void setInputData(LinkedList<Data> list) {
        this.list = list;
    }

    @Override
    public LinkedList getInputData() {
        return list;
    }

    public AppUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TOI Calculator");
        setSize(700, 500);
        setToCenter();
    }

    private void setToCenter(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sizeWidth = 800;
        int sizeHeight = 600;
        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);

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
                    rootPanel.removeAll();
                    inputScreen(rootPanel);
                }
                else if (name == OptionsPanel.VAR_1) {
                    //OPEN MAIN MENU WITH VAR_1
                    setInputData(new Test().test0());
                    rootPanel.removeAll();
                    var = "Вариант 1";
                    mainMenuScreen(rootPanel, "Вариант 1", getInputData());
                }
                else if (name == OptionsPanel.VAR_2){
                    //OPEN MAIN MENU WITH VAR_2
                    setInputData(new Test().test0());
                    rootPanel.removeAll();
                    var = "Вариант 2";
                    mainMenuScreen(rootPanel, var, getInputData());
                }
                else if (name == OptionsPanel.VAR_3){
                    //OPEN MAIN MENU WITH VAR_3
                    setInputData(new Test().test0());
                    rootPanel.removeAll();
                    var = "Вариант 3";
                    mainMenuScreen(rootPanel, var, getInputData());
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

    private void mainMenuScreen(JPanel rootPanel, String var, LinkedList<Data> inputData){
        MenuPanel menuPanel = new MenuPanel(inputData, "<html>Алгоритмы сжатия информации<br> "+ var + "</html>");
        menuPanel.createMenuPanel();
        menuPanel.setOnMenuClickListener((flag, name) -> {
            if (flag){
                menuPanel.getMenuPanel().setVisible(false);
                setSize(1010, 685);
                if (name == MenuPanel.HUFFMAN){
                    //OPEN HUFFMAN
                    huffmanScreen(rootPanel);
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
                rootPanel.removeAll();
                optionsMenuScreen(rootPanel);
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
        inputPanel.setOnInputListener((flag, linkedList) -> {
            inputPanel.getInputPanel().setVisible(false);
            rootPanel.removeAll();
            setSize(700, 500);
            if (flag){
                System.out.println(linkedList.size());
                setInputData(linkedList);
                var = "";
                mainMenuScreen(rootPanel, var, getInputData());
            }
            else {
                optionsMenuScreen(rootPanel);
            }
        });
    }

    private void huffmanScreen(JPanel rootPanel){
        HuffmanPanel huffmanPanel = new HuffmanPanel();
        huffmanPanel.createHuffmanPanel();
        rootPanel.add(huffmanPanel.getHuffmanPanel(), new GridConstraints(
                0, 0, 1, 1,
                GridConstraints.ANCHOR_NORTH,
                GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null, 0, false
        ));
        huffmanPanel.setOnInputListener((flag, linkedList) -> {
            if (flag){
                if (linkedList != null){
                    //TODO:Декодирование
                }
            }
        });

        huffmanPanel.setOnClickListener((flag, name) -> {
            setSize(700, 500);
            if (!flag){
                switch (name){
                    case HuffmanPanel.INPUT_MENU:
                        huffmanPanel.getHuffmanPanel().setVisible(false);
                        rootPanel.removeAll();
                        optionsMenuScreen(rootPanel);
                        break;

                    case HuffmanPanel.MAIN_MENU:
                        huffmanPanel.getHuffmanPanel().setVisible(false);
                        rootPanel.removeAll();
                        mainMenuScreen(rootPanel, var, getInputData());
                        break;
                }
            }
        });

    }

}
