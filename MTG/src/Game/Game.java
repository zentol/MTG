package Game;

import Collection.Battlefield;
import Collection.Exile;
import Collection.Graveyard;
import Collection.Hand;
import Collection.Library;
import Collection.Stack;
import Condition.Card.ConditionController;
import Effect.Effect;
import java.util.ArrayList;
import static Action.Destroy.DestroyAll.destroyAll;
import static Action.Mana.AddMana.addMana;
import static Action.Play.Play.play;
import static Card.Aspect.Permanent.Type.CreatureType.MYR;
import static Card.Aspect.Permanent.Type.CreatureType.SOLDIER;
import Card.Permanent;
import Collection.Manapool;
import Condition.Condition;
import Effect.Resolve.Resolve;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game {
    public static ArrayList<Integer> player;
    public static ArrayList<Hand> hand;
    public static ArrayList<Library> library;
    public static ArrayList<Graveyard> graveyard;
    public static ArrayList<Exile> exile;
    public static ArrayList<Manapool> manapool;
    public static ArrayList<Integer> lifepoints;
    public static Battlefield battlefield;
    public static Stack stack;
    public static ArrayList<Effect> effects;

    public static int activePlayer = 0;

    public Game(int playerCount) {
        player = new ArrayList();
        hand = new ArrayList();
        library = new ArrayList();
        graveyard = new ArrayList();
        exile = new ArrayList();
        manapool = new ArrayList();
        lifepoints = new ArrayList();
        battlefield = new Battlefield();
        stack = new Stack();

        for (int x = 0; x < playerCount; x++) {
            addPlayer();
        }
    }

//turn--------------------------------------------------------------------------
    public static void turn() {

        //supplyPhase();
        untapPhase();

        drawPhase();
        mainPhase();
        /*combatPhase();
         mainPhase();
         endPhase();
         */
        //endTurn();
    }

    public static void untapPhase() {
        for (int x = 0; x < battlefield.size(); x++) {
            if (battlefield.get(x).isController(activePlayer)) {
                battlefield.get(x).untap();
            }
        }
    }

    public static void drawPhase() {
        hand.get(activePlayer).add(library.get(activePlayer).draw(1));
        if (hand.get(activePlayer).size() > 7) {
            //hand.get(activePlayer).discard(hand.get(activePlayer).size() - 7);
        }
    }

    public static void mainPhase() {
        addMana(hand.get(activePlayer).get(0).cost);
        play(hand.get(activePlayer).get(0));
        play(hand.get(activePlayer).get(1));
        stack.resolveStack();
    }

    public static void endTurn() {
        activePlayer++;
        activePlayer %= lifepoints.size();
    }

    public static void addPlayer() {
        player.add(player.size());
        hand.add(new Hand());
        library.add(new Library());
        graveyard.add(new Graveyard());
        exile.add(new Exile());
        manapool.add(new Manapool());
        lifepoints.add(20);
    }

    public static void removePlayer(int playerID) {
        for (int x = playerID + 1; x < player.size(); x++) {
            player.set(x, player.get(x) - 1);
        }
        hand.remove(playerID);
        library.remove(playerID);
        graveyard.remove(playerID);
        exile.remove(playerID);
        lifepoints.remove(playerID);
        destroyAll(new Condition[]{new ConditionController(playerID)});
    }

    public static void dummyLoadLibrary() {
        Permanent c;
        for (int x = 0; x < 25; x++) {
            c = new Permanent(1, 1, 0, 1, "Footsoldier", "W", "W", false);
            c.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR}, null);
            library.get(0).add(c);
        }
        for (int x = 0; x < 25; x++) {
            c = new Permanent(1, 1, 0, 1, "Footsoldier", "W", "W", false);
            c.addCreatureAspect(1, 1, new String[]{SOLDIER, MYR}, null);
            library.get(1).add(c);
        }
    }

    public static void initGame() {
        for (int x = 0; x < lifepoints.size(); x++) {
            hand.get(x).add(library.get(x).draw(7));
        }
    }
}
