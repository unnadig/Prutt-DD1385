import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.Timer;


public class Controller {
    private Model model;
    private View view;
    public static final int DELAY_MIN = 0;
    public static final int DELAY_MAX = 80;
    public static final int DELAY_INIT = 20;

    public Controller(Model m, View v) {
        model = m;
        view = v; 
    }

    public void initController() {
        
        // Update position and redraw
        Timer timer = new Timer(DELAY_INIT, e -> {
            model.updateState();
            view.getPaintPanel().repaint();

        });

        // Button for starting and stopping animation
        JButton startButton = view.getStartButton();    //TODO: move to view (lambda -> method ref -> Controller) 
        startButton.addActionListener(e -> {

            // Checks button state from its text
            if (e.getActionCommand().equals("Start")) {
                startButton.setText("Stop");
                timer.start();
            } else {
                startButton.setText("Start");
                timer.stop();                    
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
