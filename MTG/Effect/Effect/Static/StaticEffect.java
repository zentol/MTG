package Effect.Static;

import Effect.Effect;

public abstract class StaticEffect extends Effect {

    public StaticEffect(boolean targeting) {
        super(targeting);
    }

    @Override
    public int getType() {
        return KEY_TYPE_EFFECT_STATIC;
    }
}
