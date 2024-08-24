import java.util.ArrayList;

public class Order {
    private final ArrayList<Item> orderedItems;
    public Order(OrderBuilder orderBuilder){
        this.orderedItems = orderBuilder.getOrderedItems();
    }
    public void print(){
        double totalOrderPrice = 0;
        int itemCount = orderedItems.size();
        for (int i = 0; i < itemCount; i++){
            System.out.println("Item " + (i+1) + " :");
            orderedItems.get(i).print();
            totalOrderPrice += orderedItems.get(i).getTotalPrice();
        }
        System.out.println("Total price of the order : TK " + totalOrderPrice);
    }
}