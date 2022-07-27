import Constants.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RobotActionsTest {

    private RobotActions robotActions;
    private RobotModel robotModel;

    @BeforeEach
    void setup() {
        robotActions = new RobotActions();
        robotModel = new RobotModel();
        robotModel.setY(1);
        robotModel.setX(1);
    }

    @Test
    public void testMoveToEast() {
        robotModel.setDirection(Direction.EAST);
        robotActions.move(robotModel);
        Assertions.assertEquals(robotModel.getX(), 2);
    }

    @Test
    public void testMoveToWest() {
        robotModel.setDirection(Direction.WEST);
        robotActions.move(robotModel);
        Assertions.assertEquals(robotModel.getX(), 0);
    }

    @Test
    public void testMoveToNorth() {
        robotModel.setDirection(Direction.NORTH);
        robotActions.move(robotModel);
        Assertions.assertEquals(robotModel.getY(), 2);
    }

    @Test
    public void testMoveToSouth() {
        robotModel.setDirection(Direction.SOUTH);
        robotActions.move(robotModel);
        Assertions.assertEquals(robotModel.getY(), 0);
    }

    @Test
    public void testLeft() {
        robotModel.setDirection(Direction.SOUTH);
        robotActions.left(robotModel);
        Assertions.assertEquals(robotModel.getDirection(), Direction.WEST);
    }

    @Test
    public void testRight() {
        robotModel.setDirection(Direction.SOUTH);
        robotActions.right(robotModel);
        Assertions.assertEquals(robotModel.getDirection(), Direction.EAST);
    }

    @Test
    public void testReport() {
        robotModel.setDirection(Direction.SOUTH);
        robotActions.report(robotModel);
    }

}
