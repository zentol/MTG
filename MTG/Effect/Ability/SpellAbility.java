package Ability;

public abstract class SpellAbility extends Ability {

    public SpellAbility(int targetCount) {
        super(targetCount, KEY_ABILITY_TYPE_SPELL);
    }
}
