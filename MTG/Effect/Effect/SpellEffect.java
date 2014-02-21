package Effect;

public abstract class SpellEffect extends Effect {

    public SpellEffect(int targetCount) {
        super(targetCount, KEY_EFFECT_TYPE_SPELL);
    }
}
