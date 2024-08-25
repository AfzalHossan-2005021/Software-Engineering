import java.util.Scanner;

public class FileSystem {
    public static void main(String[] args) {
        Composite root = Root.getRoot();
        Composite current = root;
        Scanner scanner = new Scanner(System.in);
        while (true){
            String[] command = scanner.nextLine().split(" ");
            try {
                if(command[0].equalsIgnoreCase("cd")){
                    try{
                        if(command[1].equalsIgnoreCase("~")){
                            current = root;
                        } else if (command[1].equalsIgnoreCase("../")) {
                            current = current.getParent();
                        } else if(current.getComponents().containsKey(command[1])){
                            Component component = current.getComponents().get(command[1]);
                            if(component instanceof File){
                                System.out.println("Error: Target is a file.");
                            } else {
                                current = (Composite) component;
                            }
                        } else {
                            System.out.println("Error: There is no Folder with this name.");
                        }
                    } catch (Exception e) {
                        System.out.println("Incomplete command.");
                    }
                } else if (command[0].equalsIgnoreCase("ls")) {
                    try {
                        if(current.getComponents().containsKey(command[1])){
                            current.showDetails(command[1]);
                        } else {
                            System.out.println("Error: There is no Folder with this name.");
                        }
                    } catch (Exception exception) {
                        System.out.println("Incomplete command.");
                    }
                } else if (command[0].equalsIgnoreCase("list")) {
                    current.showComponentList();
                } else if (command[0].equalsIgnoreCase("delete")) {
                    try {
                        if(command[1].equalsIgnoreCase("-r")){
                            if(current.getComponents().containsKey(command[2])){
                                current.recursiveDelete(command[2]);
                            } else {
                                System.out.println("Error: There is no Folder with this name.");
                            }
                        } else {
                            if(current.getComponents().containsKey(command[1])){
                                current.Delete(command[1]);
                            } else {
                                System.out.println("Error: There is no Folder with this name.");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Incomplete delete command.");
                    }
                } else if (command[0].equalsIgnoreCase("mkdir")) {
                    try {
                        current.makeDirectory(command[1]);
                    } catch (Exception e) {
                        System.out.println("Incomplete command.");
                    }
                } else if (command[0].equalsIgnoreCase("touch")) {
                    try {
                        current.createFile(command[1], Double.parseDouble(command[2]));
                    } catch (Exception e) {
                        System.out.println("Incomplete command.");
                    }
                } else if (command[0].equalsIgnoreCase("mkdrive")) {
                    try {
                        current.makeDrive(command[1]);
                    } catch (Exception e) {
                        System.out.println("Incomplete command.");
                    }
                } else if (command[0].equalsIgnoreCase("exit")) {
                    break;
                } else {
                    System.out.println("Invalid command.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid command.");
            }
        }
    }
}
