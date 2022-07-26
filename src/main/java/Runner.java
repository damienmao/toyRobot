public class Runner {

    public static void main(String[] args) {

        System.out.println("Toy Robot started...taking first command");
        Boolean firstValidCommand =false;
        Manager manager = new Manager(new Validation(), new Actions());
        Robot robot = new Robot();
        String command = manager.getInput();


            while (firstValidCommand.equals(false)) {
                firstValidCommand = manager.validateFirstCommand(robot, command);
            }
                while(firstValidCommand) {
                manager.validateFollowingCommand(robot, command);
            }

    }
}
