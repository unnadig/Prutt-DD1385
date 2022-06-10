import javax.swing.SwingUtilities;

public class BrownianMotionDemo {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               try {
                final Model model = new Model();    //TODO: which thread should model be in?
                final View view = new View(model);
                final Controller controller = new Controller(model, view);
                controller.initController();

               } catch (Exception e) {
                   e.printStackTrace();
               }
           } 
        });

    }

}
