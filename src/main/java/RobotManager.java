import java.util.Scanner;

public class RobotManager {
    private final RobotValidation robotValidation;
    private final RobotActions robotActions;
    private final RobotModel robotModel;

    public RobotManager(RobotValidation robotValidation, RobotActions robotActions, RobotModel robotModel) {
        this.robotValidation = robotValidation;
        this.robotActions = robotActions;
        this.robotModel = robotModel;
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
            firstValidCommand = robotValidation.validateFirstCommand(command);
            if (firstValidCommand) {
                robotActions.placeRobot(command, robotModel);
                setFirstValidCommand(true);
                validationFirst = true;
            }
        }
    }

    public void secondValidation() {
        Scanner scanner = new Scanner(System.in);
        String command1 = scanner.nextLine();
        if (command1.equals("MOVE")) {
            boolean outofBound = robotValidation.validateIfOutOfBound(robotModel);
            if (outofBound == false) {
                robotActions.move(robotModel);
            } else {
                System.out.println("Please use 'LEFT' to turn left or 'RIGHT' to turn right");
            }
        } else if (command1.equals("LEFT")) {
            robotActions.left(robotModel);
        } else if (command1.equals("RIGHT")) {
            robotActions.right(robotModel);
        } else if (command1.equals("REPORT")) {
            robotActions.report(robotModel);
        } else if (command1.toUpperCase().contains("PLACE")) {
            Boolean valid = robotValidation.validateFirstCommand(command1);
            if (valid) robotActions.placeRobot(command1, robotModel);
        } else {
            System.out.printf("Please input correct command for this robot: \n");
        }
    }
}
