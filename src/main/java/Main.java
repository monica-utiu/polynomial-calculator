import controller.Controller;
import model.Operations;
import model.Polynom;
import view.MainWindow1;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Polynom p1 = new Polynom();
        Polynom p2 = new Polynom();
        MainWindow1 mainWindow = new MainWindow1();
        Operations calculator = new Operations();
        mainWindow.setVisible(true);
        Controller controller = new Controller(p1,p2,mainWindow,calculator);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
}
