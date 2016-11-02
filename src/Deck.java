import java.awt.*;

/**
 * This is the Deck class. This will create and organise the various cards
 * in an array.
 * You will be able to randomise the array, etc.
 * Created by padcf on 01/11/16.
 */



public class Deck {

    //instantiate the deck
    Card[] deck = new Card[16];

    //getter method for the deck
    public Card[] getDeck() {
        return deck;
    }


    //shuffle the deck randomly
    public void shuffleDeck()
    {
        for(int i=0; i<deck.length; i++)
        {
            int ranNum = (int) (Math.random() * deck.length);
            Card temp;
            temp = deck[i];
            deck[i] = deck[ranNum];
            deck[ranNum] = temp;
        }
    }

    //a method to populate the deck.
    public void populateDeck()
    {

        //5 guards
        for(int i=0; i<5; i++)
        {
            deck[i] = new Guard();
        }

        //2 princes
        for(int i=5; i<7; i++)
        {
            deck[i] = new Prince();
        }

        //2 Handmaids
        for(int i=7; i<9; i++)
        {
            deck[i] = new Handmaid();
        }

        //2 Barons
        for(int i=9; i<11; i++)
        {
            deck[i] = new Baron();
        }

        //Two priests
        for(int i=11; i<13; i++)
        {
            deck[i] = new Priest();
        }

        //One Prince, Countess, King
        deck[13] = new Prince();
        deck[14] = new Countess();
        deck[15] = new King();
    }

}
