package Card;

import Card.Aspect.Aspect;
import Card.Aspect.Permanent.PermanentAspect;
import Card.Aspect.Spell.SpellAspect;
import static Card.Color.Color.*;
import Ability.Ability;
import Modifier.Modifier;
import java.util.ArrayList;

public abstract class Card {

    public int cardID;
    public int instanceID;
    public int ownerID;
    public int controllerID;

    public String name;
    public String cost;
    public int colors;
    public boolean legendary;
    public int cardType;

    public ArrayList<Modifier> modifiers;
    public ArrayList<Ability> effects;
    public ArrayList<Aspect> aspects;

    public Card() {
    }

    public Card(int cardID, int instanceID, int ownerID, int controllerID,
            String name, String cost, int colors, boolean legendary, int cardType) {
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

        this.cardType = cardType;
    }

    public void addEffect(Ability effect) {
        effects.add(effect);
        effect.setSource(this);
    }

//Meta--------------------------------------------------------------------------
    public boolean equalsCard(int cardID) {
        return this.cardID == cardID;
    }

    public boolean equalsInstance(int instanceID) {
        return this.instanceID == instanceID;
    }

    public boolean equalsOwner(int ownerID) {
        return this.ownerID == ownerID;
    }

    public boolean equalsController(int controllerID) {
        return this.controllerID == controllerID;
    }

//(Sub)Type---------------------------------------------------------------------
    public boolean isPermanent() {
        return aspects.getClass().isInstance(PermanentAspect.class);
    }

    public boolean isSpell() {
        return aspects.getClass().isInstance(SpellAspect.class);
    }

    public int getType() {
        return cardType;
    }

    public boolean hasAspect(int aspect) {
        for (Aspect a : aspects) {
            if (a.getAspectType() == aspect) {
                return true;
            }
        }
        return false;
    }

    public Aspect getAspect(int aspect) {
        for (Aspect a : aspects) {
            if (a.getAspectType() == aspect) {
                return a;
            }
        }
        return null;
    }

    public int[] getAspects() {
        int[] keys = new int[aspects.size() + 1];
        keys[0] = getType();
        for (int x = 1; x < keys.length; x++) {
            keys[x] = aspects.get(x).getAspectType();
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

    public static abstract class CardBuilder<T extends CardBuilder, C extends Card> {
        C target;

        public T setCardID(int id) {
            target.cardID = id;
            return (T) this;
        }

        public T setInstanceID(int id) {
            target.instanceID = id;
            return (T) this;
        }

        public T setOwnerID(int id) {
            target.ownerID = id;
            return (T) this;
        }

        public T setControllerID(int id) {
            target.controllerID = id;
            return (T) this;
        }

        public C finish() {
            return target;
        }
    }
}
