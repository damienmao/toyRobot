import Constants.Direction;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private  Map<Direction, Integer> map = Map.ofEntries(Map.entry(Direction.EAST, 0),
            Map.entry(Direction.WEST, 0),
            Map.entry(Direction.NORTH, 0),
            Map.entry(Direction.SOUTH, 0));

    public  Map<Direction, Integer> getMap() {
        return map;
    }

    public boolean validateIfOutOfBound(Robot robot) {

        Map<Direction,Integer> map1 =new HashMap<>();
        map1.put(Direction.EAST, 0);
        map1.put(Direction.WEST, 0);
        map1.put(Direction.NORTH, 0);
        map1.put(Direction.SOUTH, 0);

        System.out.println(map1);
        if (robot.getX().equals(5) && robot.getDirection().equals(Direction.EAST)) {
            map1.put(Direction.EAST, 1);
        }
        else if (robot.getX().equals(0) && robot.getDirection().equals(Direction.WEST)) {
            map1.put(Direction.WEST, 1);
        }
        else if (robot.getY().equals(0) && robot.getDirection().equals(Direction.SOUTH)) {
            map1.put(Direction.SOUTH, 1);
        }
        else if (robot.getY().equals(5) && robot.getDirection().equals(Direction.NORTH)) {
            map1.put(Direction.NORTH, 1);

        }
        for (Integer i : map1.values()){
            if (i==1) return true;
        }
        return false;
    }

    public boolean validateFirstCommand(String command) {
     Pattern pattern = Pattern.compile("^PLACE [0-5] [0-5] (SOUTH|EAST|WEST|NORTH)");
        Matcher m = pattern.matcher(command);
       // String regex = "^PLACE [0-5] [0-5] (SOUTH|EAST|WEST|NORTH)";
        System.out.println("Validating First Command");
        if (m.find()) {
            System.out.println("Validation Complete...First Command is valid");
            return true;
        }
        System.out.printf("Validation Complete...First Command is not valid\n");

        return false;
    }

// public v


}
