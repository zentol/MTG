package Effect.Trigger;

import Ability.Ability;
import static Ability.Ability.KEY_ABILITY_TYPE_TRIGGERED;
import Ability.Effect.Destroy.Destruction;
import static Action.FireEvent.fireEvent;
import static Action.PutIntoPlay.putIntoPlay;
import static Card.Aspect.Aspect.KEY_ASPECT_ARTIFACT;
import static Card.Aspect.Permanent.Type.CreatureType.MYR;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import static Card.Color.Color.B;
import static Card.Color.Color.W;
import Card.Permanent;
import Condition.Card.ConditionAspect;
import Condition.Card.ConditionColor;
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
    private Ability effect;

    @Before
    public void setUp() {
        game = new Game(2);

        target = Permanent.buildPermanent()
                .setCardID(1)
                .setInstanceID(0)
                .setOwnerID(0)
                .setControllerID(0)
                .setName("Footsoldier")
                .setCost("W")
                .setColors(W)
                .setLegendary(false)
                .addCreatureAspect(1, 2, SOLDIER, MYR)
                .finish();
        target.addCreatureAspect(1, 1, SOLDIER, MYR);
        battlefield.add(target);

        effect = new Destruction(
                1,
                KEY_ABILITY_TYPE_TRIGGERED,
                null,
                new TriggerEnterTheBattlefield(
                        new ConditionColor(true, W)),
                new ConditionColor(false, B),
                new ConditionAspect(false, KEY_ASPECT_ARTIFACT)
        );
        target.abilities.add(effect);
    }

    @Test
    public void testActionFiresEvent() {
        Permanent test = Permanent.buildPermanent()
                .setCardID(2)
                .setInstanceID(1)
                .setOwnerID(0)
                .setControllerID(0)
                .setName("Footsoldier")
                .setCost("W")
                .setColors(W)
                .setLegendary(false)
                .addCreatureAspect(1, 2, SOLDIER, MYR)
                .finish();
        test.addCreatureAspect(1, 1, SOLDIER, MYR);
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
