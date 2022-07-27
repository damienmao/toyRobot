import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RunnerTest {
    @InjectMocks
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Runner runner;
    @Mock
    private Manager manager;
    @Mock
    private Actions actions;
    @Mock
    private Validation validation;
    @Mock
    private Robot robot;

    @BeforeEach
    void setup() {
        runner = new Runner();
    }

    @Test
    public void test1() {
        String input = "place\\npla";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] str = new String[3];
        try {
            Runner.main(str);
        } catch (NoSuchElementException e) {
            System.out.println();
        }
    }

    @Test
    public void test2() {
        String input = "PLACE 3 3 SOUTH";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] str = new String[3];
        try {
            Runner.main(str);
            if (outContent.toString().trim().equals("Robot is placed at 3 3 facing SOUTH")) {
                Thread.sleep(2000);
                String input1 = "PLACE 3 3 SOUTH";
                InputStream in1 = new ByteArrayInputStream(input1.getBytes());
                System.setIn(in1);
            }

        } catch (NoSuchElementException | InterruptedException e) {
            System.out.println();

        }

    }

}
