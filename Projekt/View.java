import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
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
    private int width = 800;
    private int height = 600;
    private int radius = 4;

    public View(Model model) {
        this.model = model;

        // Create button
        startButton = new JButton("Start");
        delaySlider = new JSlider();
        
        // Set the view layout
        JPanel controlPanel = new JPanel();
        controlPanel.add(startButton);
        controlPanel.add(delaySlider);

        paintPanel = new PaintPanel();
        paintPanel.setPreferredSize(new Dimension(width, height));
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
    
    class PaintPanel extends JPanel {
        PaintPanel() {
            super();
        }

        public void paint(Graphics g) {
            /*
            */
             
            g.setColor(Color.black);
            g.drawRect(1, 1, width-1, height-1);
            g.setColor(Color.blue);
            g.fillRect(1, 1, width-1, height-1);
            
            g.setColor(Color.red);
            Model.Particle[] particleArray = model.getParticleArray();
            for (int i = 0; i < particleArray.length; i++) {
                double x = width*particleArray[i].getX();
                double y = height*particleArray[i].getY();
                
                g.fillOval((int) x, (int) y, radius, radius);
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
