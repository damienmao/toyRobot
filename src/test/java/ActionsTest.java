import Constants.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionsTest{

    private  Actions actions;
    private Robot robot;

    @BeforeEach
    void setup(){
        actions = new Actions();
        robot= new Robot();
        robot.setY(1);
        robot.setX(1);
    }
    @Test
    public void testMoveToEast(){
        robot.setDirection(Direction.EAST);
        actions.move(robot);
        Assertions.assertEquals(robot.getX(),2);
    }
    @Test
    public void testMoveToWest(){
        robot.setDirection(Direction.WEST);
        actions.move(robot);
        Assertions.assertEquals(robot.getX(),0);
    }
    @Test
    public void testMoveToNorth(){
        robot.setDirection(Direction.NORTH);
        actions.move(robot);
        Assertions.assertEquals(robot.getY(),2);
    }
    @Test
    public void testMoveToSouth(){
        robot.setDirection(Direction.SOUTH);
        actions.move(robot);
        Assertions.assertEquals(robot.getY(),0);
    }
    @Test
    public void testLeft(){
        robot.setDirection(Direction.SOUTH);
        actions.left(robot);
        Assertions.assertEquals(robot.getDirection(),Direction.WEST);
    }
    @Test
    public void testRight(){
        robot.setDirection(Direction.SOUTH);
        actions.right(robot);
        Assertions.assertEquals(robot.getDirection(),Direction.EAST);
    }
    @Test
    public void testReport(){
        robot.setDirection(Direction.SOUTH);
        actions.report(robot);
    }

}
