package Ability;

public abstract class ActivatedAbility extends Ability {

    public ActivatedAbility(int targetCount) {
        super(targetCount, KEY_ABILITY_TYPE_ACTIVATED);
    }
}
