import Constants.Direction;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Validation {

    private  static  final  Map<Direction, Integer> map = Map.ofEntries(Map.entry(Direction.EAST, 0),
            Map.entry(Direction.WEST, 0),
            Map.entry(Direction.NORTH, 0),
            Map.entry(Direction.SOUTH, 0));

    public static Map<Direction, Integer> getMap() {
        return map;
    }

    public void validateIfOutOfBound(Robot robot) {
        Map<Direction, Integer> map = Map.ofEntries(Map.entry(Direction.EAST, 0),
                Map.entry(Direction.WEST, 0),
                Map.entry(Direction.NORTH, 0),
                Map.entry(Direction.SOUTH, 0));



        if (robot.getX().equals(5) && robot.getDirection().equals(Direction.EAST)) map.put(Direction.EAST, 1);
        else if (robot.getX().equals(0) && robot.getDirection().equals(Direction.WEST)) map.put(Direction.WEST, 1);
        else if (robot.getY().equals(0) && robot.getDirection().equals(Direction.SOUTH)) map.put(Direction.SOUTH, 1);
        else if (robot.getY().equals(5) && robot.getDirection().equals(Direction.NORTH)) map.put(Direction.NORTH, 1);
    }

    public Boolean validateFirstCommand(String command) {
//     Pattern pattern = Pattern.compile("PLACE\s[0-5]\s[0-5]\s[]" +
//             "X,Y,F");
        String regex = "^PLACE [0-5] [0-5] " + "(SOUTH|EAST|WEST|NORTH)";
        System.out.println("Validating First Command");
        if (command.matches(regex)) {
            System.out.println("Validation Complete...First Command is valid");
            return true;
        }
        System.out.printf("Validation Complete...First Command is not valid\n");

        return false;
    }

// public v


}
