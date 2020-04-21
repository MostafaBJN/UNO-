
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

    public abstract void ability ();

    protected Sign numberFinder(int number) {
        switch (number){
            case 0:
                return Sign.zero;
            case 1:
                return Sign.one;
            case 2:
                return Sign.two;
            case 3:
                return Sign.three;
            case 4:
                return Sign.four;
            case 5:
                return Sign.five;
            case 6:
                return Sign.six;
            case 7:
                return Sign.seven;
            case 8:
                return Sign.eight;
            case 9:
                return Sign.nine;
        }
        return null;
    }

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

    protected void setColorOfWildCard() {
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
    }

    protected void drawCardsForNextPLayer(int numberOfCards) {
        int nextPlayer = (Run.player_turn + Run.rotateDirection) % Run.numberOfPlayers;
        System.out.println("! Player " + (nextPlayer + 1) + ", You Have to Get " + numberOfCards + " Cards !");
        for (int i = 0; i < numberOfCards; i++) {
            Run.game.takeCard(Run.game.getTable().getPlayers().get(nextPlayer));
        }
    }

    protected boolean checkNextPlayerHasSign(int playerTurn, Sign sign) {
        for(Card card:Run.game.getTable().getPlayers().get(playerTurn).getCards()){
            if(card.getSign() == sign){
                return true;
            }
        }
        return false;
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
