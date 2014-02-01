package Effect.Activated;

import Effect.Effect;

public abstract class ActivatedEffect extends Effect {

    public ActivatedEffect(boolean targeting) {
        super(targeting);
    }

    @Override
    public int getType() {
        return KEY_TYPE_EFFECT_ACTIVATED;
    }
}
