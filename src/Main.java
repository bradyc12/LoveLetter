import java.util.Scanner;

/**
 * this is the main class for love letter.
 * Here the game will start and end.
 *
 * Created by padcf on 01/11/16.
 */
public class Main {
    public static void main(String[] args)
    {
        //CARD SETUP
        Deck mainDeck = new Deck(); //instantiate the deck of cards
        mainDeck.populateDeck(); // populate the deck
        mainDeck.shuffleDeck(); //shuffle the deck
        Card[] deck1 = mainDeck.getDeck(); //get the deck and store it in deck1 variable

        int deckLength = deck1.length;

        //PLAYER SETUP
        Scanner sc = new Scanner(System.in);

        //System.out.println("Player 1, please enter your name");
        Player player1 = new Player("James");
        //System.out.println("Player 2, please enter your name");
        Player player2 = new Player("Patrick");
        //System.out.println("Player 3, please enter your name");
        Player player3 = new Player("Paul");
        //System.out.println("Player 4, please enter your name");
        Player player4 = new Player("Fiona");

        //DEAL CARDS
        deckLength = burnCard(deckLength); //burn off a card before dealing

        //method to deal out the cards and also hold the new value of deckLength returned from method in deckLength variable
        deckLength = dealCards(player1, player2, player3, player4, deckLength, deck1);

        System.out.println(player1.getPlayerName() + "'s card is: " + player1.getCard1().getCardName());
        System.out.println(player2.getPlayerName() + "'s card is: " + player2.getCard1().getCardName());
        System.out.println(player3.getPlayerName() + "'s card is: " + player3.getCard1().getCardName());
        System.out.println(player4.getPlayerName() + "'s card is: " + player4.getCard1().getCardName());
        System.out.println("The remaining number of cards in the deck is: " + deckLength);
    }

    //burn off one card
    public static int burnCard(int deckLength)
    {
        deckLength--;
        return deckLength;
    }

    //deal out cards
    public static int dealCards(Player pOne, Player pTwo, Player pThree, Player pFour, int deckLength, Card[] deck)
    {
            pOne.setCard1(deck[deckLength]);
            deckLength--;
            pTwo.setCard1(deck[deckLength]);
            deckLength--;
            pThree.setCard1(deck[deckLength]);
            deckLength--;
            pFour.setCard1(deck[deckLength]);
            deckLength--;
            return deckLength;
    }
}
