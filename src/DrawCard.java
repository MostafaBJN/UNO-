public class DrawCard extends Card {

    public DrawCard (Color color){
        super(color, Sign.draw);
        super.point = 20;
        super.design = colorToPaint(color) + BORDER + "\n" + DRAW + "\n" + BORDER + RESET;
    }

    @Override
    public void ability (){
        Run.drawNumberToAdd += 2;
        int turnOfNextPlayer = (Run.playerTurn + Run.rotateDirection)%Run.numberOfPlayers;
        if(turnOfNextPlayer < 0)
            turnOfNextPlayer = Run.numberOfPlayers - 1;
        if (!checkNextPlayerHasSign(turnOfNextPlayer, Sign.draw)) {
            drawCardsForPlayer(Run.drawNumberToAdd, Run.game.getTable().getPlayers().get(turnOfNextPlayer));
            Run.drawNumberToAdd = 0;
        } else {
            System.out.println("- Put Your 2+ Card -");;
            Run.game.getTable().getPlayers().get(turnOfNextPlayer).setHaveToPut(Sign.draw);
        }
    }
}
