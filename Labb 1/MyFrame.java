import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyFrame extends JFrame {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame("Jonas");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public MyFrame(String title) {
        super(title);
        MyButton b1 = new MyButton(Color.pink, Color.red, "On", "Off");
        MyButton b2 = new MyButton(Color.yellow, Color.orange, "Run", "Stop");

        b1.addActionListener(b1);
        b2.addActionListener(b2);
        JPanel panel = new JPanel();
        panel.setBackground(Color.green);
        panel.add(b1);
        panel.add(b2);
        getContentPane().add(panel);
    }

}
