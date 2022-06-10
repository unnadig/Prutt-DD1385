import java.util.Random;

public class Model {
    private int particleNum = 4000;
    private Particle[] particleArray;
    private static final double L = 0.01;

    Model() {
        particleArray = new Particle[particleNum];
        for (int i = 0; i < particleArray.length; i++) {
            particleArray[i] = new Particle();
        }
    }

    public void updateState() {
        for (Particle particle : particleArray) {
            particle.move(L);

        }
    }
    
    public Particle[] getParticleArray() {
        return particleArray;
    }

    public class Particle {
        private double x;
        private double y;
        private boolean isMovable;
    
        public Particle(double x, double y, boolean isMovable) {
            this.x = x;
            this.y = y;
            this.isMovable = isMovable;
        }
    
        public Particle() {
            // Initialize coordinates from Gaussian
            Random rx = new Random();
            Random ry = new Random();
            x = 0.5 + rx.nextGaussian()/100;
            y = 0.5 + ry.nextGaussian()/100;
            isMovable = true;
        }
    
        public void move(double L) {
            if ( !this.isMovable ) {
                return;
            }

            double phi = Math.random()*2*Math.PI;
            x += L*Math.cos(phi);
            y += L*Math.sin(phi);
        }

        public boolean isAtBoundary() {
            return true;
        }
        
        public double getX() {
            return x;
        }
    
        public double getY() {
            return y;
        }

        public boolean isMovable() {
            return isMovable;
        }
    }
}
