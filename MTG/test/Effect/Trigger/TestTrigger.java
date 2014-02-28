package Effect.Trigger;

import static Action.FireEvent.fireEvent;
import static Action.PutIntoPlay.putIntoPlay;
import static Card.Aspect.Aspect.KEY_ASPECT_ARTIFACT;
import static Card.Aspect.Permanent.Type.CreatureType.MYR;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import static Card.Color.Color.B;
import static Card.Color.Color.W;
import Card.Permanent;
import Card.Spell;
import Condition.Card.ConditionAspect;
import Condition.Card.ConditionColor;
import Condition.Condition;
import Ability.Ability;
import Ability.Effect.Destroy.TargetedDestruction;
import Ability.TriggeredAbility;
import Event.Event;
import Event.EventEnterTheBattlefield;
import Game.Game;
import static Game.Game.battlefield;
import static Game.Game.stack;
import Trigger.TriggerEnterTheBattlefield;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestTrigger {

    @AfterClass
    public static void tearDownClass() {
    }
    private Game game;
    private Permanent target;
    private Ability effect;

    @Before
    public void setUp() {
        game = new Game(2);

        target = new Permanent(1, 1, 0, 1, "Footsoldier", "W", W, false);
        target.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR});
        battlefield.add(target);

        Spell s = new Spell(1, 1, 1, 1, "Terror", "1B", B, false);
        effect = new TargetedDestruction(1, new Condition[]{
            new ConditionColor(B, false),
            new ConditionAspect(KEY_ASPECT_ARTIFACT, false)
        });
        s.addEffect(effect);

        target.effects.add(new TriggeredAbility(1, new TriggerEnterTheBattlefield(new Condition[]{new ConditionColor(W, true)}), effect));
    }

    @Test
    public void testActionFiresEvent() {
        Permanent test = new Permanent(1, 2, 0, 1, "Footsoldier", "W", W, false);
        test.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR});
        putIntoPlay(test);
        stack.resolveStack();
        assertEquals(1, battlefield.size());
    }

    @Test
    public void testEventTriggersTrigger() {
        Event event = new EventEnterTheBattlefield(target);
        fireEvent(event);
        stack.resolveStack();
        assertEquals(0, battlefield.size());
    }
}
