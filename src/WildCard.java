public class WildCard extends Card {

    public WildCard (){
        super(Color.wild, Sign.wildColor);
        super.point = 50;
        super.design = colorToPaint(color) + BORDER + "\n" + WILD_CARD + "\n" + BORDER + RESET;
    }

    @Override
    public void ability (){
        setColorOfWildCard(Sign.wildColor);
    }
}
