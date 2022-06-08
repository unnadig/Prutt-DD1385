import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {
    private Color c1;
    private Color c2;
    private String s1;
    private String s2;

    MyButton(Color c1, Color c2, String s1, String s2) {
        super(s1);
        this.c1 = c1;
        this.c2 = c2;
        this.s1 = s1;
        this.s2 = s2;
        this.setBackground(c1);
    }

    void toggleState() {
        if ( this.getBackground() == c1 ) {
            this.setBackground(c2);
            this.setText(s2);
        } else {
            this.setBackground(c1);
            this.setText(s1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        toggleState();
        
    }
}
