/**
 * Created by padcf on 01/11/16.
 */
public class Princess implements Card {
    private int cardValue = 8;
    private String cardName = "princess";
    private String cardAbility = "If you discard this card, you are out of the round";


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

        System.out.println("You have discarded a Princess \nYou are out of the round!");
        currentPlayer.setPlaying(false);
    }
}
