import Constants.Direction;

import java.util.Scanner;

public class Manager {
    private final Validation validation;
    private final Actions actions;

    public Manager(Validation validation, Actions actions) {
        this.validation = validation;
        this.actions = actions;
    }

    Boolean firstValidCommand = false;

    public String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public Boolean validateFirstCommand(Robot robot, String command) {

//        while (firstValidCommand.equals(false)) {
       // String command = getInput();
        firstValidCommand = validation.validateFirstCommand(command);
        if (firstValidCommand) {
            String x = command.split(" ")[1];
            String y = command.split(" ")[2];
            String direction = command.split(" ")[3];
            robot.setX(Integer.parseInt(x));
            robot.setY(Integer.parseInt(y));
            robot.setDirection(Direction.valueOf(direction));
            System.out.println("Robot is placed at " + x + " " + y + " facing " + direction);
            firstValidCommand=true;
            return true;
        }
////        }
       return false;
    }

    public void validateFollowingCommand(Robot robot, String command) {
//        Boolean thisIsCalled = true;
//       while (firstValidCommand.equals(false)){
//           validateFirstCommand(robot, command);
//       }
     //  while (firstValidCommand.equals(true)) {
          //  String command1 = getInput();
            if (command.equals("MOVE")) {
                boolean outofBound = validation.validateIfOutOfBound(robot);
                if (outofBound == false) {
                    Robot robot1 = actions.move(robot);
       //             System.out.println("Robot is placed at " + robot1.getX() + " " + robot1.getY() + " facing " + robot1.getDirection());
                } else {
                    System.out.println("PLease use 'LEFT' to turn left or 'RIGHT' to turn right");
                }
            } else if (command.equals("LEFT")) {
                actions.left(robot);
                System.out.println("Robot is placed at " + robot.getX() + " " + robot.getY() + " facing " + robot.getDirection());
            } else if (command.equals("RIGHT")) {
                actions.right(robot);
                System.out.println("Robot is placed at " + robot.getX() + " " + robot.getY() + " facing " + robot.getDirection());
            } else if (command.equals("REPORT")) {
                actions.report(robot);
            } else {
                System.out.printf("Please input correct command for this robot\n");
            }
       // }
    }
}
