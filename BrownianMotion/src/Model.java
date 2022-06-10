import java.util.Random;

public class Model {
    private Particle[] particleArray;
    public static final int PARTICLE_NUMBER = 4000;
    public static final double STEP_LENGTH = 0.01;

    public Model() {
        particleArray = new Particle[PARTICLE_NUMBER];
        for (int i = 0; i < particleArray.length; i++) {
            
            // Initialize coordinates from Gaussian
            Random rx = new Random();
            Random ry = new Random();
            double x = 0.7 + rx.nextGaussian()/10;
            double y = 0.5 + ry.nextGaussian()/10;
            
            try {
                particleArray[i] = new Particle(x, y, true);
            } catch (Exception e) {
                particleArray[i] = new Particle(0.5, 0.5, true);
                System.out.println(e.getMessage()+" Coordinates have been set to default.");
            }
            
        }

    }

    public void updateState() {
        for (Particle particle : particleArray) {
            particle.move(STEP_LENGTH);
        }

    }
    
    public Particle[] getParticleArray() {
        return particleArray;
    }

    public class Particle {
        // Coordinates x and y assume values between 0 and 1
        private double x;
        private double y;
        private boolean isMovable;

        public Particle(double x, double y, boolean isMovable) {
            if ((x < 0) || (x > 1) || (y < 0) || (y > 1)) {
                throw new IllegalArgumentException("Assigned coordinates are out of bounds!");
            } else {
                this.x = x;
                this.y = y;
                this.isMovable = isMovable;
            }
        }
    
        public Particle() {
            this(0.5, 0.5, true);
        }
    
        public void move(double L) {
            if ( !isMovable ) {
                return;
            }

            double phi = Math.random()*2*Math.PI;
            x += L*Math.cos(phi);
            y += L*Math.sin(phi);

            if (isAtBoundary()) {
                isMovable = false;
                stickAtBoundary();
            }

        }

        public boolean isAtBoundary() {
            return ((x < 0) || (x > 1) || (y < 0) || (y > 1));
        }

        public void stickAtBoundary() {
            if ((x < 0) || (x > 1)) {
                x = Math.round(x);
            } else if ((y < 0) || ( y > 1)) {
                y = Math.round(y);               
            }

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
