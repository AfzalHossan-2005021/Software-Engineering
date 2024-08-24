import java.util.Scanner;

public class OrderManagementSystem {
    public static void main(String[] args) {
        ShakeBuilder ShakeBuilder = new ShakeBuilder();
        OrderBuilder orderBuilder = new OrderBuilder();

        ShakeType[] shakeTypes = ShakeType.values();
        ReplaceableIngredient[] replaceableIngredients = ReplaceableIngredient.values();
        OptionalIngredient[] optionalIngredients = OptionalIngredient.values();

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Press 'o' to open order : ");
            String placeOrder = scanner.nextLine();

            if(placeOrder.equalsIgnoreCase("o")){
                orderBuilder.reset();

                while (true){
                    if(orderBuilder.isNotEmpty()){
                        System.out.println("Choose next item:");
                    }else {
                        System.out.println("Choose an item:");
                    }

                    System.out.println("The shakes are as follows:");
                    for (int i = 0; i < shakeTypes.length; i++){
                        System.out.println("\t" + (i + 1) + ".\t" + shakeTypes[i].getType() + ": Tk " + shakeTypes[i].getPrice());
                    }

                    System.out.println("Press 'e' for close order");
                    System.out.print("Enter your choice: ");
                    String choice = scanner.nextLine();
                    if(choice.equalsIgnoreCase("o")){
                        System.out.println("Error: An order is still open.");
                        System.out.print("Do you want to include something else in the current order(y/n)? ");
                        String exitOption = scanner.nextLine();
                        if(exitOption.equalsIgnoreCase("n")){
                            if(orderBuilder.isNotEmpty()){
                                Order order = orderBuilder.build();
                                order.print();
                                break;
                            }else {
                                System.out.println("You must order at least one item before closing.");
                            }
                        }
                    }else if(choice.equalsIgnoreCase("e")){
                        if(orderBuilder.isNotEmpty()){
                            Order order = orderBuilder.build();
                            order.print();
                            break;
                        }else {
                            System.out.println("You must order at least one item before closing.");
                        }
                    }else {
                        try {
                            int shakeTypeIndex = Integer.parseInt(choice);
                            if(shakeTypeIndex > shakeTypes.length){
                                System.out.println("Please choose a valid item.");
                            }else{
                                Director.buildShake(shakeTypes[shakeTypeIndex-1], ShakeBuilder);

                                System.out.print("Do you want to customize your order(y/n): ");
                                String customizationChoice = scanner.nextLine();
                                if(customizationChoice.equalsIgnoreCase("y")){
                                    boolean invalidChoice = true;
                                    while (invalidChoice){
                                        invalidChoice = false;
                                        int printIndex = 1;

                                        int replacementOptionCount = replaceableIngredients.length;
                                        int totalOptionCount = replacementOptionCount + optionalIngredients.length;

                                        System.out.println("Customize shakes with the following options:");
                                        for (ReplaceableIngredient replaceableIngredient : replaceableIngredients) {
                                            System.out.println("\t" + (printIndex++) + ".\t" + replaceableIngredient.getName() + " instead of " + replaceableIngredient.getReplacedIngredient().getName() + ": Base price + Tk " + replaceableIngredient.getPrice());
                                        }
                                        for (OptionalIngredient optionalIngredient : optionalIngredients) {
                                            System.out.println("\t" + (printIndex++) + ".\t" + optionalIngredient.getName() + ": Base price + Tk " + optionalIngredient.getPrice());
                                        }
                                        System.out.print("Choose one or more options: ");

                                        String[] strChoiceList = scanner.nextLine().split(" ");
                                        int [] numChoiceList = new int[strChoiceList.length];

                                        for (int i = 0; i < strChoiceList.length; i++){
                                            try {
                                                int optionalChoice = Integer.parseInt(strChoiceList[i]);
                                                if(optionalChoice > totalOptionCount){
                                                    System.out.println("Invalid choice");
                                                    invalidChoice = true;
                                                }
                                                numChoiceList[i] = optionalChoice;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid choice");
                                                invalidChoice = true;
                                            }

                                        }
                                        if(!invalidChoice){
                                            for (int i : numChoiceList) {
                                                if (i > replacementOptionCount) {
                                                    ShakeBuilder.addOptionalIngredient(optionalIngredients[i - replacementOptionCount - 1]);
                                                } else {
                                                    ShakeBuilder.replaceIngredient(replaceableIngredients[i - 1]);
                                                }
                                            }
                                        }
                                    }
                                }
                                else if(!customizationChoice.equalsIgnoreCase("n")){
                                    System.out.println("Invalid choice.");
                                }
                                Shake shake = ShakeBuilder.buildShake();
                                orderBuilder.addItem(shake);
                            }
                        } catch (NumberFormatException exception) {
                            System.out.println("An error occurred.");
                        }
                    }
                    System.out.println();
                }

            } else if (placeOrder.equalsIgnoreCase("e")) {
                System.out.println("There is no open order.");
            } else if (placeOrder.equalsIgnoreCase("exit")) {
                break;
            }else {
                System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }
}