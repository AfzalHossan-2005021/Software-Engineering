public interface Builder {
    void addEssentialIngredient(EssentialIngredient essentialIngredient);
    void addOptionalIngredient(OptionalIngredient optionalIngredient);
    void replaceIngredient(ReplaceableIngredient replaceableIngredient);
}