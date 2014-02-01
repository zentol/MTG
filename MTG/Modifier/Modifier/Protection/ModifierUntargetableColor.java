package Modifier.Protection;

import Card.Card;

public class ModifierUntargetableColor extends TargetingModifier {
    private final int color;

    public ModifierUntargetableColor(Card source, int color) {
        super(source);
        this.color = color;
    }

    @Override
    public boolean preventsTargeting(Card targeter) {
        
        int targeterColors = targeter.colors;
        for (int x = 1; x < 6; x++) {
            if ((this.color & x) == x && (targeterColors & x) == x) {
                return true;
            }
        }
        return false;
    }
}
