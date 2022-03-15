import controller.Controller;
import model.Polynom;
import view.MainWindow;

public class Main {

    public static void main(String[] args) {

        Polynom p1 = new Polynom();
        Polynom p2 = new Polynom();
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        Controller controller = new Controller(p1,p2,mainWindow);
    }
}
