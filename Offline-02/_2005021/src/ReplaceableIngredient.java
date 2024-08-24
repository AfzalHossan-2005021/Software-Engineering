public enum ReplaceableIngredient {
    ALMOND_MILK("Almond Milk", 60, EssentialIngredient.REGULAR_MILK);
    private final String name;
    private final double price;
    private final EssentialIngredient replacedIngredient;

    ReplaceableIngredient(String name, double price, EssentialIngredient replacedIngredient) {
        this.name = name;
        this.price = price;
        this.replacedIngredient = replacedIngredient;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public EssentialIngredient getReplacedIngredient() {
        return replacedIngredient;
    }
}