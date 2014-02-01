package Card;

import static Card.Aspect.Aspect.KEY_ASPECT_SPELL;

public class Spell extends Card {
    public Spell(int cardID, int instanceID, int ownerID, int controllerID, String name, String cost, int colors, boolean legendary) {
        super(cardID, instanceID, ownerID, controllerID, name, cost, colors, legendary);
    }

    @Override
    public int getType() {
        return KEY_ASPECT_SPELL;
    }
}
