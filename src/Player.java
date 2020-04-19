import java.util.ArrayList;

public class Player {
    private int number;
    private ArrayList<Card> cards;

    public Player(int number){
        this.number = number;
        cards = new ArrayList<Card>();
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
