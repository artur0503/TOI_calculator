package Practice.UI;

import App.classes.model.POJO.Data;
import App.interfaces.view.BaseView;
import Practice.UI.panels.MenuPanel;
import Practice.UI.panels.RootPanel;
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
        mainMenu(rootPanel.getRootPanel());
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
        /*first screen(menu)*/
    }

    private void mainMenu(JPanel rootPanel){
        MenuPanel menuPanel = new MenuPanel("Алгоритмы сжатия информации");
        menuPanel.createMenuPanel();
        menuPanel.setOnMenuClickListener(flag -> {
            if (flag){
                menuPanel.getMenuPanel().setVisible(false);
                setSize(1000, 700);
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

    @Override
    public void windowOpened(WindowEvent e) {

    }

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
