public class NumberCard extends Card {

    public NumberCard (Color color, int number){
        super.point = number;
        super.color = color;
        super.sign = numberFinder(number);
        //super.design =
    }

    @Override
    public void ability (){

    }

    private Sign numberFinder (int number){
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
}
