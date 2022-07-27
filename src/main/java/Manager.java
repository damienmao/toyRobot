import Constants.Direction;

import java.util.Scanner;

public class Manager {
    private final Validation validation;
    private final Actions actions;
    private final Robot robot;

    public Manager(Validation validation, Actions actions, Robot robot) {
        this.validation = validation;
        this.actions = actions;
        this.robot = robot;
    }

    Boolean firstValidCommand = false;

    public Boolean getFirstValidCommand() {
        return firstValidCommand;
    }

    public void setFirstValidCommand(Boolean firstValidCommand) {
        this.firstValidCommand = firstValidCommand;
    }

    public void firstValidation() {
        Boolean validationFirst = false;
        while (validationFirst.equals(false)) {
            String command = new Scanner(System.in).nextLine();
            firstValidCommand = validation.validateFirstCommand(command);
            if (firstValidCommand) {
                String x = command.split(" ")[1];
                String y = command.split(" ")[2];
                String direction = command.split(" ")[3];
                robot.setX(Integer.parseInt(x));
                robot.setY(Integer.parseInt(y));
                robot.setDirection(Direction.valueOf(direction));
                System.out.println("Robot is placed at " + x + " " + y + " facing " + direction);
                setFirstValidCommand(true);
                validationFirst = true;
            }
        }
    }

    public void secondValidation() {
        Scanner scanner = new Scanner(System.in);
        String command1 = scanner.nextLine();
        if (command1.equals("MOVE")) {
            boolean outofBound = validation.validateIfOutOfBound(robot);
            if (outofBound == false) {
                actions.move(robot);
            } else {
                System.out.println("Please use 'LEFT' to turn left or 'RIGHT' to turn right");
            }
        } else if (command1.equals("LEFT")) {
            actions.left(robot);
        } else if (command1.equals("RIGHT")) {
            actions.right(robot);
        } else if (command1.equals("REPORT")) {
            actions.report(robot);
        } else {
            System.out.printf("Please input correct command for this robot: \n");
        }
    }
}
