import Constants.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RobotValidationTest {

    private RobotModel robotModel;
    private RobotValidation robotValidation;

    @BeforeEach
    void setup() {
        Map<Direction, Integer> map = new HashMap<>();
        map.put(Direction.EAST, 0);
        map.put(Direction.WEST, 0);
        map.put(Direction.NORTH, 0);
        map.put(Direction.SOUTH, 0);
        robotModel = new RobotModel();
        robotValidation = new RobotValidation();
    }

    @Test
    public void testValidateIfOutOfEastBound() {
        robotModel.setX(5);
        robotModel.setY(1);
        robotModel.setDirection(Direction.EAST);
        Assertions.assertEquals(robotValidation.validateIfOutOfBound(robotModel), true);
    }

    @Test
    public void testValidateIfOutOfNorthBound() {
        robotModel.setX(1);
        robotModel.setY(5);
        robotModel.setDirection(Direction.NORTH);
        Assertions.assertEquals(robotValidation.validateIfOutOfBound(robotModel), true);
    }

    @Test
    public void testValidateIfOutOfWestBound() {
        robotModel.setX(0);
        robotModel.setY(1);
        robotModel.setDirection(Direction.WEST);
        Assertions.assertEquals(robotValidation.validateIfOutOfBound(robotModel), true);
    }

    @Test
    public void testValidateIfOutOfSouthBound() {
        robotModel.setX(5);
        robotModel.setY(0);
        robotModel.setDirection(Direction.SOUTH);
        Assertions.assertEquals(robotValidation.validateIfOutOfBound(robotModel), true);
    }

    @Test
    public void testNotOutOfSouthBound() {
        robotModel.setX(1);
        robotModel.setY(1);
        robotModel.setDirection(Direction.SOUTH);
        Assertions.assertEquals(robotValidation.validateIfOutOfBound(robotModel), false);
    }

    @Test
    public void testGetMap() {
        Map<Direction, Integer> map = robotValidation.getMap();
    }

    @Test
    public void testvalidateFirstCommand() {
        String command = "PLACE 3 3 SOUTH";
        Assertions.assertEquals(robotValidation.validateFirstCommand(command), true);
        String command1 = "3 3 S";
        Assertions.assertEquals(robotValidation.validateFirstCommand(command1), false);

    }

}
