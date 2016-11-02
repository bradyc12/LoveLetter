/**
 * This class create the Guard card and has the guard card functionality
 * Created by padcf on 01/11/16.
 */
public class Guard implements Card{

    private int cardValue = 2;
    private String cardName = "Guard";
    private String cardAbility = "this is the guard's ability";


    @Override
    public int getCardValue() {
        return this.cardValue;
    }

    @Override
    public String getCardAbility() {
        return this.cardAbility;
    }

    @Override
    public String getCardName() {
        return this.cardName;
    }

    @Override
    public void specialFunction() {

    }
}
