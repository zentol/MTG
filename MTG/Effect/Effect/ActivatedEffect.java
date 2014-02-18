package Effect;

import Effect.Effect;

public abstract class ActivatedEffect extends Effect {

    public ActivatedEffect(boolean targeting) {
        super(targeting);
    }

    @Override
    public int getType() {
        return KEY_EFFECT_TYPE_ACTIVATED;
    }
}
