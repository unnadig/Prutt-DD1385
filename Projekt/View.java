import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;

public class View {
    private Model model;
    private JButton startButton;
    private JSlider delaySlider;
    private PaintPanel paintPanel;
    public static final int PANEL_WIDTH = 1000;
    public static final int PANEL_HEIGHT = 600;
    public static final int PARTICLE_RADIUS = 4;
    public static final Color BG_COLOR = Color.blue;
    public static final Color STUCK_COLOR = Color.red;
    public static final Color MOVE_COLOR = Color.black;

    public View(Model model) {
        this.model = model;
        initView();
    }

    public void initView() {
        // Create button and slider
        startButton = new JButton("Start");
        delaySlider = new JSlider();
        
        // Set the view layout
        JPanel controlPanel = new JPanel();
        controlPanel.add(startButton);
        controlPanel.add(delaySlider);

        paintPanel = new PaintPanel();
        paintPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        //paintPanel.setBackground(Color.blue);
        paintPanel.setOpaque(false);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, controlPanel, paintPanel);
        splitPane.setEnabled(false);
        
        // Display
        JFrame frame = new JFrame("Brownian Motion Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(splitPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private class PaintPanel extends JPanel {
        PaintPanel() {
            super();
        }

        public void paint(Graphics g) {

            // Paint background and border
            g.setColor(BG_COLOR);
            g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
            g.setColor(STUCK_COLOR);
            g.drawRect(0, 0, PANEL_WIDTH-1, PANEL_HEIGHT-1);
            
            // Paint particles
            Model.Particle[] particleArray = model.getParticleArray();
            for (int i = 0; i < particleArray.length; i++) {
                Model.Particle particle = particleArray[i];
                double x = PANEL_WIDTH*particle.getX();
                double y = PANEL_HEIGHT*particle.getY();
                
                // Stuck particles are painted inside the border
                if (!particle.isMovable()) {
                    if (x == PANEL_WIDTH) {
                        x -= PARTICLE_RADIUS;
                    } else if (y == PANEL_HEIGHT) {
                        y -= PARTICLE_RADIUS;
                    }

                    g.setColor(STUCK_COLOR);
                } else {
                    g.setColor(MOVE_COLOR);
                }

                g.fillOval((int) x, (int) y, PARTICLE_RADIUS, PARTICLE_RADIUS);
            
            }

        }

    }

    public JButton getStartButton() {
        return startButton;
    }

    public JSlider getDelaySlider() {
        return delaySlider;
    }

    public PaintPanel getPaintPanel() {
        return paintPanel;
    }

}
