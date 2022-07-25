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


    public Robot move(Robot robot) {
//        switch (robot.getDirection()) {
//            case EAST:
//                 robot.setX(robot.getX() + 1);
//                String test1 = "Test";
//                 System.out.println("test");
//            case WEST:
//                robot.setX(robot.getX() - 1);
//            case NORTH:
//                robot.setY(robot.getY() + 1);
//                String test = "Test";
//                System.out.println("test");
//            case SOUTH:
//                robot.setY(robot.getY() - 1);
//        }
        if(robot.getDirection().equals(EAST)){
            robot.setX(robot.getX() + 1);
        }
        else if (robot.getDirection().equals(WEST)){ robot.setX(robot.getX() - 1);}
        else if (robot.getDirection().equals(NORTH)){robot.setY(robot.getY() + 1);}
        else if (robot.getDirection().equals(SOUTH)){robot.setY(robot.getY() - 1);}
        System.out.println("Robot is placed at " + robot.getX() + " " + robot.getY() + " facing " + robot.getDirection());
        return robot;
    }


    public void left(Robot robot) {
        robot.setDirection(left.get(robot.getDirection()));
    }

    public void right(Robot robot) {
        robot.setDirection(right.get(robot.getDirection()));
    }

    public void report(Robot robot) {
        System.out.println("Robot is facing " + robot.getDirection() + "at " + robot.getX() + "and " + robot.getY());
    }
}
