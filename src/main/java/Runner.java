import Constants.Direction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) {

        Validation validation = new Validation();
        Actions actions = new Actions();
        Robot robot = new Robot();
        System.out.println("Toy Robot started...taking first command");

        Boolean firstValidCommand = false;
        while (firstValidCommand.equals(false)) {
            Command command = new Command();
            firstValidCommand = validation.validateFirstCommand(command.getCommand());
            if (firstValidCommand) {
                String x = command.getCommand().split(" ")[1];
                String y = command.getCommand().split(" ")[2];
                String direction = command.getCommand().split(" ")[3];
                robot.setX(Integer.parseInt(x));
                robot.setY(Integer.parseInt(y));
                robot.setDirection(Direction.valueOf(direction));
                System.out.println("Robot is placed at " + x + " " + y + " facing " + direction);
            }
        }


        while (firstValidCommand.equals(true)) {
            Command command1 = new Command();
            if (command1.getCommand().equals("MOVE")) {
                boolean outofBound = validation.validateIfOutOfBound(robot);
                if (outofBound == false) {
                    Robot robot1 = actions.move(robot);
                    System.out.println("Robot is placed at " + robot1.getX() + " " + robot1.getY() + " facing " + robot1.getDirection());
                } else {
                    System.out.println("PLease use 'LEFT' to turn left or 'RIGHT' to turn right");
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
            } else {
                System.out.printf("Please input correct command for this robot\n");
            }
        }

    }
}
