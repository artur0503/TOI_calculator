package App.UI;

import App.UI.listeners.OnClickListener;
import App.UI.listeners.OnDecodingListener;
import App.UI.listeners.OnInputListener;
import App.UI.panels.RootPanel;
import App.UI.panels.functional.InputPanel;
import App.UI.panels.functional.arithmetic.ArithmeticDecodingPanel;
import App.UI.panels.functional.arithmetic.ArithmeticPanel;
import App.UI.panels.functional.binary.BinaryCodingPanel;
import App.UI.panels.functional.binary.BinaryDecodingPanel;
import App.UI.panels.functional.binary.huffan.HuffmanPanel;
import App.UI.panels.functional.binary.shennon_fano.ShenonPanel;
import App.UI.panels.menu.MenuPanel;
import App.UI.panels.menu.OptionsPanel;
import App.core.classes.controller.coding.ArithmeticController;
import App.core.classes.controller.coding.HuffmanController;
import App.core.classes.controller.coding.ShenonController;
import App.core.classes.controller.decoding.ArithmeticDecoderController;
import App.core.classes.controller.decoding.BinaryDecoderController;
import App.core.classes.controller.decoding.BinaryTextDecoderController;
import App.core.classes.controller.formulas.FormulasController;
import App.core.classes.model.models.Data;
import App.core.interfaces.controller.ControllerCoding;
import App.core.interfaces.controller.ControllerDecoding;
import App.core.interfaces.controller.ControllerFormulas;
import App.core.interfaces.view.BaseView;
import App.options.Options;
import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import java.awt.*;
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

    private LinkedList<Data> transportList(){
        LinkedList<Data> linkedList = new LinkedList<>();
        if (list != null)
            linkedList.addAll(list);
        return linkedList;
    }

    public AppUI(double version){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TOI Calculator Version " + version);
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

    private void addPanel(JPanel rootPanel, JPanel panel){
        rootPanel.add(panel, new GridConstraints(
                0, 0, 1, 1,
                GridConstraints.ANCHOR_NORTH,
                GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null, 0, false
        ));
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
                    setInputData(new Options().optionAlphabet());
                    rootPanel.removeAll();
                    var = "Вариант 1";
                    mainMenuScreen(rootPanel, "Вариант 1", getInputData());
                }
                else if (name == OptionsPanel.VAR_2){
                    //OPEN MAIN MENU WITH VAR_2
                    setInputData(new Options().option1());
                    rootPanel.removeAll();
                    var = "Вариант 2";
                    mainMenuScreen(rootPanel, var, getInputData());
                }
                else if (name == OptionsPanel.VAR_3){
                    //OPEN MAIN MENU WITH VAR_3
                    setInputData(new Options().option2());
                    rootPanel.removeAll();
                    var = "Вариант 3";
                    mainMenuScreen(rootPanel, var, getInputData());
                }
            }
        });
        addPanel(rootPanel, optionsPanel.getInputPanel());
    }

    private void mainMenuScreen(JPanel rootPanel, String var, LinkedList<Data> inputData){
        MenuPanel menuPanel = new MenuPanel(inputData, "<html>Алгоритмы сжатия информации<br> "+ var + "</html>");
        menuPanel.createMenuPanel();
        menuPanel.setOnMenuClickListener((flag, name) -> {
            if (flag){
                menuPanel.getMenuPanel().setVisible(false);
                setSize(1010, 700);
                if (name == MenuPanel.HUFFMAN){
                    //OPEN HUFFMAN
                    huffmanScreen(rootPanel, transportList());
                }
                else if (name == MenuPanel.SHENON) {
                    //OPEN SHENON
                    shenonScreen(rootPanel, transportList());
                }
                else if (name == MenuPanel.ARITHMETIC){
                    //OPEN ARITHMETIC
                    arithmeticCodingScreen(rootPanel, transportList());
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
        addPanel(rootPanel, menuPanel.getMenuPanel());
    }

    private void inputScreen(JPanel rootPanel){
        InputPanel inputPanel = new InputPanel();
        inputPanel.createInputPanel();
        addPanel(rootPanel, inputPanel.getInputPanel());
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

    private void huffmanScreen(JPanel rootPanel, LinkedList<Data> data){
        HuffmanController huffman = new HuffmanController(data);
        huffman.execute();
        ControllerFormulas formulas = new FormulasController(huffman.getCodeToDraw());
        formulas.execute();
        HuffmanPanel huffmanPanel = new HuffmanPanel(huffman.getDrawLastSum());
        huffmanPanel.createPanel("Метод Хаффмана", huffman.getCodeToDraw(), huffman.getDataToDraw(), formulas);
        addPanel(rootPanel, huffmanPanel.getRootPanel());
        huffmanPanel.setOnInputListener((flag, linkedList) -> {
            if (flag){
                if (linkedList != null){
                    huffmanPanel.getRootPanel().setVisible(false);
                    binaryDecodingScreen(rootPanel, "Декодирование Хаффмана");
                }
            }
        });

        huffmanPanel.setOnClickListener((flag, name) -> {
            setSize(700, 500);
            if (!flag){
                switch (name){
                    case BinaryCodingPanel.INPUT_MENU:
                        huffmanPanel.getRootPanel().setVisible(false);
                        rootPanel.removeAll();
                        optionsMenuScreen(rootPanel);
                        break;

                    case BinaryCodingPanel.MAIN_MENU:
                        huffmanPanel.getRootPanel().setVisible(false);
                        rootPanel.removeAll();
                        mainMenuScreen(rootPanel, var, getInputData());
                        break;
                }
            }
        });

    }

    private void shenonScreen(JPanel rootPanel, LinkedList<Data> data){
        ControllerCoding shenon = new ShenonController(data);
        shenon.execute();
        ControllerFormulas formulas = new FormulasController(shenon.getCodeToDraw());
        formulas.execute();
        ShenonPanel shenonPanel = new ShenonPanel();
        shenonPanel.createPanel("Метод Шенона-Фанно", shenon.getCodeToDraw(), shenon.getDataToDraw(), formulas);
        addPanel(rootPanel, shenonPanel.getRootPanel());
        shenonPanel.setOnInputListener((flag, linkedList) -> {
            if (flag){
                if (linkedList != null){
                    shenonPanel.getRootPanel().setVisible(false);
                    binaryDecodingScreen(rootPanel, "Декодирование Шенонна-Фанно");
                }
            }
        });

        shenonPanel.setOnClickListener((flag, name) -> {
            setSize(700, 500);
            if (!flag){
                switch (name){
                    case BinaryCodingPanel.INPUT_MENU:
                        shenonPanel.getRootPanel().setVisible(false);
                        rootPanel.removeAll();
                        optionsMenuScreen(rootPanel);
                        break;

                    case BinaryCodingPanel.MAIN_MENU:
                        shenonPanel.getRootPanel().setVisible(false);
                        rootPanel.removeAll();
                        mainMenuScreen(rootPanel, var, transportList());
                        break;
                }
            }
        });

    }

    private void binaryDecodingScreen(JPanel rootPanel, String title){
        setSize(705, 595);
        BinaryDecodingPanel binaryDecodingPanel = new BinaryDecodingPanel();
        binaryDecodingPanel.createDecoding(getInputData(), title);
        addPanel(rootPanel, binaryDecodingPanel.getBinaryDecodingPanel());
        binaryDecodingPanel.setOnDecodingListener((flag, string, isChar) -> {
            if (!flag) {
                if (string.equals(BinaryDecodingPanel.INPUT_MENU)) {
                    binaryDecodingPanel.getBinaryDecodingPanel().setVisible(false);
                    AppUI.this.optionsMenuScreen(rootPanel);
                } else if (string.equals(BinaryDecodingPanel.MAIN_MENU)) {
                    binaryDecodingPanel.getBinaryDecodingPanel().setVisible(false);
                    AppUI.this.mainMenuScreen(rootPanel, var, AppUI.this.getInputData());
                }
            } else {
                if (!isChar) {
                    ControllerDecoding decoder = new BinaryDecoderController(string, AppUI.this.getInputData());
                    decoder.execute();
                    binaryDecodingPanel.setTextToResult(decoder.getDecodingResult());
                }
                else {
                    ControllerDecoding decoder = new BinaryTextDecoderController(string, AppUI.this.getInputData());
                    decoder.execute();
                    binaryDecodingPanel.setTextToResult(decoder.getDecodingResult());
                }
            }
        });
    }

    private double res;

    private void arithmeticCodingScreen(JPanel rootPanel, LinkedList<Data> list){
        setSize(1010, 590);
        ArithmeticPanel arithmeticPanel = new ArithmeticPanel();
        arithmeticPanel.createArithmeticCoding("Арифметическое кодирование");
        addPanel(rootPanel, arithmeticPanel.getRootPanel());

        arithmeticPanel.setOnDecodingListener(new OnDecodingListener() {
            @Override
            public void OnDecoding(boolean flag, String str, boolean isChar) {
                if (!flag){
                    switch (str){
                        case ArithmeticPanel.INPUT_MENU:
                            arithmeticPanel.getRootPanel().setVisible(false);
                            rootPanel.removeAll();
                            optionsMenuScreen(rootPanel);
                            break;
                        case ArithmeticPanel.MAIN_MENU:
                            arithmeticPanel.getRootPanel().setVisible(false);
                            rootPanel.removeAll();
                            mainMenuScreen(rootPanel, var, getInputData());
                            break;
                    }
                }
                else {
                    ArithmeticController arithm = new ArithmeticController(list);
                    if (str != null);
                    arithm.setText(str);
                    arithm.execute();
                    arithmeticPanel.setData(arithm.getRes(), list);
                    System.out.println("Результат: " + arithm.getRes());
                    res = arithm.getRes();
                }
            }
        });

        arithmeticPanel.setOnInputListener(new OnInputListener() {
            @Override
            public void OnInput(boolean flag, LinkedList<Data> linkedList) {
                if (flag){
                    if (linkedList != null){
                        arithmeticPanel.getRootPanel().setVisible(false);
                        arithmeticDecodingScreen(rootPanel, res, linkedList);
                    }
                }
            }
        });
    }

    private void arithmeticDecodingScreen(JPanel rootPanel, double res, LinkedList<Data> linkedList){
        setSize(750, 580);
        ArithmeticDecodingPanel arithmeticDecodingPanel = new ArithmeticDecodingPanel();
        arithmeticDecodingPanel.createArithmDecoding(res, getInputData());
        addPanel(rootPanel, arithmeticDecodingPanel.getRootPanel());
        arithmeticDecodingPanel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(boolean flag, int name) {
                if (flag){
                    ControllerDecoding decoder = new ArithmeticDecoderController(res, name, linkedList);
                    decoder.execute();
                    arithmeticDecodingPanel.setResult(decoder.getDecodingResult());
                    System.out.println(decoder.getDecodingResult());
                }
                else {
                    if (name == ArithmeticDecodingPanel.INPUT_MENU) {
                        arithmeticDecodingPanel.getRootPanel().setVisible(false);
                        optionsMenuScreen(rootPanel);
                    }
                    else if (name == ArithmeticDecodingPanel.MAIN_MENU) {
                        arithmeticDecodingPanel.getRootPanel().setVisible(false);
                        mainMenuScreen(rootPanel, var, transportList());
                    }
                }
            }
        });
    }


}
