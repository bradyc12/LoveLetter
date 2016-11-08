/**
 * Created by padcf on 01/11/16.
 */
public class Handmaid implements Card{
    private int cardValue = 4;
    private String cardName = "handmaid";
    private String cardAbility = "Until your next turn, ignore all effects from other players' cards.";


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
    public int specialFunction(Player currentPlayer, Player targetPlayer1, Player targetPlayer2, Player targetPlayer3, int length, Card[] deck) {
        //currentPlayer.setPlayedHandmaid(true); commented out because testing rest of program and can't figure out how to keep track of handmaid
        System.out.println("You are immune this round.");
        //System.out.println(currentPlayer.isPlayedHandmaid());
        return length;
    }
}
