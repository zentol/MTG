package Game.Phase;

public class Beginning {
    public static void phaseBeginning() {
        stepUntap();
        stepUpkeep();
        stepDraw();
    }

    private static void stepUntap() {
        triggerPhaseInOut();
        untapChosen();
    }

    private static void stepUpkeep() {
        triggerBeginningOfUpkeep();
        triggerBeginningOFNextUpkeep();
    }

    private static void stepDraw() {
        drawCard();
        triggerBeginningOfDraw();
    }

}
