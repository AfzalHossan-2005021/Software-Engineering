import java.util.ArrayList;
public class OrderBuilder {
    private final ArrayList<Item> orderedItems;
    public OrderBuilder(){
        orderedItems = new ArrayList<>();
    }
    public void reset(){
        orderedItems.clear();
    }
    public void addItem(Item newItem){
        orderedItems.add(newItem);
    }
    public ArrayList<Item> getOrderedItems(){
        return orderedItems;
    }
    public boolean isNotEmpty(){
        return !orderedItems.isEmpty();
    }
    public Order build(){
        return new Order(this);
    }
}