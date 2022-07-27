import Constants.Direction;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) {

        Validation validation = new Validation();
        Actions actions = new Actions();
        Robot robot = new Robot();
        Manager manager = new Manager(validation, actions, robot);
        System.out.println("Toy Robot started...taking first command");
        manager.firstValidation();
        while (manager.getFirstValidCommand()) {
            manager.secondValidation();
        }
    }
}
