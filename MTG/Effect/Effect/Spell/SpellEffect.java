package Effect.Spell;

import Effect.Effect;

public abstract class SpellEffect extends Effect {

    public SpellEffect(boolean targeting) {
        super(targeting);
    }

    @Override
    public int getType() {
        return KEY_TYPE_EFFECT_SPELL;
    }
}
