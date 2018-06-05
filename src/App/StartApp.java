package App;

import App.classes.view.ConsoleView;
import App.interfaces.view.BaseView;

/**
 * Created by Arthur 31.01.2018 15:54.
 */
public class StartApp {

    public static void main(String[] args) {
        BaseView cView = new ConsoleView();
        cView.execute();
    }

}
