import java.util.ArrayList;

/**
 * Table of UNO game which manage players and cards
 */
public class Table {
    private ArrayList<Player> players;
    private ArrayList<Card> cards;
    private Card middleCard;

    /**
     * Make a new Table
     */
    public Table (){
        cards = new ArrayList<Card>();
        players = new ArrayList<Player>();
        for (int i = 0; i < Run.numberOfPlayers; i++) {
            if(Run.systemPlayer && i>0) {
                players.add(new Player(i, true));
            } else {
                players.add(new Player(i, false));
            }
        }
        for (int i = 1; i < 20; i++)
            cards.add(new NumberCard(Color.blue,(i/2)));
        for (int i = 1; i < 20; i++)
            cards.add(new NumberCard(Color.green,(i/2)));
        for (int i = 1; i < 20; i++)
            cards.add(new NumberCard(Color.red,(i/2)));
        for (int i = 1; i < 20; i++)
            cards.add(new NumberCard(Color.yellow,(i/2)));
        for (int i = 0; i < 2; i++)
            cards.add(new SkipCard(Color.blue));
        for (int i = 0; i < 2; i++)
            cards.add(new SkipCard(Color.green));
        for (int i = 0; i < 2; i++)
            cards.add(new SkipCard(Color.red));
        for (int i = 0; i < 2; i++)
            cards.add(new SkipCard(Color.yellow));
        for (int i = 0; i < 2; i++)
            cards.add(new ReverserCard(Color.blue));
        for (int i = 0; i < 2; i++)
            cards.add(new ReverserCard(Color.green));
        for (int i = 0; i < 2; i++)
            cards.add(new ReverserCard(Color.red));
        for (int i = 0; i < 2; i++)
            cards.add(new ReverserCard(Color.yellow));
        for (int i = 0; i < 2; i++)
            cards.add(new DrawCard(Color.blue));
        for (int i = 0; i < 2; i++)
            cards.add(new DrawCard(Color.green));
        for (int i = 0; i < 2; i++)
            cards.add(new DrawCard(Color.red));
        for (int i = 0; i < 2; i++)
            cards.add(new DrawCard(Color.yellow));
        for (int i = 0; i < 4; i++)
            cards.add(new WildCard());
        for (int i = 0; i < 4; i++)
            cards.add(new WildDrawCard());
    }

    /**
     * Print all cards
     */
    public void print() {
        System.out.println("Middle Card");
        System.out.println(middleCard.getDesign());
        System.out.println("-------------------");
        int i = 1;
        for (Player player:players) {
            System.out.println("Player " + i++);
            for (Card card : player.getCards()) {
                System.out.println(card.getDesign());
            }
            System.out.println();

        }
    }

    /**
     * Print a Player Cards
     *
     * @param player who cards printed
     */
    public void printPlayer(Player player){
        int i = 1;
        for (Card card : player.getCards()) {
            System.out.println(i++ + ")");
            System.out.println(card.getDesign());
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getMiddleCard() {
        return middleCard;
    }

    public void setMiddleCard(Card middleCard) {
        this.middleCard = middleCard;
    }
}
