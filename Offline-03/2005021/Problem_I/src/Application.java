import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        CrewmateSystemInterface crewmateSystem = new CrewmateSystem();
        ImposterSystemInterface imposterSystem = new ImposterSystemAdapter(crewmateSystem);
        Scanner scanner = new Scanner(System.in);
        while (true){
            String[] commands = scanner.nextLine().split(" ");
            if (commands[0].equalsIgnoreCase("login")) {
                try {
                    if (commands[1].startsWith("crew")) {
                        handleCrew(crewmateSystem);
                    } else if (commands[1].startsWith("imp")) {
                        handleImposter(imposterSystem);
                    }
                } catch (Exception exception) {
                    System.out.println("Please define user.");
                }
            } else if (commands[0].equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
    }
    private static void handleCrew(CrewmateSystemInterface crewmateSystem){
        Scanner scanner = new Scanner(System.in);
        crewmateSystem.login();
        while (true){
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("repair")) {
                crewmateSystem.repair();
            } else if (command.equalsIgnoreCase("work")) {
                crewmateSystem.work();
            } else if (command.equalsIgnoreCase("logout")) {
                crewmateSystem.logout();
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
    }
    private static void handleImposter(ImposterSystemInterface imposterSystem){
        Scanner scanner = new Scanner(System.in);
        imposterSystem.login();
        while (true){
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("repair")) {
                imposterSystem.repair();
            } else if (command.equalsIgnoreCase("work")) {
                imposterSystem.work();
            } else if (command.equalsIgnoreCase("logout")) {
                imposterSystem.logout();
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
    }
}
