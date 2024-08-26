import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static final String serverAddress = "127.0.0.1";
    static final int serverPort = 12345;
    public static SocketWrapper socketWrapper;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                socketWrapper = new SocketWrapper(new Socket(serverAddress, serverPort));
                break;
            } catch (IOException exception) {
                System.out.println("Trying to connect to server...");
            }
        }
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        try {
            socketWrapper.write(name);
            System.out.println("Connected to server.");
        } catch (IOException exception) {
            System.out.println("Server writing failed.");
        }
        new ReadThread();
        while (true) {
            String command = scanner.nextLine();
            String[] commandWords = command.split(" ");
            if(commandWords.length != 0){
                if(commandWords[0].equalsIgnoreCase("S")){
                    try {
                        socketWrapper.write("Subscribe");
                        if(commandWords.length == 2){
                            socketWrapper.write(commandWords[1]);
                        } else {
                            System.out.println("Invalid command.");
                        }
                    } catch (IOException exception) {
                        System.out.println("Server writing failed.");
                    }
                } else if (commandWords[0].equalsIgnoreCase("U")) {
                    try {
                        socketWrapper.write("Unsubscribe");
                        if(commandWords.length == 2){
                            socketWrapper.write(commandWords[1]);
                        } else {
                            System.out.println("Invalid command.");
                        }
                    } catch (IOException exception) {
                        System.out.println("Server writing failed.");
                    }
                } else if (commandWords[0].equalsIgnoreCase("V")) {
                    try {
                        socketWrapper.write("View");
                    } catch (IOException exception){
                        System.out.println("Server writing failed.");
                    }
                } else if (commandWords[0].equalsIgnoreCase("E")) {
                    try {
                        socketWrapper.closeConnection();
                    } catch (IOException exception) {
                        System.out.println("You are disconnected from server.");
                    }
                    break;
                } else {
                    System.out.println("Invalid command.");
                }
            } else {
                System.out.println("Invalid command.");
            }
        }
    }
}
