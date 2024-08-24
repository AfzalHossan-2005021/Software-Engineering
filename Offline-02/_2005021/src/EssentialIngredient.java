public enum EssentialIngredient {
    REGULAR_MILK("Regular milk"),
    CHOCOLATE_SYRUP("Chocolate syrup"),
    CHOCOLATE_ICE_CREAM("Chocolate ice cream"),
    COFFEE("Coffee"),
    JELLO("Jello"),
    STRAWBERRY_SYRUP("Strawberry syrup"),
    STRAWBERRY_ICE_CREAM("Strawberry ice cream"),
    VANILLA_FLAVORING("Vanilla flavoring"),
    SWEETENER("Sweetener"),
    SUGAR("Sugar"),
    SUGAR_FREE_JELLO("Sugar-free jello");
    private final String name;

    EssentialIngredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
