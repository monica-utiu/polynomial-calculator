package view;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainWindow1 extends JPanel{

    public final JFrame frame = new JFrame();
    public static JTextField t1 = new JTextField(16);
    public static JTextField t2 = new JTextField(16);
    //public static JTextField t3 = new JTextField(16);
    public static JTextArea t3 = new JTextArea(2,1);
    public JButton ba = new JButton("+");
    public JButton bs = new JButton("-");
    public JButton bm = new JButton("*");
    public JButton bd = new JButton("/");
    public JButton bi = new JButton("integrate");
    public JButton bde = new JButton("derivate");
    //public JButton beq = new JButton("=");
    JLabel l1=new JLabel(" polynomial 1:");
    JLabel l2=new JLabel(" polynomial 2:");
    JLabel l3=new JLabel(" The result of the calculation is :");

    public MainWindow1() {
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(this);

        this.setLayout(new GridLayout(3,3));
        frame.setContentPane(this);
        frame.setSize(700,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ba.setBounds(20,20,60,20);
        bs.setBounds(20,80,60,20);
        bm.setBounds(20,140,60,20);
        bd.setBounds(300,200,100,40);
        bde.setBounds(20,200,60,20);
        bi.setBounds(100,200,60,20);

        l1.setBounds(100,20,50,20);
        t1.setBounds(160,20,400,20);
        l2.setBounds(100,80,50,20);
        t2.setBounds(160,80,400,20);
        l3.setBounds(100,140,60,20);
        t3.setBounds(160,140,400,20);
        this.add(l1);
        this.add(t1);
        this.add(bde);
        this.add(bi);
        this.add(l2);
        this.add(t2);
        this.add(ba);
        this.add(bs);
        this.add(l3);
        this.add(t3);
        this.add(bm);
        this.add(bd);



        frame.pack();
    }

    public void showDialog(String message, int messageType) {
        JOptionPane.showMessageDialog(this, message, (messageType == 0) ? "ERROR" : "MGS" , messageType);
    }
}
