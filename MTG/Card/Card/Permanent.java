package Card;

import static Card.Aspect.Aspect.KEY_ASPECT_PERMANENT;
import Card.Aspect.Permanent.ArtifactAspect;
import Card.Aspect.Permanent.CreatureAspect;
import Card.Aspect.Permanent.EnchantmentAspect;
import Card.Aspect.Permanent.LandAspect;
import Card.Aspect.Permanent.PlaneswalkerAspect;
import Ability.Ability;
import Modifier.Modifier;

public class Permanent extends Card {
    private boolean untapped;

    public Permanent() {
    }

    public Permanent(int cardID, int instanceID, int ownerID, int controllerID, String name, String cost, int colors, boolean legendary) {
        super(cardID, instanceID, ownerID, controllerID, name, cost, colors, legendary, KEY_ASPECT_PERMANENT);
        this.untapped = true;
    }

//Aspect------------------------------------------------------------------------
    public void addArtifactAspect(String... types) {
        aspects.add(new ArtifactAspect(types));
    }

    public void addCreatureAspect(int attack, int defense, String... types) {
        aspects.add(new CreatureAspect(attack, defense, types));
    }

    public void addEnchantmentAspect(String... types) {
        aspects.add(new EnchantmentAspect(types));
    }

    public void addLandAspect(String... types) {
        aspects.add(new LandAspect(types));
    }

    public void addPlaneswalkerAspect(int loyalty, String... types) {
        aspects.add(new PlaneswalkerAspect(types, loyalty));
    }

//Tap---------------------------------------------------------------------------
    public boolean isTapped() {
        return !untapped;
    }

    public void tap() {
        untapped = false;
    }

    public void untap() {
        untapped = true;
    }

//------------------------------------------------------------------------------
    public boolean hasEffect(Class<? extends Ability> effect) {
        for (Ability effect1 : effects) {
            if (effect1.getClass().equals(effect)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasModifier(Class<? extends Modifier> modifier) {
        for (Modifier modifier1 : modifiers) {
            if (modifier1.getClass().equals(modifier)) {
                return true;
            }
        }
        return false;
    }

    public static final class PermanentBuilder {
        Permanent target;

        public PermanentBuilder(Permanent target) {
            this.target = target;
        }

        public PermanentBuilder setCardID(int id) {
            target.cardID = id;
            return this;
        }

        public PermanentBuilder setInstanceID(int id) {
            target.instanceID = id;
            return this;
        }

        public PermanentBuilder setOwnerID(int id) {
            target.ownerID = id;
            return this;
        }

        public PermanentBuilder setControllerID(int id) {
            target.controllerID = id;
            return this;
        }

        public PermanentBuilder setName(String name) {
            target.name = name;
            return this;
        }

        public PermanentBuilder setCost(String cost) {
            target.cost = cost;
            return this;
        }

        public PermanentBuilder setColors(int colors) {
            target.colors = colors;
            return this;
        }

        public PermanentBuilder setLegendary(boolean legendary) {
            target.legendary = legendary;
            return this;
        }
    }

    public static PermanentBuilder buildPermanent(Permanent target) {
        return new PermanentBuilder(target);
    }
}
