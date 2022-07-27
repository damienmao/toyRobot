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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Manager manager;
    @Mock
    private Actions actions;
    @Mock
    private Validation validation;
    @Mock
    private Robot robot;

    @BeforeEach
    void setup() {
        manager = new Manager(validation, actions, robot);
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
        when(validation.validateFirstCommand(anyString())).thenReturn(true);
        manager.firstValidation();
        Assertions.assertEquals(manager.getFirstValidCommand(), true);
    }

    @Test
    public void testActionMove() {
        String input = "MOVE";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manager.secondValidation();
        verify(validation).validateIfOutOfBound(robot);
        verify(actions).move(robot);

        String input1 = "MOVE";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);
        when(validation.validateIfOutOfBound(robot)).thenReturn(true);
        manager.secondValidation();
        Assertions.assertEquals("Please use 'LEFT' to turn left or 'RIGHT' to turn right", outContent.toString().trim());
    }

    @Test
    public void testActionLeft() {
        String input = "LEFT";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manager.secondValidation();
        verify(actions).left(robot);
    }

    @Test
    public void testActionRight() {
        String input = "RIGHT";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manager.secondValidation();
        verify(actions).right(robot);
    }

    @Test
    public void testActionReport() {
        String input = "REPORT";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manager.secondValidation();
        verify(actions).report(robot);
    }
    @Test
    public void testActionReplaceRobot() {
        String input = "PLACE 3 3 SOUTH";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        when(validation.validateFirstCommand(input)).thenReturn(true);
        manager.secondValidation();
        verify(actions).placeRobot(input,robot);
    }
    @Test
    public void testActionInvalid() {
        String input = "d";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manager.secondValidation();
        Assertions.assertEquals("Please input correct command for this robot:", outContent.toString().trim());

    }
}
