package Effect;

import Effect.Action.EffectAction;
import Effect.Type.EffectType;

public class Effect<T extends EffectType, A extends EffectAction> {
    private T type;
    private A action;
}
