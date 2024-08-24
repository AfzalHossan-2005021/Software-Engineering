import java.util.EnumSet;

public class ShakeBuilder implements Builder {
    private ShakeType shakeType;
    private EnumSet<EssentialIngredient> essentialIngredients;
    private EnumSet<ReplaceableIngredient> replacingIngredients;
    private EnumSet<OptionalIngredient> optionalIngredients;

    public Shake buildShake(){
        return new Shake(this);
    }

    public void reset(){
        this.shakeType = null;
        this.essentialIngredients = EnumSet.noneOf(EssentialIngredient.class);
        this.replacingIngredients = EnumSet.noneOf(ReplaceableIngredient.class);
        this.optionalIngredients = EnumSet.noneOf(OptionalIngredient.class);
    }
    public ShakeType getShakeType() {
        return shakeType;
    }

    public EnumSet<EssentialIngredient> getEssentialIngredients() {
        return essentialIngredients;
    }

    public EnumSet<ReplaceableIngredient> getReplacingIngredients() {
        return replacingIngredients;
    }

    public EnumSet<OptionalIngredient> getOptionalIngredients() {
        return optionalIngredients;
    }

    public void setShakeType(ShakeType shakeType) {
        this.shakeType = shakeType;
    }

    @Override
    public void addEssentialIngredient(EssentialIngredient essentialIngredient){
        this.essentialIngredients.add(essentialIngredient);
    }
    @Override
    public void addOptionalIngredient(OptionalIngredient optionalIngredient){
        this.optionalIngredients.add(optionalIngredient);
    }
    @Override
    public void replaceIngredient(ReplaceableIngredient replaceableIngredient){
        this.essentialIngredients.remove(replaceableIngredient.getReplacedIngredient());
        this.replacingIngredients.add(replaceableIngredient);
    }
}