package App;


import App.UI.AppUI;

public class App {

    public static void main(String[] args) {
        AppUI appUI = new AppUI(1.0);
        appUI.execute();
//        BaseView cView = new ConsoleView();
//        cView.execute();
    }

}
