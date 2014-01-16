package Card;

import Card.Aspect.Aspect;
import Card.Aspect.Permanent.PermanentAspect;
import Card.Aspect.Spell.SpellAspect;
import Effect.Effect;
import java.util.ArrayList;

public abstract class Card<A extends Aspect> {
    public static final String COLOR_BLACK = "B";
    public static final String COLOR_BLUE = "U";
    public static final String COLOR_GREEN = "G";
    public static final String COLOR_RED = "R";
    public static final String COLOR_WHITE = "W";

    public final int cardID;
    public final int instanceID;
    public final int ownerID;

    public String name;
    public String cost;
    public String colors;
    public ArrayList<Effect> modifiers;
    public ArrayList<Effect> effects;
    public boolean legendary;
    public ArrayList<A> aspects;
    public int controllerID;

    public Card(int cardID, int instanceID, int ownerID, int controllerID,
            String name, String cost, String colors, boolean legendary
    ) {
        this.cardID = cardID;
        this.instanceID = instanceID;
        this.ownerID = ownerID;
        this.controllerID = controllerID;

        this.name = name;
        this.cost = cost;
        this.colors = colors;
        this.legendary = legendary;

        this.modifiers = new ArrayList();
        this.effects = new ArrayList();
        this.aspects = new ArrayList();
    }

//Meta--------------------------------------------------------------------------
    public boolean isCard(int cardID) {
        return this.cardID == cardID;
    }

    public boolean isInstance(int instanceID) {
        return this.instanceID == instanceID;
    }

    public boolean isOwner(int ownerID) {
        return this.ownerID == ownerID;
    }

    public boolean isController(int controllerID) {
        return this.controllerID == controllerID;
    }

//(Sub)Type---------------------------------------------------------------------
    public boolean isPermanent() {
        return aspects.getClass().isInstance(PermanentAspect.class);
    }

    public boolean isSpell() {
        return aspects.getClass().isInstance(SpellAspect.class);
    }

    public boolean hasAspect(Class<? extends Aspect> aspect) {
        for (int x = 0; x < aspects.size(); x++) {
            if (aspects.get(x).getClass() == aspect) {
                return true;
            }
        }
        return false;
    }

    public boolean hasType(String type) {
        for (Aspect aspect : aspects) {
            if (aspect.hasType(type)) {
                return true;
            }
        }
        return false;
    }

//Color-------------------------------------------------------------------------
    public boolean hasColor(String color) {
        return colors.contains(color);
    }

    public boolean isMulticolored() {
        return colors.length() > 1;
    }

    public boolean isColorless() {
        return colors.isEmpty();
    }

}
