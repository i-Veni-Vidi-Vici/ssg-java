package enrollment.server;

import enrollment.server.controller.Controller;
import enrollment.server.repository.Repository;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();


    }
}
