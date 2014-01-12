package Card;

public class Proxy {
    public int cardID;
    public int instanceID;
    public int ownerID;

    public Proxy(int cardID, int instanceID, int ownerID) {
        this.cardID = cardID;
        this.instanceID = instanceID;
        this.ownerID = ownerID;
    }

    public Card instantiate() {
        //retrieve data
        //create appropriate card
        //return card
        return null;
    }
}
