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

    public void move() {
        if ( !this.isMoveable ) {
            return;
        }
        // make L final?
        double L = 0.01;
        double phi = Math.random()*2*Math.PI;
        this.x += L*Math.cos(phi);
        this.y += L*Math.sin(phi);
    }
}