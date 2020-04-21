public class WildDrawCard extends Card {

    public WildDrawCard (){
        super.point = 50;
        super.color = Color.wild;
        super.sign = Sign.wildDraw;
        super.design = colorToPaint(color) + BORDER + "\n" + WILD_DRAW_CARD + "\n" + BORDER + RESET;
    }

    @Override
    public void ability () {
        setColorOfWildCard();
        if (!checkNextPlayerHasSign(Run.player_turn, Sign.wildDraw)) {
            drawCardsForNextPLayer(4);
        } else {
            System.out.println("- Put Your 4+ Wild Card -");;
            Run.game.getTable().getPlayers().get(Run.player_turn + 1).setHaveToPut(Sign.wildDraw);
        }
    }
}
