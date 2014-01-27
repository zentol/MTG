package Game.Phase;

public class Ending {
    public static void phaseEnding() {
        stepEnd();
        stepCleanup();
    }

    private static void stepEnd() {
        triggerBeginningEndStep();
        triggerBeginningNextEndStep();
    }

    private static void stepCleanup() {
        discardCards();
        //simoultaneously
        removeAllDamage();
        finishUntilEndOfTurn();
    }

}
