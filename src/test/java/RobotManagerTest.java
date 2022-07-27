import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RobotManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private RobotManager robotManager;
    @Mock
    private RobotActions robotActions;
    @Mock
    private RobotValidation robotValidation;
    @Mock
    private RobotModel robotModel;

    @BeforeEach
    void setup() {
        robotManager = new RobotManager(robotValidation, robotActions, robotModel);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testInput() {

        String input = "place\\npla";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String command = new Scanner(System.in).nextLine();
        Assertions.assertEquals("place\\npla", command);
    }

    @Test
    public void testFirst() {
        String input = "PLACE 3 3 SOUTH";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //String command = new Scanner(System.in).nextLine(); //dont assign this to a string, this will consume the system inputstream
        when(robotValidation.validateFirstCommand(anyString())).thenReturn(true);
        robotManager.firstValidation();
        Assertions.assertEquals(robotManager.getFirstValidCommand(), true);
    }

    @Test
    public void testActionMove() {
        String input = "MOVE";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        robotManager.secondValidation();
        verify(robotValidation).validateIfOutOfBound(robotModel);
        verify(robotActions).move(robotModel);

        String input1 = "MOVE";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);
        when(robotValidation.validateIfOutOfBound(robotModel)).thenReturn(true);
        robotManager.secondValidation();
        Assertions.assertEquals("Please use 'LEFT' to turn left or 'RIGHT' to turn right", outContent.toString().trim());
    }

    @Test
    public void testActionLeft() {
        String input = "LEFT";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        robotManager.secondValidation();
        verify(robotActions).left(robotModel);
    }

    @Test
    public void testActionRight() {
        String input = "RIGHT";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        robotManager.secondValidation();
        verify(robotActions).right(robotModel);
    }

    @Test
    public void testActionReport() {
        String input = "REPORT";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        robotManager.secondValidation();
        verify(robotActions).report(robotModel);
    }

    @Test
    public void testActionReplaceRobot() {
        String input = "PLACE 3 3 SOUTH";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        when(robotValidation.validateFirstCommand(input)).thenReturn(true);
        robotManager.secondValidation();
        verify(robotActions).placeRobot(input, robotModel);
    }

    @Test
    public void testActionInvalid() {
        String input = "d";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        robotManager.secondValidation();
        Assertions.assertEquals("Please input correct command for this robot:", outContent.toString().trim());

    }
}
