import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.Timer;


public class Controller {
    private Model model;
    private View view;
    public static final int DELAY_MIN = 1;
    public static final int DELAY_MAX = 40;
    public static final int DELAY_INIT= 20;

    public Controller(Model m, View v) {
        model = m;
        view = v; 
    }

    public void initController() {
        
        // Update position and redraw
        Timer timer = new Timer(DELAY_INIT, new ActionListener() {
            
            public void actionPerformed(ActionEvent ae) {
                model.updateState();
                view.getPaintPanel().repaint();
            }

        });

        // Button for starting and stopping animation
        JButton startButton = view.getStartButton();    // View.Object inside Controller, ok or not?
        startButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                System.out.println();

                // Checks button state from its text
                if (e.getActionCommand().equals("Start")) {
                    startButton.setText("Stop");
                    timer.start();
                } else {
                    startButton.setText("Start");
                    timer.stop();                    
                }

            }

        });

        // Slider for changing animation speed
        JSlider delaySlider = view.getDelaySlider();
        delaySlider.setMinimum(DELAY_MIN);
        delaySlider.setMaximum(DELAY_MAX);
        delaySlider.setValue(DELAY_INIT);
        delaySlider.addChangeListener(new ChangeListener() {
            
            public void stateChanged(ChangeEvent e) {
                timer.setDelay(delaySlider.getValue());
                
            }

        });
        
    }

}
