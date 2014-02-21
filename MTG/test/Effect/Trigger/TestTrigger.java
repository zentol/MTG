package Effect.Trigger;

import static Action.FireEvent.fireEvent;
import static Card.Aspect.Permanent.Type.CreatureType.MYR;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import static Card.Color.Color.B;
import static Card.Color.Color.W;
import Card.Permanent;
import Card.Spell;
import Condition.Card.ConditionColorPositive;
import Condition.Condition;
import Effect.Effect;
import Effect.Spell.Terror;
import Effect.TriggeredEffect;
import Event.Event;
import Event.EventEnterTheBattlefield;
import Game.Game;
import static Game.Game.battlefield;
import static Game.Game.stack;
import Trigger.TriggerEnterTheBattlefield;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestTrigger {

    @AfterClass
    public static void tearDownClass() {
    }
    private Game game;
    private Permanent target;
    private Effect effect;

    @Before
    public void setUp() {
        game = new Game(2);

        target = new Permanent(1, 1, 0, 1, "Footsoldier", "W", W, false);
        target.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR});
        battlefield.add(target);

        Spell s = new Spell(1, 1, 1, 1, "Terror", "1B", B, false);
        effect = new Terror(s);

        target.effects.add(new TriggeredEffect(1, new TriggerEnterTheBattlefield(new Condition[]{new ConditionColorPositive(W)}), effect));
    }

    @Test
    public void testTrigger() {
        Event event = new EventEnterTheBattlefield(target);
        fireEvent(event);
        stack.resolveStack();
        assertEquals(0, battlefield.size());
    }
}
