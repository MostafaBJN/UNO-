public class WildCard extends Card {

    public WildCard (){
        super.point = 50;
        super.color = Color.wild;
        super.sign = Sign.wildColor;
        super.design = colorToPaint(color) + BORDER + "\n" + WILD_CARD + "\n" + BORDER + RESET;
    }

    @Override
    public void ability (){
        setColorOfWildCard();
    }
}
