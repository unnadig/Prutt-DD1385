import javax.swing.SwingUtilities;

public class BrownianMotionDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               try {
                   createAndShowGUI();

               } catch (Exception e) {
                   e.printStackTrace();
               }
           } 
        });
    }

    public static void createAndShowGUI() {
        Model m = new Model();
        View v = new View(m);
        Controller c = new Controller(m, v);
        c.initController();
    
    }
}
