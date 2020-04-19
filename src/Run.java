/**
 *
 * @author Mostafa_BJN
 * @version 0.0
 */
public class Run {
    public static int player_turn;
    //anticlockwise = -1 , clockwise = 1
    public static int rotateDirection;

    public static void main(String[] args) {
        Table t = new Table();
        for (Card card : t.getCards())
            System.out.println("" + card.sign + " " + card.color);
    }
}
