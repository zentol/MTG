package Card;

import static Card.Aspect.Aspect.KEY_ASPECT_SPELL;

public class Spell extends Card {

    public Spell() {
        super(KEY_ASPECT_SPELL);
    }

    public static final class SpellBuilder extends CardBuilder<SpellBuilder, Spell> {
        public SpellBuilder() {
            this.target = new Spell();
        }

        public SpellBuilder setName(String name) {
            target.name = name;
            return this;
        }

        public SpellBuilder setCost(String cost) {
            target.cost = cost;
            return this;
        }

        public SpellBuilder setColors(int colors) {
            target.colors = colors;
            return this;
        }

        public SpellBuilder setLegendary(boolean legendary) {
            target.legendary = legendary;
            return this;
        }
    }

    public static SpellBuilder buildSpell() {
        return new SpellBuilder();
    }
}
