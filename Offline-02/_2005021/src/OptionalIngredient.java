public enum OptionalIngredient {
    CANDY_TOPPING("Candy Topping", 50),
    COOKIES_TOPPING("Cookies Topping", 40);
    private final String name;
    private final double price;
    OptionalIngredient(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
