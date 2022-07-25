import java.util.Locale;
import java.util.Scanner;

public class Command {
    Scanner scanner = new Scanner(System.in);
    public String command = scanner.nextLine();

//    public Command() {
//    }
//
//    public Command( String command) {
//        this.command = command;
//    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

}
