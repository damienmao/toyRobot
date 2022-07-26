import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ManagerTest {

    private Manager manager;
    @Mock
    private Validation validation;
    @Mock
    private Actions actions;


    @BeforeEach
    void setup() {
        manager = new Manager(validation, actions);
    }

    @Test
    public void testInput() {

        String input = "place\\npla";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertEquals("place\\npla", manager.getInput());
    }

    @Test
    public void testValidateFirstCommand() {
        Robot robot = new Robot();
        String input = "PLACE 3 3 SOUTH";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        when(validation.validateFirstCommand(anyString())).thenReturn(true);
        Assertions.assertEquals(manager.validateFirstCommand(robot, input), true);

    }

    @Test
    public void testValidateFirstCommandFalseCondition() {
        Robot robot = new Robot();
        String input = "PLACE 3 3 SOUTH";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        when(validation.validateFirstCommand(anyString())).thenReturn(false);
        Assertions.assertEquals(manager.validateFirstCommand(robot, input), false);
    }

    @Test
    public void testValidateFollowingCommand() throws IOException {
//        Robot robot = new Robot();
//        String input = "PLACE 3 3 SOUTH\r\nmove";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        when(validation.validateFirstCommand(anyString())).thenReturn(true);
//        //   when(validation.validateIfOutOfBound(robot)).thenReturn(false);
//        // when(actions.move(robot)).thenReturn(robot);

//        Boolean firstValidCommand = manager.validateFirstCommand(robot);
        Boolean firstValidCommand = true;


//        String input1 = "MOVE";
//        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
//        Boolean thisIsCalled = false;
//        manager.getInput();
//        try {
//            manager.validateFollowingCommand(robot);
//        {
//                if (in.available() == 0) System.setIn(in1);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String input11 = "MOVE";
//        InputStream in11 = new ByteArrayInputStream(input11.getBytes());
//        System.setIn(in11);
//       verify(actions).move(robot);

    }


}
