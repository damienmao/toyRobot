import Constants.Direction;

import java.util.Map;

import static Constants.Direction.*;

public class RobotActions {

    private final static Map<Direction, Direction> right = Map.ofEntries(Map.entry(SOUTH, EAST),
            Map.entry(EAST, NORTH),
            Map.entry(NORTH, WEST),
            Map.entry(WEST, SOUTH));

    private final static Map<Direction, Direction> left = Map.ofEntries(Map.entry(SOUTH, WEST),
            Map.entry(WEST, NORTH),
            Map.entry(NORTH, EAST),
            Map.entry(EAST, SOUTH));

    public void placeRobot(String command, RobotModel robotModel) {
        String x = command.split(" ")[1];
        String y = command.split(" ")[2];
        String direction = command.split(" ")[3];
        robotModel.setX(Integer.parseInt(x));
        robotModel.setY(Integer.parseInt(y));
        robotModel.setDirection(Direction.valueOf(direction));
        System.out.println("Robot is placed at " + x + " " + y + " facing " + direction);
    }

    public RobotModel move(RobotModel robotModel) {
        if (robotModel.getDirection().equals(EAST)) {
            robotModel.setX(robotModel.getX() + 1);
        } else if (robotModel.getDirection().equals(WEST)) {
            robotModel.setX(robotModel.getX() - 1);
        } else if (robotModel.getDirection().equals(NORTH)) {
            robotModel.setY(robotModel.getY() + 1);
        } else if (robotModel.getDirection().equals(SOUTH)) {
            robotModel.setY(robotModel.getY() - 1);
        }
        System.out.println("Robot is placed at " + robotModel.getX() + " " + robotModel.getY() + " facing " + robotModel.getDirection());

        return robotModel;
    }


    public void left(RobotModel robotModel) {
        robotModel.setDirection(left.get(robotModel.getDirection()));
        System.out.println("Robot is placed at " + robotModel.getX() + " " + robotModel.getY() + " facing " + robotModel.getDirection());
    }

    public void right(RobotModel robotModel) {
        robotModel.setDirection(right.get(robotModel.getDirection()));
        System.out.println("Robot is placed at " + robotModel.getX() + " " + robotModel.getY() + " facing " + robotModel.getDirection());
    }

    public void report(RobotModel robotModel) {
        System.out.println("Robot is facing " + robotModel.getDirection() + " at " + robotModel.getX() + " and " + robotModel.getY());
    }
}
