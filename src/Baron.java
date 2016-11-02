/**
 * Created by padcf on 01/11/16.
 */
public class Baron implements Card {
    private int cardValue = 2;
    private String cardName = "Baron";
    private String cardAbility = "this is the Baron's ability";


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
