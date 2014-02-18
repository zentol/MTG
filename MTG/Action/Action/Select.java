package Action;

import Card.Card;
import static Game.Game.battlefield;
import java.util.Scanner;

public class Select {
    
    //prototype method
    public static Card[] select(int count) {
        Scanner s = new Scanner(System.in);
        Card[] selection = new Card[count];
        for (int x = 0; x < count; x++) {
            System.out.println("select target");
            selection[x] = battlefield.get(s.nextInt());
        }
        return selection;
    }

}
