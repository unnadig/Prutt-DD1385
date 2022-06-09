import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BrownianMotionDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               initUI();
           } 
        });
    }

    private static void initUI() {
        Model m = new Model();
        View v = new View(m);

        JFrame f = new JFrame("Brownian Motion Demo");
        f.setSize(400,400);
        f.setBackground(Color.blue);
        f.add(v);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        //Jpanel panel = new JPanel();
        //getContentPane().add(panel);
        //panel.setLayout(null);

        // rita en partikel mha xy-koordinater

        // hantera partiklar utanför skärmen
    }
}
