package Effect;

public abstract class ActivatedEffect extends Effect {

    public ActivatedEffect(int targetCount) {
        super(targetCount);
    }

    @Override
    public int getType() {
        return KEY_EFFECT_TYPE_ACTIVATED;
    }
}
