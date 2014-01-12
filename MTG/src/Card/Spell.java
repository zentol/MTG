package Card;

import Card.Card;
import Card.Aspect.Spell.SpellAspect;

public class Spell extends Card<SpellAspect> {
    public Spell(int cardID, int instanceID, int ownerID, int controllerID, String name, String cost, String colors, boolean legendary) {
        super(cardID, instanceID, ownerID, controllerID, name, cost, colors, legendary);
    }
}
