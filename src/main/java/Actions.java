import Constants.Direction;

import java.util.HashMap;
import java.util.Map;

import static Constants.Direction.*;

public class Actions {

    private final static Map<Direction, Direction> right = Map.ofEntries(Map.entry(SOUTH, EAST),
            Map.entry(EAST, NORTH),
            Map.entry(NORTH, WEST),
            Map.entry(WEST, SOUTH));

    private final static Map<Direction, Direction> left = Map.ofEntries(Map.entry(SOUTH, WEST),
            Map.entry(WEST, NORTH),
            Map.entry(NORTH, EAST),
            Map.entry(EAST, SOUTH));

    public void placeRobot(String command, Robot robot) {
        String x = command.split(" ")[1];
        String y = command.split(" ")[2];
        String direction = command.split(" ")[3];
        robot.setX(Integer.parseInt(x));
        robot.setY(Integer.parseInt(y));
        robot.setDirection(Direction.valueOf(direction));
        System.out.println("Robot is placed at " + x + " " + y + " facing " + direction);
    }
    public Robot move(Robot robot) {
        if (robot.getDirection().equals(EAST)) {
            robot.setX(robot.getX() + 1);
        } else if (robot.getDirection().equals(WEST)) {
            robot.setX(robot.getX() - 1);
        } else if (robot.getDirection().equals(NORTH)) {
            robot.setY(robot.getY() + 1);
        } else if (robot.getDirection().equals(SOUTH)) {
            robot.setY(robot.getY() - 1);
        }
        System.out.println("Robot is placed at " + robot.getX() + " " + robot.getY() + " facing " + robot.getDirection());

        return robot;
    }


    public void left(Robot robot) {
        robot.setDirection(left.get(robot.getDirection()));
        System.out.println("Robot is placed at " + robot.getX() + " " + robot.getY() + " facing " + robot.getDirection());
    }

    public void right(Robot robot) {
        robot.setDirection(right.get(robot.getDirection()));
        System.out.println("Robot is placed at " + robot.getX() + " " + robot.getY() + " facing " + robot.getDirection());
    }

    public void report(Robot robot) {
        System.out.println("Robot is facing " + robot.getDirection() + " at " + robot.getX() + " and " + robot.getY());
    }
}
