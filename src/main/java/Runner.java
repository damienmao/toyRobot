import Constants.Direction;

import java.util.List;
import java.util.Map;
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
        if (firstValidCommand) {
            String x = command.getCommand().split(" ")[1];
            String y = command.getCommand().split(" ")[2];
            String direction = command.getCommand().split(" ")[3];
            robot.setX(Integer.parseInt(x));
            robot.setY(Integer.parseInt(y));
            robot.setDirection(Direction.valueOf(direction));
            System.out.println("Robot is placed at " + x + " " + y + " facing " + direction);
        }

        while (firstValidCommand.equals(true)) {
            Command command1 = new Command();
            if (command1.getCommand().equals("MOVE")) {
                boolean outofBound = validation.validateIfOutOfBound(robot);
                if (outofBound == false) {
                    Map<Direction, Integer> map = validation.getMap();
                    List<Direction> list = map.keySet().stream().filter(key -> map.get(key).equals(0)).collect(Collectors.toList());
                    if (list.size() != 4) {
                        System.out.println("You can turn left or right to these direction");
                    }
                    Robot robot1 = actions.move(robot);

                    System.out.println("Robot is placed at " + robot1.getX() + " " + robot1.getY() + " facing " + robot1.getDirection());
                } else {
                    System.out.println("pls turn left or right");
                }
            }
            else if (command1.getCommand().equals("LEFT")) {
                actions.left(robot);
                System.out.println("Robot is placed at " + robot.getX() + " " + robot.getY() + " facing " + robot.getDirection());
            } else if (command1.getCommand().equals("RIGHT")) {
                actions.right(robot);
                System.out.println("Robot is placed at " + robot.getX() + " " + robot.getY() + " facing " + robot.getDirection());
            } else if (command1.getCommand().equals("REPORT")) {
                actions.report(robot);
            }
        }

    }
}
