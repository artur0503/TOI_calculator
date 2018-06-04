package App;

import App.classes.view.ConsoleView;
import App.interfaces.view.View;

/**
 * Created by Arthur 31.01.2018 15:54.
 */
public class StartApp {

    public static void main(String[] args) {
        View cView = new ConsoleView();
        cView.execute();
    }

}
