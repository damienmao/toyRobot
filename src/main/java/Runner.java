import Constants.Direction;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Runner {


    public static void main(String[] args) {

        Validation validation = new Validation();
        Actions actions = new Actions();
        Robot robot = new Robot();
        System.out.println("Toy Robot started...Start taking first command");
        Command command = new Command();
        Boolean firstValidCommand = false;
        while (firstValidCommand.equals(false)) {
            command.scanner.nextLine();
            firstValidCommand = validation.validateFirstCommand(command.getCommand());


        }

        while (firstValidCommand.equals(true)) {
            if (command.getCommand().equals("MOVE")) {
                validation.validateIfOutOfBound(robot);
                Map<Direction, Integer> map = validation.getMap();
                List<Direction> list = map.keySet().stream().filter(key -> map.get(key).equals(0)).collect(Collectors.toList());
                if (list.size()!=4){
                    System.out.println("you can turn left or right to these direction");
                }
              actions.move(robot);
            }


        }


    }
}
