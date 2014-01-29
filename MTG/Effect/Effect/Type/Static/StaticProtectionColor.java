package Effect.Type.Static;

import Effect.Type.StaticEffect;
import static Action.Protection.addProtectionColor;
import Card.Card;
import Card.Permanent;

public class StaticProtectionColor extends StaticEffect {
    private final int color;
    private final Permanent target;

    public StaticProtectionColor(Card source, Permanent target, int color) {
        this.color = color;
        this.source = source;
        this.target = target;
    }

    @Override
    public void execute() {
        addProtectionColor(source, target, color);
    }

    public boolean protectsAgainst(int color) {
        for (int x = 1; x < 6; x++) {
            if ((this.color & x) == x && (color & x) == x) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setTargets(Card[] targets) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
