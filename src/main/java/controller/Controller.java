package controller;

import exceptions.InvalidPolynomException;
import model.DivisionRes;
import model.Operations;
import model.Polynom;
import view.MainWindow1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    public Polynom p1;
    public Polynom p2;
    public MainWindow1 mainWindow;
    public Operations calc;

    public Controller(Polynom p1, Polynom p2, MainWindow1 mainWindow, Operations calc) {
        this.p1 = p1;
        this.p2 = p2;
        this.mainWindow = mainWindow;
        this.calc = calc;
        this.mainWindow.ba.addActionListener(new Controller.ClickActions());
        this.mainWindow.bs.addActionListener(new Controller.ClickActions());
        this.mainWindow.bm.addActionListener(new Controller.ClickActions());
        this.mainWindow.bd.addActionListener(new Controller.ClickActions());
        this.mainWindow.bde.addActionListener(new Controller.ClickActions());
        this.mainWindow.bi.addActionListener(new Controller.ClickActions());

    }

    private class ClickActions implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == mainWindow.ba ) {
                try {
                    p1 = p1.parsePolynom(mainWindow.t1.getText());
                    p1 = calc.sortPolynom(p1);
                    p2 = p2.parsePolynom(mainWindow.t2.getText());
                    p2 = calc.sortPolynom(p2);
                    mainWindow.t3.setText(calc.add(p1,p2).toString());
                } catch (InvalidPolynomException ex) {
                    mainWindow.showDialog(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }

            }
            if(e.getSource() == mainWindow.bs ) {
                try {
                    p1= p1.parsePolynom(mainWindow.t1.getText());
                    p2= p2.parsePolynom(mainWindow.t2.getText());
                    p1= calc.sortPolynom(p1);
                    p2= calc.sortPolynom(p2);
                    mainWindow.t3.setText(calc.subtract(p1,p2).toString());
                } catch (InvalidPolynomException ex) {
                    mainWindow.showDialog(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
            if(e.getSource() == mainWindow.bm ) {
                try {
                    p1 = p1.parsePolynom(mainWindow.t1.getText());
                    p1 = calc.sortPolynom(p1);
                    p2 = p2.parsePolynom(mainWindow.t2.getText());
                    p2 = calc.sortPolynom(p2);
                    mainWindow.t3.setText(calc.multiply(p1,p2).toString());
                } catch (InvalidPolynomException ex) {
                    mainWindow.showDialog(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }

            }
            if(e.getSource() == mainWindow.bd ) {
                try {
                    p1 = p1.parsePolynom(mainWindow.t1.getText());
                    p1 = calc.sortPolynom(p1);
                    p2 = p2.parsePolynom(mainWindow.t2.getText());
                    p2 = calc.sortPolynom(p2);
                   // mainWindow.t2.setText();
                    DivisionRes res=calc.divide(p1,p2);
                    mainWindow.t3.setText((res != null)? res.toString() : "Impossible to perform");
                } catch (InvalidPolynomException ex) {
                    mainWindow.showDialog(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }

            }

            if(e.getSource() == mainWindow.bi ) {
                try {
                    p1= p1.parsePolynom(mainWindow.t1.getText());
                    p1= calc.sortPolynom(p1);
                    mainWindow.t3.setText(calc.integrate(p1).toString());
                } catch (InvalidPolynomException ex) {
                    mainWindow.showDialog(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }

            }

            if(e.getSource() == mainWindow.bde ) {
                try {
                    p1 = p1.parsePolynom(mainWindow.t1.getText());
                    p1 = calc.sortPolynom(p1);
                    mainWindow.t3.setText(calc.derivation(p1).toString());
                } catch (InvalidPolynomException ex) {
                    mainWindow.showDialog(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }

            }
        }
    }
}
