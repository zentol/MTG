package Card.Aspect.Permanent;

public class EnchantmentAspect extends PermanentAspect {

    public EnchantmentAspect(String[] types) {
        super(types);
    }

    @Override
    public int getKey() {
        return KEY_ASPECT_ENCHANTMENT;
    }
}
