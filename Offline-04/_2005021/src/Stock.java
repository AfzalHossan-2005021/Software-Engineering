public class Stock {
    private final String name;
    private int count;
    private double price;

    public Stock(String[] stockInfo){
        this.name = stockInfo[0];
        this.count = Integer.parseInt(stockInfo[1]);
        this.price = Double.parseDouble(stockInfo[2]);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public void setCount(int count) {
        this.count = count;
        Server.notificationManager.notifySubscribers(this.name, "Stock count changed.");
    }

    public void increasePrice(double price) {
        this.price += price;
        Server.notificationManager.notifySubscribers(this.name, "Stock price increased.");
    }

    public void decreasePrice(double price){
        this.price -= price;
        Server.notificationManager.notifySubscribers(this.name, "Stock price decreased.");
    }
}
