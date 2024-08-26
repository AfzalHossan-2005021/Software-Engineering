import java.util.ArrayList;
import java.util.Hashtable;

public class NotificationManager {
    public Hashtable<String, ArrayList<Subscriber>> subscriberTable;

    public NotificationManager() {
        this.subscriberTable = new Hashtable<>();
    }

    public boolean subscribe(Subscriber subscriber, String stockName){
        if(!subscriberTable.containsKey(stockName)){
            return false;
        }
        subscriberTable.get(stockName).add(subscriber);
        return true;
    }
    public boolean unsubscribe(Subscriber subscriber, String stockName){
        if(!subscriberTable.containsKey(stockName)){
            return false;
        }
        subscriberTable.get(stockName).remove(subscriber);
        return true;
    }
    public void notifySubscribers(String stockName, String notification){
        for (Subscriber subscriber : subscriberTable.get(stockName)){
            subscriber.update(stockName + " : " + notification);
        }
    }

    public void addNewStock(String stockName){
        subscriberTable.put(stockName, new ArrayList<>());
    }
}
