package view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public final JLabel label1 = new JLabel("Bla");
    public final JPanel panel = new JPanel();
    public JButton button1 = new JButton("Click!!!!!");

    public MainWindow() {
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(2000,2000);  // TODO
        this.setLayout(null);
        this.setContentPane(panel);
        panel.add(label1);
        panel.add(button1);

        this.pack();
    }
}
