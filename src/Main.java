/**
 * this is the main class for love letter.
 * Here the game will start and end.
 *
 * Created by padcf on 01/11/16.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //PLAYER SETUP
        //System.out.println("Player 1, please enter your name");
        Player player1 = new Player("james");
        //System.out.println("Player 2, please enter your name");
        Player player2 = new Player("patrick");
        //System.out.println("Player 3, please enter your name");
        Player player3 = new Player("paul");
        //System.out.println("Player 4, please enter your name");
        Player player4 = new Player("fiona");

        //CARD SETUP
        Deck mainDeck = new Deck(); //instantiate the deck of cards
        mainDeck.populateDeck(); // populate the deck

        //game loop
        //this sets up each round of the game -- a round ends when all players' turns are finished and a player either wins a point, or wins the game
        while (true) {

            mainDeck.shuffleDeck(); //shuffle the deck
            Card[] deck1 = mainDeck.getDeck(); //get the deck and store it in deck1 variable

            int deckLength = deck1.length - 1;

            //DEAL CARDS
            deckLength = burnCard(deckLength); //burn off a card before dealing

            //method to deal out the cards and also hold the new value of deckLength returned from method in deckLength variable
            //this method will only work for starting hands as method stores cards in Card1 slot only
            deckLength = dealCards(player1, player2, player3, player4, deckLength, deck1);

            // Random player order - create array to hold order of play
            // First round is random
            // every round thereafter - winner goes first
            // deal extra card to first player
            Player[] playerOrder = new Player[4];
            playerOrder = randomPlayer(playerOrder, player1, player2, player3, player4);

            int turnOrder = 0;
            int turnOrder2 = 1;
            int turnOrder3 = 2;
            int turnOrder4 = 3;

            //game loop 2
            //this will be every turn of a round ie. each player's go
            while (true) {

                if(playerOrder[turnOrder].getIsPlaying() == true) {
                    //reset handmaid ability from true to false
                    playerOrder[turnOrder].setPlayedHandmaid(false);

                    //deal 2nd card to current player
                    deckLength = dealCard2(playerOrder[turnOrder], deckLength, deck1);

                    System.out.println(playerOrder[turnOrder].getPlayerName() + "\nChoose a card to play" +
                            "\nType 1 for " + playerOrder[turnOrder].getCard1().getCardName() + " or 2 for " + playerOrder[turnOrder].getCard2().getCardName());

                    int choice = 0;

                    // if player has countess in hand check for prince or king also in hand
                    // if above is true only allow player to choose countess
                    while (true) {
                        // scan player choice
                        choice = sc.nextInt();
                        // check for countess in card1 slot
                        if (playerOrder[turnOrder].getCard1().getCardName().equals("countess")) {
                            if (playerOrder[turnOrder].getCard2().getCardName().equals("prince") || playerOrder[0].getCard2().getCardName().equals("king")) {
                                // if there is a prince or king in card2 slot and player has chosen card slot 2 get player to choose card until chooses card1 slot
                                if (choice == 2) {
                                    System.out.println("You must choose the Countess \nPlease enter a new choice");
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        // same as above but for opposite card slots
                        else if (playerOrder[turnOrder].getCard2().getCardName().equals("countess")) {
                            if (playerOrder[turnOrder].getCard1().getCardName().equals("prince") || playerOrder[turnOrder].getCard1().getCardName().equals("king")) {
                                if (choice == 1) {
                                    System.out.println("You must choose the Countess \nPlease enter a new choice");
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }

                    // print out player names and their cards (cards for debugging reasons as usually it's hidden information)
                    /*for (int i = 0; i < 4; i++) {
                    System.out.println(playerOrder[i].getPlayerName() + " has a " + playerOrder[i].getCard1().getCardName());
                    }*/

                    // if player doesn't have a countess with either a king or prince also in hand execute player choice
                    if (choice == 1) {
                        deckLength = playerOrder[turnOrder].getCard1().specialFunction(playerOrder[turnOrder], playerOrder[turnOrder2], playerOrder[turnOrder3], playerOrder[turnOrder4], deckLength, deck1);
                        playerOrder[turnOrder].setCard1(playerOrder[turnOrder].getCard2());
                    } else {
                        deckLength = playerOrder[turnOrder].getCard2().specialFunction(playerOrder[turnOrder], playerOrder[turnOrder2], playerOrder[turnOrder3], playerOrder[turnOrder4], deckLength, deck1);
                    }

                    //check to see if 3 players are knocked out
                    int isOutCount = 0;

                    if (!player1.getIsPlaying()) {
                        isOutCount++;
                    }
                    if (!player2.getIsPlaying()) {
                        isOutCount++;
                    }
                    if (!player3.getIsPlaying()) {
                        isOutCount++;
                    }
                    if (!player4.getIsPlaying()) {
                        isOutCount++;
                    }

                    //check to see which player is left standing -- award one point
                    if (isOutCount == 3) {
                        if (player1.getIsPlaying()) {
                            player1.setScore(player1.getPlayerScore() + 1);
                            System.out.println(player1.getPlayerName() + " has won the round!");
                            break;
                        } else if (player2.getIsPlaying()) {
                            player2.setScore(player2.getPlayerScore() + 1);
                            System.out.println(player2.getPlayerName() + " has won the round!");
                            break;
                        } else if (player3.getIsPlaying()) {
                            player3.setScore(player3.getPlayerScore() + 1);
                            System.out.println(player3.getPlayerName() + " has won the round!");
                            break;
                        } else {
                            player4.setScore(player4.getPlayerScore() + 1);
                            System.out.println(player4.getPlayerName() + " has won the round!");
                            break;
                        }
                    }

                    //check if deck is empty -- then compare isPlaying players' cards for highest value -- award point if highest value -- no point if draw -- reveal burned card
                    if (deckLength == 0) {
                        int cardVal1 = 0;
                        int cardVal2 = 0;
                        int cardVal3 = 0;
                        int cardVal4 = 0;

                        if (player1.getIsPlaying()) {
                            cardVal1 = player1.getCard1().getCardValue();
                        }
                        if (player2.getIsPlaying()) {
                            cardVal2 = player2.getCard1().getCardValue();
                        }
                        if (player3.getIsPlaying()) {
                            cardVal3 = player3.getCard1().getCardValue();
                        }
                        if (player4.getIsPlaying()) {
                            cardVal4 = player4.getCard1().getCardValue();
                        }

                        if (cardVal1 > cardVal2 && cardVal1 > cardVal3 && cardVal1 > cardVal4) {
                            player1.setScore(player1.getPlayerScore() + 1);
                            System.out.println(player1.getPlayerName() + " has won the round!");
                            break;
                        } else if (cardVal2 > cardVal1 && cardVal2 > cardVal3 && cardVal2 > cardVal4) {
                            player2.setScore(player2.getPlayerScore() + 1);
                            System.out.println(player2.getPlayerName() + " has won the round!");
                            break;
                        } else if (cardVal3 > cardVal1 && cardVal3 > cardVal2 && cardVal3 > cardVal4) {
                            player3.setScore(player3.getPlayerScore() + 1);
                            System.out.println(player3.getPlayerName() + " has won the round!");
                            break;
                        } else if (cardVal4 > cardVal1 && cardVal4 > cardVal2 && cardVal4 > cardVal3) {
                            player4.setScore(player4.getPlayerScore() + 1);
                            System.out.println(player4.getPlayerName() + " has won the round!");
                            break;
                        } else {
                            System.out.println("This round is a draw!");
                            break;
                        }
                    }

                    //next player
                    if (turnOrder == 3) {
                        turnOrder = 0;
                    } else {
                        turnOrder++;
                    }

                    //shift every other player up a number
                    if (turnOrder2 == 3) {
                        turnOrder2 = 0;
                    } else {
                        turnOrder2++;
                    }

                    if (turnOrder3 == 3) {
                        turnOrder3 = 0;
                    } else {
                        turnOrder3++;
                    }

                    if (turnOrder4 == 3) {
                        turnOrder4 = 0;
                    } else {
                        turnOrder4++;
                    }

            /*Test
           System.out.println(player1.getPlayerName() + "'s card is: " + player1.getCard1().getCardName());
           System.out.println(player2.getPlayerName() + "'s card is: " + player2.getCard1().getCardName());
           System.out.println(player3.getPlayerName() + "'s card is: " + player3.getCard1().getCardName());
           System.out.println(player4.getPlayerName() + "'s card is: " + player4.getCard1().getCardName());
           System.out.println("The remaining number of cards in the deck is: " + deckLength);*/
                }
                else{
                    //next player
                    if (turnOrder == 3) {
                        turnOrder = 0;
                    } else {
                        turnOrder++;
                    }

                    //shift every other player up a number
                    if (turnOrder2 == 3) {
                        turnOrder2 = 0;
                    } else {
                        turnOrder2++;
                    }

                    if (turnOrder3 == 3) {
                        turnOrder3 = 0;
                    } else {
                        turnOrder3++;
                    }

                    if (turnOrder4 == 3) {
                        turnOrder4 = 0;
                    } else {
                        turnOrder4++;
                    }
                }
            }
            //check to see if any player has reached the goal of getting 4 points, winning the game -- break out of game loop
            if(player1.getPlayerScore() == 4) {
                System.out.println(player1.getPlayerName() + " has won the game!");
                break;
            }
            else if(player2.getPlayerScore() == 4) {
                System.out.println(player2.getPlayerName() + " has won the game!");
                break;
            }
            else if(player3.getPlayerScore() == 4) {
                System.out.println(player3.getPlayerName() + " has won the game!");
                break;
            }
            else if(player4.getPlayerScore() == 4) {
                System.out.println(player4.getPlayerName() + " has won the game!");
                break;
            }
        }
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

    public static int dealCard2(Player player, int deckLength, Card[] deck){
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