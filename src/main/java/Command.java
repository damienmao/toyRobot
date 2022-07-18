import java.util.Locale;
import java.util.Scanner;

public class Command {
    Scanner scanner = new Scanner(System.in);
    public String command = scanner.next();




    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

}
