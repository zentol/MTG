package Effect;

public abstract class ActivatedEffect extends Effect {

    public ActivatedEffect(int targetCount) {
        super(targetCount, KEY_EFFECT_TYPE_ACTIVATED);
    }
}
