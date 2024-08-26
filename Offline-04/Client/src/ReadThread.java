import java.io.IOException;
import java.util.ArrayList;

public class ReadThread implements Runnable{
    public Thread thread;
    ReadThread(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        while (true) {
            String header = null;
            Object object = null;
            try {
                header = (String) Client.socketWrapper.read();
            } catch (IOException | ClassNotFoundException exception) {
                System.out.println("Socket closed.");
            }

            if(header == null){
                System.out.println("Connection lost.");
                break;
            }
            if(header.equalsIgnoreCase("Notification")){
                try {
                    object = Client.socketWrapper.read();
                } catch (IOException | ClassNotFoundException exception) {
                    System.out.println("Socket closed.");
                }
                ArrayList<String> notifications = (ArrayList<String>) object;
                assert notifications != null;
                if(!notifications.isEmpty()){
                    System.out.println("Notifications:");
                    for (String notification : notifications){
                        System.out.println(notification);
                    }
                }
            } else if (header.equalsIgnoreCase("Subscription")) {
                try {
                    object = Client.socketWrapper.read();
                } catch (IOException | ClassNotFoundException exception) {
                    System.out.println("Socket closed.");
                }
                ArrayList<String> subscriptions = (ArrayList<String>) object;
                assert subscriptions != null;
                if(!subscriptions.isEmpty()){
                    System.out.println("Subscriptions:");
                    for (String subscription : subscriptions){
                        System.out.println(subscription);
                    }
                }
            } else if (header.equalsIgnoreCase("All Socket Info")) {
                try {
                    object = Client.socketWrapper.read();
                } catch (IOException | ClassNotFoundException exception) {
                    System.out.println("Socket closed.");
                }
                ArrayList<String> allStockInfo = (ArrayList<String>) object;
                assert allStockInfo != null;
                if(!allStockInfo.isEmpty()){
                    System.out.println("All Socket Info:");
                    for (String stockInfo : allStockInfo){
                        System.out.println(stockInfo);
                    }
                }
            } else {
                System.out.println(header);
            }
        }
    }
}
