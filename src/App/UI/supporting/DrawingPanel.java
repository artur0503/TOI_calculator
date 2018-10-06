package App.UI.supporting;

import javax.swing.*;
import java.awt.*;

public abstract class DrawingPanel extends JPanel {

   public abstract void getIteration(int iteration);

    @Override
    public Dimension getPreferredSize() {
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
