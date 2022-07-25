import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class CommandTest {

    private Command command;

    private Scanner scanner ;

    @BeforeEach
    void setup() {
      //  scanner= new Scanner(System.in);
        command = new Command();

    }

    @Test
    public void tetGetCommand() {

     command.getCommand();
    }
}
