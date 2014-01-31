package Card;

import Card.Aspect.Aspect;
import static Card.Aspect.Aspect.KEY_ASPECT_ARTIFACT;
import static Card.Aspect.Aspect.KEY_ASPECT_CREATURE;
import static Card.Aspect.Aspect.KEY_ASPECT_ENCHANTMENT;
import static Card.Aspect.Aspect.KEY_ASPECT_INSTANT;
import static Card.Aspect.Aspect.KEY_ASPECT_LAND;
import static Card.Aspect.Aspect.KEY_ASPECT_PLANESWALKER;
import static Card.Aspect.Aspect.KEY_ASPECT_SORCERY;
import Card.Aspect.Permanent.ArtifactAspect;
import Card.Aspect.Permanent.CreatureAspect;
import Card.Aspect.Permanent.EnchantmentAspect;
import Card.Aspect.Permanent.LandAspect;
import Card.Aspect.Permanent.PermanentAspect;
import Card.Aspect.Permanent.PlaneswalkerAspect;
import Card.Aspect.Spell.InstantAspect;
import Card.Aspect.Spell.SorceryAspect;
import Card.Aspect.Spell.SpellAspect;
import Effect.Effect;
import Modifier.Modifier;
import java.util.ArrayList;

public abstract class Card<A extends Aspect> {

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
    public ArrayList<A> aspects;

    public Card(int cardID, int instanceID, int ownerID, int controllerID,
            String name, String cost, int colors, boolean legendary
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

    public abstract int getType();

    public boolean hasAspect(int aspectKey) {
        Class aspect;
        switch (aspectKey) {
            case KEY_ASPECT_ARTIFACT:
                aspect = ArtifactAspect.class;
                break;
            case KEY_ASPECT_CREATURE:
                aspect = CreatureAspect.class;
                break;
            case KEY_ASPECT_ENCHANTMENT:
                aspect = EnchantmentAspect.class;
                break;
            case KEY_ASPECT_LAND:
                aspect = LandAspect.class;
                break;
            case KEY_ASPECT_PLANESWALKER:
                aspect = PlaneswalkerAspect.class;
                break;
            case KEY_ASPECT_INSTANT:
                aspect = InstantAspect.class;
                break;
            case KEY_ASPECT_SORCERY:
                aspect = SorceryAspect.class;
                break;
            default:
                aspect = null;
                break;
        }
        for (int x = 0; x < aspects.size(); x++) {
            if (aspects.get(x).getClass() == aspect) {
                return true;
            }
        }
        return false;
    }

    public Aspect getAspect(int aspectKey) {
        Class aspect;
        switch (aspectKey) {
            case KEY_ASPECT_ARTIFACT:
                aspect = ArtifactAspect.class;
                break;
            case KEY_ASPECT_CREATURE:
                aspect = CreatureAspect.class;
                break;
            case KEY_ASPECT_ENCHANTMENT:
                aspect = EnchantmentAspect.class;
                break;
            case KEY_ASPECT_LAND:
                aspect = LandAspect.class;
                break;
            case KEY_ASPECT_PLANESWALKER:
                aspect = PlaneswalkerAspect.class;
                break;
            case KEY_ASPECT_INSTANT:
                aspect = InstantAspect.class;
                break;
            case KEY_ASPECT_SORCERY:
                aspect = SorceryAspect.class;
                break;
            default:
                aspect = null;
                break;
        }
        for (int x = 0; x < aspects.size(); x++) {
            if (aspects.get(x).getClass().equals(aspect)) {
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
        return colors > 5;
    }

    public boolean isColorless() {
        return colors == 0;
    }

//Misc--------------------------------------------------------------------------
    public void resetModifiers() {
        this.modifiers.clear();
    }

}
