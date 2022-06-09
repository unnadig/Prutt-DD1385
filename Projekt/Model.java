public class Model {
    private int particleNum;
    private Particle[] particleArray;
    private double L = 0.01;

    Model() {
        particleNum = 1;
        particleArray = new Particle[particleNum];
        for (int i = 0; i < particleArray.length; i++) {
            particleArray[i] = new Particle();
        }
    }

    void updateState() {
        particle.move();
    }
    
    public Particle[] getParticleArray() {
        return particleArray;
    }

    public class Particle {
        // x,y are doubles between 0 and 1.
        private double x;
        private double y;
        private boolean isMoveable;
    
        public Particle(double x, double y, boolean isMoveable) {
            // make sure x,y,b valid?
            this.x = x;
            this.y = y;
            this.isMoveable = isMoveable;
        }
    
        public Particle() {
            this.x = Math.random(); 
            this.y = Math.random();
            this.isMoveable = true;
        }
    
        public void move(double L) {
            if ( !this.isMoveable ) {
                return;
            }

            double phi = Math.random()*2*Math.PI;
            this.x += L*Math.cos(phi);
            this.y += L*Math.sin(phi);
        }
        
        public double getX() {
            return x;
        }
    
        public double getY() {
            return y;
        }
    }
}
