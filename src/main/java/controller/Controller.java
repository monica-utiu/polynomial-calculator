package controller;

import model.Polynom;
import view.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    public Polynom p1;
    public Polynom p2;
    public MainWindow mainWindow;

    public Controller(Polynom p1, Polynom p2, MainWindow mainWindow) {
        this.p1 = p1;
        this.p2 = p2;
        this.mainWindow = mainWindow;
        this.mainWindow.button1.addActionListener(new Controller.ClickActions());
    }

    private class ClickActions implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Un mesaj");
        }
    }
}
