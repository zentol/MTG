package Effect.Type.Static;

import static Action.Static.Protection.addProtectionColor;
import Card.Card;
import Card.Permanent;

public class StaticProtectionColor extends Static {
    private final String color;
    private final Card source;
    private final Permanent target;

    public StaticProtectionColor(Card source, Permanent target, String color) {
        this.color = color;
        this.source = source;
        this.target = target;
    }

    public void execute() {
        addProtectionColor(source, target, color);
    }

    public boolean protectsAgainst(String color) {
        for (int x = 0; x < color.length(); x++) {
            if (this.color.contains(Character.toString(color.charAt(x)))) {
                return true;
            }
        }
        return false;
    }
}
