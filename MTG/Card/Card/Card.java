package Card;

import Card.Aspect.Aspect;
import Card.Aspect.Permanent.PermanentAspect;
import Card.Aspect.Spell.SpellAspect;
import static Card.Color.Color.B;
import static Card.Color.Color.G;
import static Card.Color.Color.R;
import static Card.Color.Color.U;
import static Card.Color.Color.W;
import Effect.Effect;
import Modifier.Modifier;
import java.util.ArrayList;

public abstract class Card {

    public final int cardID;
    public final int instanceID;
    public final int ownerID;
    public int controllerID;

    public String name;
    public String cost;
    public int colors;
    public boolean legendary;

    public ArrayList<Modifier> modifiers;
    public ArrayList<Effect> effects;
    public ArrayList<Aspect> aspects;

    public Card(int cardID, int instanceID, int ownerID, int controllerID,
            String name, String cost, int colors, boolean legendary) {
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
    
    public void addEffect(Effect effect){
        effects.add(effect);
        effect.setSource(this);
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

    public abstract int getType();

    public boolean hasAspect(int aspect) {
        for (int x = 0; x < aspects.size(); x++) {
            if (aspects.get(x).getKey() == aspect) {
                return true;
            }
        }
        return false;
    }

    public Aspect getAspect(int aspect) {
        for (int x = 0; x < aspects.size(); x++) {
            if (aspects.get(x).getKey() == aspect) {
                return aspects.get(x);
            }
        }
        return null;
    }

    public int[] getAspects() {
        int[] keys = new int[aspects.size() + 1];
        keys[0] = getType();
        for (int x = 1; x < keys.length; x++) {
            keys[x] = aspects.get(x).getKey();
        }
        return keys;
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
    public boolean isColor(int color) {
        return (colors & color) == color;
    }

    public boolean isMulticolored() {
        return (colors & W) > 0
                || (colors & B) > 0
                || (colors & U) > 0
                || (colors & R) > 0
                || (colors & G) > 0;
    }

    public boolean isColorless() {
        return colors == 0;
    }

//Misc--------------------------------------------------------------------------
    public void resetModifiers() {
        this.modifiers.clear();
    }

}
