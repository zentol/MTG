package Effect.Triggered;

import Effect.Effect;

public abstract class TriggeredEffect extends Effect {

    public TriggeredEffect(boolean targeting) {
        super(targeting);
    }

    @Override
    public int getType() {
        return KEY_TYPE_EFFECT_TRIGGERED;
    }
}
