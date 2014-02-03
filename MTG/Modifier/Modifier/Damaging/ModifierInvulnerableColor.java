package Modifier.Damaging;

import Effect.Effect;
import Modifier.Modifier;

public class ModifierInvulnerableColor extends Modifier {
    private final int color;

    public ModifierInvulnerableColor(Effect source, int color) {
        super(source);
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
