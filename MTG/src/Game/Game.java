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
import static Action.Destroy.Destroy.destroyAll;
import Condition.Condition;

public class Game {
    public static ArrayList<Integer> player;
    public static ArrayList<Hand> hand;
    public static ArrayList<Library> library;
    public static ArrayList<Graveyard> graveyard;
    public static ArrayList<Exile> exile;
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
        lifepoints = new ArrayList();
        battlefield = new Battlefield();
        stack = new Stack();
        hand = new ArrayList();

        for (int x = 0; x < playerCount; x++) {
            addPlayer();
        }
    }

    public static void turn() {
        /*
         supplyPhase();
         untapPhase();
         drawPhase();
         mainPhase();
         combatPhase();
         mainPhase();
         endPhase();
         */
        endTurn();
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
}
