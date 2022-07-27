public class Runner {

    public static void main(String[] args) {

        RobotValidation robotValidation = new RobotValidation();
        RobotActions robotActions = new RobotActions();
        RobotModel robotModel = new RobotModel();
        RobotManager robotManager = new RobotManager(robotValidation, robotActions, robotModel);
        System.out.println("Toy Robot started...taking first command");
        robotManager.firstValidation();
        while (robotManager.getFirstValidCommand()) {
            robotManager.secondValidation();
        }
    }
}
