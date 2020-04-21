import java.util.Objects;

public abstract class Card {
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";
    public static final String REVERSER = "*  ⇆  *";
    public static final String SKIP = "*  ⇴  *";
    public static final String DRAW = "* +2+ *";
    public static final String WILD_CARD = "*  ▚  *";
    public static final String WILD_DRAW_CARD = "* +4+ *";
    public static final String BORDER = "*******";

    protected int point;
    protected Color color;
    protected Sign sign;
    protected String design;

    public Card(Color color, Sign sign){
        this.color = color;
        this.sign = sign;
    }

    public abstract void ability ();

    protected String colorToPaint(Color color){
        switch (color){
            case blue: return BLUE;
            case green: return GREEN;
            case red: return RED;
            case yellow: return YELLOW;
            case wild: return PURPLE;
        }
        return RESET;
    }

    protected void setColorOfWildCard(Sign wildSign) {
        System.out.println("Select Color Of Card");
        System.out.println("1)Blue");
        System.out.println("2)Green");
        System.out.println("3)Red");
        System.out.println("4)Yellow");
        switch (Run.inputMenuGetter(1, 4)){
            case 1:
                color = Color.blue;
                break;
            case 2:
                color = Color.green;
                break;
            case 3:
                color = Color.red;
                break;
            case 4:
                color = Color.yellow;
                break;
        }
        design = colorToPaint(color) + BORDER + "\n" + signToShape(wildSign) + "\n" + BORDER + RESET;
    }

    protected String signToShape(Sign sign) {
        switch (sign){
            case wildDraw:
                return WILD_DRAW_CARD;
            case wildColor:
                return WILD_CARD;
        }
        return null;
    }

    public void drawCardsForPlayer(int numberOfCards, Player playerToGetCards) {
        System.out.println("! Player " + (playerToGetCards.getNumber() + 1) + ", You Have to Get " + numberOfCards + " Cards !");
        for (int i = 0; i < numberOfCards; i++)
            Run.game.takeCard(playerToGetCards);
    }

    protected boolean checkNextPlayerHasSign(int playerTurn, Sign sign) {
        for(Card card:Run.game.getTable().getPlayers().get(playerTurn).getCards()){
            if(card.getSign() == sign){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return color == card.color &&
                sign == card.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, sign);
    }

    public int getPoint() {
        return point;
    }

    public Color getColor() {
        return color;
    }

    public Sign getSign() {
        return sign;
    }

    public String getDesign() {
        return design;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
