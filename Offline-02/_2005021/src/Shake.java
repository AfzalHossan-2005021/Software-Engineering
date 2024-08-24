import java.util.EnumSet;

public class Shake implements Item {
    private final ShakeType shakeType;
    private final EnumSet<EssentialIngredient> essentialIngredients;
    private final EnumSet<ReplaceableIngredient> replacingIngredients;
    private final EnumSet<OptionalIngredient> optionalIngredients;

    public Shake(ShakeBuilder ShakeBuilder) {
        this.shakeType = ShakeBuilder.getShakeType();
        this.essentialIngredients = ShakeBuilder.getEssentialIngredients().clone();
        this.replacingIngredients = ShakeBuilder.getReplacingIngredients().clone();
        this.optionalIngredients = ShakeBuilder.getOptionalIngredients().clone();
    }

    @Override
    public void print() {
        System.out.println("\t" + shakeType.getType() + " :");
        System.out.println("\t\tBase price: TK " + shakeType.getPrice());
        int printIndex = 1;
        if(!essentialIngredients.isEmpty()){
            System.out.println("\t\tBase ingredients:");
            for (EssentialIngredient essentialIngredient : essentialIngredients) {
                System.out.println("\t\t\t" + (printIndex++) + ".\t" + essentialIngredient.getName());
            }
        }
        printIndex = 1;
        if(replacingIngredients.size() + optionalIngredients.size() > 0){
            System.out.println("\t\tAdded ingredients:");
            for (ReplaceableIngredient replaceableIngredient : replacingIngredients) {
                System.out.println("\t\t\t" + (printIndex++) + ".\t" + replaceableIngredient.getName() + " : TK " + replaceableIngredient.getPrice());
            }
            for (OptionalIngredient optionalIngredient : optionalIngredients) {
                System.out.println("\t\t\t" + (printIndex++) + ".\t" + optionalIngredient.getName() + " : TK " + optionalIngredient.getPrice());
            }
        }
        System.out.println("\tTotal item price : TK " + getTotalPrice());
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = shakeType.getPrice();
        for (ReplaceableIngredient replaceableIngredient : replacingIngredients) {
            totalPrice += replaceableIngredient.getPrice();
        }
        for (OptionalIngredient optionalIngredient : optionalIngredients) {
            totalPrice += optionalIngredient.getPrice();
        }
        return totalPrice;
    }
}