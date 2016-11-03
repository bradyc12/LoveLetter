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
        Player player1 = new Player("james");
        //System.out.println("Player 2, please enter your name");
        Player player2 = new Player("patrick");
        //System.out.println("Player 3, please enter your name");
        Player player3 = new Player("paul");
        //System.out.println("Player 4, please enter your name");
        Player player4 = new Player("fiona");

        //DEAL CARDS
        deckLength = burnCard(deckLength); //burn off a card before dealing

        //method to deal out the cards and also hold the new value of deckLength returned from method in deckLength variable
        //this method will only work for starting hands as method stores cards in Card1 slot only
        deckLength = dealCards(player1, player2, player3, player4, deckLength, deck1);

        // Random player order - create array to hold order of play
        // First round is random
        // every round thereafter - winner goes first
        // deal extra card to first player
        Player [] playerOrder = new Player [4];
        playerOrder = randomPlayer(playerOrder, player1, player2, player3, player4);

        deckLength = dealCard(playerOrder[0], deckLength, deck1);

        System.out.println(playerOrder[0].getPlayerName() + " is first" + "\nChoose a card to play" +
                "\n" + playerOrder[0].getCard1().getCardName() + "\n" + playerOrder[0].getCard2().getCardName() +
                "\nType 1 for " + playerOrder[0].getCard1().getCardName() + " or 2 for " + playerOrder[0].getCard2().getCardName());

        int choice = sc.nextInt();

        for(int i=0; i < 4; i++)
        {
            System.out.println(playerOrder[i].getPlayerName() + " has a " + playerOrder[i].getCard1().getCardName());
        }

        if(choice == 1){
            playerOrder[0].getCard1().specialFunction(player1, player2, player3, player4);
        }else{
            playerOrder[0].getCard2().specialFunction(player1, player2, player3, player4);
        }



        /*Test
        System.out.println(player1.getPlayerName() + "'s card is: " + player1.getCard1().getCardName());
        System.out.println(player2.getPlayerName() + "'s card is: " + player2.getCard1().getCardName());
        System.out.println(player3.getPlayerName() + "'s card is: " + player3.getCard1().getCardName());
        System.out.println(player4.getPlayerName() + "'s card is: " + player4.getCard1().getCardName());
        System.out.println("The remaining number of cards in the deck is: " + deckLength);*/


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

    public static int dealCard(Player player, int deckLength, Card[] deck){
        player.setCard2(deck[deckLength]);
        deckLength--;
        return deckLength;
    }

    public static Player [] randomPlayer(Player[] array, Player pOne, Player pTwo, Player pThree, Player pFour){
        int random =(int)(Math.random()*4);

        if(random == 1){
            array[0] = pOne;
            array[1] = pTwo;
            array[2] = pThree;
            array[3] = pFour;
        }
        else if(random == 2){
            array[0] = pTwo;
            array[1] = pThree;
            array[2] = pFour;
            array[3] = pOne;
        }
        else if(random == 3){
            array[0] = pThree;
            array[1] = pFour;
            array[2] = pOne;
            array[3] = pTwo;
        }else{
            array[0] = pFour;
            array[1] = pOne;
            array[2] = pTwo;
            array[3] = pThree;
        }

        return array;
    }
}