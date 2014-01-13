package Card;

import Card.Aspect.Aspect;
import Card.Aspect.Permanent.PermanentAspect;
import Card.Aspect.Spell.SpellAspect;
import Effect.Effect;
import java.util.ArrayList;

public abstract class Card<A extends Aspect> extends Proxy {
    public static String COLOR_BLACK = "B";
    public static String COLOR_BLUE = "U";
    public static String COLOR_GREEN = "G";
    public static String COLOR_RED = "R";
    public static String COLOR_WHITE = "W";

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
        super(cardID, instanceID, ownerID);
        this.name = name;
        this.cost = cost;
        this.colors = colors;
        this.modifiers = new ArrayList();
        this.effects = new ArrayList();
        this.legendary = legendary;
        this.aspects = new ArrayList();
        this.controllerID = controllerID;
    }

//Misc--------------------------------------------------------------------------
    public boolean isController(int controllerID) {
        return this.controllerID == controllerID;
    }

//Type--------------------------------------------------------------------------
    public boolean isPermanent() {
        return aspects.getClass().isInstance(PermanentAspect.class);
    }

    public boolean isSpell() {
        return aspects.getClass().isInstance(SpellAspect.class);
    }

    public boolean hasAspect(Class a) {
        for (int x = 0; x < aspects.size(); x++) {
            if (aspects.get(x).getClass() == a) {
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

    public boolean hasType(String type) {
        for (Aspect aspect : aspects) {
            if (aspect.hasType(type)) {
                return true;
            }
        }
        return false;
    }
}
