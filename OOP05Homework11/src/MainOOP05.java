import model.Controller;
import model.Preloader;

public class MainOOP05 {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.loadParts();
        controller.pickAnOrder();
    }
}
