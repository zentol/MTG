package Modifier.Damaging;

import Card.Card;
import Ability.Ability;
import Modifier.Modifier;

public class ModifierInvulnerableColor extends Modifier {
    private final int color;

    public ModifierInvulnerableColor(Card target, Ability source, int color) {
        super(target, source);
        this.color = color;
    }

    public boolean protectsAgainst(int color) {
        for (int x = 1; x < 6; x++) {
            if ((this.color & x) == x && (color & x) == x) {
                return true;
            }
        }
        return false;
    }
}
