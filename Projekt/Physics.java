public class Physics {
    private Particle particle;

    Physics() {
        this.particle = new Particle();
    }

    void updateState() {
        particle.move();
    }
    
    public Particle getParticle() {
        return particle;
    }
}
