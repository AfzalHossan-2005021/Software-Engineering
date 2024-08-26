import java.io.IOException;
import java.util.ArrayList;

public class ReadWriteThread implements Runnable{
    String fromClient;
    private final Client client;
    public ReadWriteThread(Client client) {
        this.client = client;
        new Thread(this).start();
    }

    @Override
    public void run(){
        try {
            while (true){
                fromClient = (String) client.getSocketWrapper().read();
                switch (fromClient) {
                    case "Subscribe" -> {
                        String stockName = (String) client.getSocketWrapper().read();
                        boolean status = Server.notificationManager.subscribe(client, stockName);
                        if(status){
                            client.addSubscription(stockName);
                            client.getSocketWrapper().write("Subscription successful.");
                        } else {
                            client.getSocketWrapper().write("Subscription failed.");
                        }
                    }
                    case "Unsubscribe" -> {
                        String stockName = (String) client.getSocketWrapper().read();
                        boolean status = Server.notificationManager.unsubscribe(client, stockName);
                        if(status){
                            client.getSubscriptions().remove(stockName);
                            client.getSocketWrapper().write("Unsubscription successful.");
                        } else {
                            client.getSocketWrapper().write("Unsubscription failed.");
                        }
                    }
                    case "View" -> {
                        client.getSocketWrapper().write("Subscription");
                        ArrayList<String> stockInfo = new ArrayList<>();
                        for(String stockName : client.getSubscriptions()){
                            Stock stock = Server.stockHashMap.get(stockName);
                            stockInfo.add(stock.getName() + " -> count: " + stock.getCount() + " price: " + stock.getPrice());
                        }
                        client.getSocketWrapper().write(stockInfo);
                    }
                }
            }
        } catch (Exception exception){
            System.out.println(client.getName() + " is disconnected.");
        } finally {
            try {
                client.getSocketWrapper().closeConnection();
                client.setSocketWrapper(null);
            }catch (IOException exception){
                exception.printStackTrace(System.out);
            }
        }
    }
}