/**
 * Created by padcf on 01/11/16.
 */
public class Handmaid implements Card{
    private int cardValue = 2;
    private String cardName = "Handmaid";
    private String cardAbility = "this is the Handmaid's ability";


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
    public void specialFunction(Player currentPlayer, Player targetPlayer1, Player targetPlayer2, Player targetPlayer3) {

    }
}
