package Game.Phase;

import Card.Permanent;

public class Combat {
    public static void phaseCombat() {
        stepBeginning();
        stepDeclareAttackers();
        stepDeclareBlockers();
        stepDamage();
        stepEnding();
    }

    private static void stepBeginning() {
        triggerBeginningOfCombat();
    }

    private static void stepDeclareAttackers() {
        Permanent[] toAttack = selectAttackers();
        checkAttackRestrictions(toAttack);
        tap(toAttack);
    }

    private static void stepDeclareBlockers() {
        Permanent[] toBlock = selectBlockers();
        checkBlockRestrictions(toBlock);
        checkBlockRequirements(toBlock);
    }

    private static void stepDamage() {

    }

    private static void stepEnding() {

    }

}
