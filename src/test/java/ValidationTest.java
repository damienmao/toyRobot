import Constants.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidationTest {

 private Robot robot;
 private Validation validation;

    @BeforeEach
    void setup(){
        Map<Direction,Integer> map =new HashMap<>();
        map.put(Direction.EAST, 0);
        map.put(Direction.WEST, 0);
        map.put(Direction.NORTH, 0);
        map.put(Direction.SOUTH, 0);
        robot= new Robot();
        validation=new Validation();
    }
    @Test
    public void testValidateIfOutOfEastBound(){
        robot.setX(5);
        robot.setY(1);
        robot.setDirection(Direction.EAST);
        Assertions.assertEquals(validation.validateIfOutOfBound(robot),true);
    }
    @Test
    public void testValidateIfOutOfNorthBound(){
        robot.setX(1);
        robot.setY(5);
        robot.setDirection(Direction.NORTH);
        Assertions.assertEquals(validation.validateIfOutOfBound(robot),true);
    }
    @Test
    public void testValidateIfOutOfWestBound(){
        robot.setX(0);
        robot.setY(1);
        robot.setDirection(Direction.WEST);
        Assertions.assertEquals(validation.validateIfOutOfBound(robot),true);
    }
    @Test
    public void testValidateIfOutOfSouthBound(){
        robot.setX(5);
        robot.setY(0);
        robot.setDirection(Direction.SOUTH);
        Assertions.assertEquals(validation.validateIfOutOfBound(robot),true);
    }
    @Test
    public void testNotOutOfSouthBound(){
        robot.setX(1);
        robot.setY(1);
        robot.setDirection(Direction.SOUTH);
        Assertions.assertEquals(validation.validateIfOutOfBound(robot),false);
    }
  @Test
  public  void testGetMap(){
        Map<Direction,Integer> map = validation.getMap();
  }
    @Test
    public void testvalidateFirstCommand(){
        String command = "PLACE 3 3 SOUTH";
        Assertions.assertEquals(validation.validateFirstCommand(command),true);
        String command1 = "3 3 S";
        Assertions.assertEquals(validation.validateFirstCommand(command1),false);

    }

}
