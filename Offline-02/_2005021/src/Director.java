public class Director {
    public static void buildShake(ShakeType shakeType, ShakeBuilder ShakeBuilder){
        if(shakeType == ShakeType.CHOCOLATE_SHAKE){
            buildChocolateShake(ShakeBuilder);
        } else if (shakeType == ShakeType.COFFEE_SHAKE) {
            buildCoffeeShake(ShakeBuilder);
        } else if (shakeType == ShakeType.STRAWBERRY_SHAKE) {
            buildStrawberryShake(ShakeBuilder);
        } else if (shakeType == ShakeType.VANILLA_SHAKE) {
            buildVanillaShake(ShakeBuilder);
        } else if (shakeType == ShakeType.ZERO_SHAKE) {
            buildZeroShake(ShakeBuilder);
        }
    }
    private static void buildChocolateShake(ShakeBuilder ShakeBuilder){
        ShakeBuilder.reset();
        ShakeBuilder.setShakeType(ShakeType.CHOCOLATE_SHAKE);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.REGULAR_MILK);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.SUGAR);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.CHOCOLATE_SYRUP);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.CHOCOLATE_ICE_CREAM);
    }
    private static void buildCoffeeShake(ShakeBuilder ShakeBuilder){
        ShakeBuilder.reset();
        ShakeBuilder.setShakeType(ShakeType.COFFEE_SHAKE);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.REGULAR_MILK);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.SUGAR);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.COFFEE);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.JELLO);
    }
    private static void buildStrawberryShake(ShakeBuilder ShakeBuilder){
        ShakeBuilder.reset();
        ShakeBuilder.setShakeType(ShakeType.STRAWBERRY_SHAKE);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.REGULAR_MILK);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.SUGAR);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.STRAWBERRY_SYRUP);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.STRAWBERRY_ICE_CREAM);
    }
    private static void buildVanillaShake(ShakeBuilder ShakeBuilder){
        ShakeBuilder.reset();
        ShakeBuilder.setShakeType(ShakeType.VANILLA_SHAKE);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.REGULAR_MILK);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.SUGAR);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.VANILLA_FLAVORING);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.JELLO);
    }
    private static void buildZeroShake(ShakeBuilder ShakeBuilder){
        ShakeBuilder.reset();
        ShakeBuilder.setShakeType(ShakeType.ZERO_SHAKE);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.REGULAR_MILK);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.SWEETENER);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.VANILLA_FLAVORING);
        ShakeBuilder.addEssentialIngredient(EssentialIngredient.SUGAR_FREE_JELLO);
    }
}