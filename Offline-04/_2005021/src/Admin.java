import java.util.Scanner;

public class Admin implements Runnable {
    public Admin(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] commandWords = command.split(" ");
            if(commandWords.length == 3) {
                String stockName = commandWords[1];
                if(commandWords[0].equalsIgnoreCase("I")){
                    double priceDiff = Double.parseDouble(commandWords[2]);
                    Server.stockHashMap.get(stockName).increasePrice(priceDiff);
                } else if (commandWords[0].equalsIgnoreCase("D")) {
                    double priceDiff = Double.parseDouble(commandWords[2]);
                    Server.stockHashMap.get(stockName).decreasePrice(priceDiff);
                } else if (commandWords[0].equalsIgnoreCase("C")) {
                    int newCount = Integer.parseInt(commandWords[2]);
                    Server.stockHashMap.get(stockName).setCount(newCount);
                }
            }
        }
    }
}
