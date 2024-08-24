public enum ShakeType {
    CHOCOLATE_SHAKE("Chocolate Shake", 230),
    COFFEE_SHAKE("Coffee Shake", 250),
    STRAWBERRY_SHAKE("Strawberry Shake", 200),
    VANILLA_SHAKE("Vanilla Shake", 190),
    ZERO_SHAKE("Zero Shake", 240);
    private final String type;
    private final double price;

    ShakeType(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
