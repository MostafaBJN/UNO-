public class WildDrawCard extends Card {

    public WildDrawCard (){
        super(Color.wild, Sign.wildDraw);
        super.point = 50;
        super.design = colorToPaint(color) + BORDER + "\n" + WILD_DRAW_CARD + "\n" + BORDER + RESET;
    }

    @Override
    public void ability () {
        setColorOfWildCard(Sign.wildDraw);
        int turnOfNextPlayer = (Run.playerTurn + Run.rotateDirection)%Run.numberOfPlayers;
        if(turnOfNextPlayer < 0)
            turnOfNextPlayer = Run.numberOfPlayers - 1;
        Run.drawNumberToAdd += 4;
        if (!checkNextPlayerHasSign(turnOfNextPlayer, Sign.wildDraw)) {
            drawCardsForPlayer(Run.drawNumberToAdd, Run.game.getTable().getPlayers().get(turnOfNextPlayer));
            Run.drawNumberToAdd = 0;
        } else {
            System.out.println("- Put Your 4+ Wild Card -");;
            Run.game.getTable().getPlayers().get(turnOfNextPlayer).setHaveToPut(Sign.wildDraw);
        }
    }
}
