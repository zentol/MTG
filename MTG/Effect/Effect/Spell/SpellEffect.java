package Effect.Spell;

import Effect.Effect;

public abstract class SpellEffect extends Effect {

    public SpellEffect(int targetCount) {
        super(targetCount);
    }

    @Override
    public int getType() {
        return KEY_EFFECT_TYPE_SPELL;
    }
}
