import java.awt.Color;
import java.awt.Graphics;

public class View extends JPanel {
    private Model model;

    public View(Model model) {
        this.model = model;
        this.setPrefferedSize(new Dimension(100,100));
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        Particle[] particleArray = model.getParticleArray();
        for (int i = 0; i < particleArray.length; i++) {
            double x = particleArray[i].getX();
            double y = particleArray[i].getY();

            g.fillOval(x, y, 2, 2);
        }
    }
}
