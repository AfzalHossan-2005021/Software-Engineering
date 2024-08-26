import java.io.IOException;
import java.util.ArrayList;

public class Client implements Subscriber {
    private final String name;
    private final ArrayList<String> subscriptions;
    private final ArrayList<String> notifications;
    private SocketWrapper socketWrapper;

    public Client(String name, SocketWrapper socketWrapper) {
        this.name = name;
        this.subscriptions = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.socketWrapper = socketWrapper;
    }

    public String getName() {
        return name;
    }

    public SocketWrapper getSocketWrapper() {
        return socketWrapper;
    }

    public void setSocketWrapper(SocketWrapper socketWrapper) {
        this.socketWrapper = socketWrapper;
    }

    public ArrayList<String> getSubscriptions() {
        return subscriptions;
    }

    public void addSubscription(String subscription){
        subscriptions.add(subscription);
    }

    public void update(String notification){
        notifications.add(notification);
        sendNotification();
    }

    public void sendNotification(){
        if(socketWrapper != null){
            try {
                socketWrapper.write("Notification");
                socketWrapper.write(notifications);
                notifications.clear();
            } catch (IOException exception) {
                System.out.println("An error occur during sending notification.");
            }
        }
    }

    public void sendAllStockInfo(){

        ArrayList<String> stockInfo = new ArrayList<>();
        for(String stockName : Server.stockHashMap.keySet()){
            Stock stock = Server.stockHashMap.get(stockName);
            stockInfo.add(stock.getName() + " -> count: " + stock.getCount() + " price: " + stock.getPrice());
        }
        try {
            socketWrapper.write("All Socket Info");
            socketWrapper.write(stockInfo);
        } catch (IOException exception) {
            System.out.println("An error occur while writing to client.");
        }
    }
}
