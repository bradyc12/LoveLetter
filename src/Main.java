/**
 * this is the main class for love letter.
 * Here the game will start and end.
 *
 * Created by padcf on 01/11/16.
 */
public class Main {
    public static void main(String[] args)
    {
        Deck mainDeck = new Deck();

        mainDeck.populateDeck();

        Card[] deck1 = mainDeck.getDeck();
        mainDeck.shuffleDeck();


        System.out.println(deck1[15].getCardName());






    }
}
