/**
 * This class create the Guard card and has the guard card functionality
 * Created by padcf on 01/11/16.
 */

import java.util.Scanner;

public class Guard implements Card {

    private int cardValue = 1;
    private String cardName = "guard";
    private String cardAbility = "Name a non-Guard card and choose another player. \nIf that player has that card, he or she is out of the round.";

    Scanner sc = new Scanner(System.in);

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

        System.out.println("Current player: " + currentPlayer.getPlayerName());
        System.out.println("Target player 1: " + targetPlayer1.getPlayerName());
        System.out.println("Target player 2: " + targetPlayer2.getPlayerName());
        System.out.println("Target player 3: " + targetPlayer3.getPlayerName());

        //having chosen guard card, we now want to choose a player to apply that card on.
        //loop around until a player has been chosen. Then do what needs to be done.

        while(true)
        {
            System.out.println("Choose a player");
            String playerChoice = sc.nextLine();
            playerChoice = playerChoice.toLowerCase();
            System.out.println(playerChoice);



            //deal with exceptional input
            if(playerChoice.equals(currentPlayer.getPlayerName()))
            {
                System.out.println("DON'T BE A FOOL - CHOOSE ANOTHER PLAYER");
            }




            //check to see if targetPlayer1 is still in the round and do targetPlayer1 stuff
            else if(playerChoice.equals(targetPlayer1.getPlayerName()))
            {

                if(!targetPlayer1.getIsPlaying() || targetPlayer1.isPlayedHandmaid())
                {
                    System.out.println("This player is already out of the round");

                }
                else
                {
                    while(true)
                    {
                        System.out.println("Name a card to guess");
                        String cardChoice = sc.nextLine();
                        cardChoice = cardChoice.toLowerCase();

                        if(cardChoice.equals(this.cardName))
                        {
                            System.out.println("You cannot choose the guard card.");
                        }

                        else if(cardChoice.equals(targetPlayer1.getCard1().getCardName()))
                        {
                            System.out.println("You've guessed correctly! Player " + targetPlayer1.getPlayerName() + " is out of the round");
                            targetPlayer1.setPlaying(false);
                            System.out.println(targetPlayer1.getPlayerName() + "'s isPlaying variable is set to " + targetPlayer1.getIsPlaying());
                            break;
                        }


                        else if((cardChoice.equals("priest") || cardChoice.equals("baron") || cardChoice.equals("handmaid") || cardChoice.equals("prince") || cardChoice.equals("king") || cardChoice.equals("countess") || cardChoice.equals("princess") ))
                        {
                            System.out.println("Player " +  targetPlayer1.getPlayerName() + " does not have that card.");
                            break;
                        }

                        else
                        {
                            System.out.println("Sorry, please chose your card again");
                        }

                    }
                    break;
                }



            }

            //check to see if targetPlayer2 is still in the round and do targetPlayer2 stuff
            else if(playerChoice.equals(targetPlayer2.getPlayerName()))
            {

                if(!targetPlayer1.getIsPlaying() || targetPlayer2.isPlayedHandmaid())
                {
                    System.out.println("This player is already out of the round");

                }
                else
                {
                    while(true)
                    {
                        System.out.println("Name a card to guess");
                        String cardChoice = sc.nextLine();
                        cardChoice = cardChoice.toLowerCase();

                        if(cardChoice.equals(this.cardName))
                        {
                            System.out.println("You cannot chose the guard card.");
                        }

                        else if(cardChoice.equals(targetPlayer2.getCard1().getCardName()))
                        {
                            System.out.println("You've guessed correctly! Player " + targetPlayer2.getPlayerName() + " is out of the round");
                            targetPlayer2.setPlaying(false);
                            System.out.println(targetPlayer2.getPlayerName() + "'s isPlaying variable is set to " + targetPlayer2.getIsPlaying());
                            break;
                        }


                        else if((cardChoice.equals("priest") || cardChoice.equals("baron") || cardChoice.equals("handmaid") || cardChoice.equals("prince") || cardChoice.equals("king") || cardChoice.equals("countess") || cardChoice.equals("princess") ))
                        {
                            System.out.println("Player " +  targetPlayer2.getPlayerName() + " does not have that card.");
                            break;
                        }

                        else
                        {
                            System.out.println("Sorry, please chose your card again");
                        }

                    }
                    break;
                }



            }

            //check to see if targetPlayer3 is still in the round and do targetPlayer3 stuff
            else if(playerChoice.equals(targetPlayer3.getPlayerName()))
            {

                if(!targetPlayer1.getIsPlaying() || targetPlayer3.isPlayedHandmaid())
                {
                    System.out.println("This player is already out of the round");

                }
                else
                {
                    while(true)
                    {
                        System.out.println("Name a card to guess");
                        String cardChoice = sc.nextLine();
                        cardChoice = cardChoice.toLowerCase();

                        if(cardChoice.equals(this.cardName))
                        {
                            System.out.println("You cannot chose the guard card.");
                        }

                        else if(cardChoice.equals(targetPlayer3.getCard1().getCardName()))
                        {
                            System.out.println("You've guessed correctly! Player " + targetPlayer3.getPlayerName() + " is out of the round");
                            targetPlayer3.setPlaying(false);
                            System.out.println(targetPlayer3.getPlayerName() + "'s isPlaying variable is set to " + targetPlayer3.getIsPlaying());
                            break;
                        }


                        else if((cardChoice.equals("priest") || cardChoice.equals("baron") || cardChoice.equals("handmaid") || cardChoice.equals("prince") || cardChoice.equals("king") || cardChoice.equals("countess") || cardChoice.equals("princess") ))
                        {
                            System.out.println("Player " +  targetPlayer3.getPlayerName() + " does not have that card.");
                            break;
                        }

                        else
                        {
                            System.out.println("Sorry, please chose your card again");
                        }

                    }
                    break;
                }



            }





            else if(!playerChoice.equals(targetPlayer1.getPlayerName()) || !playerChoice.equals(targetPlayer2.getPlayerName()) || !playerChoice.equals(targetPlayer3.getPlayerName()) || !playerChoice.equals(currentPlayer.getPlayerName()))
            {
                //System.out.println("Player choice: " + playerChoice);
                //System.out.println("targetPlayer1: " + targetPlayer1.getPlayerName());
                //System.out.println("targetPlayer2: " + targetPlayer2.getPlayerName());
                //System.out.println("targetPlayer3: " + targetPlayer3.getPlayerName());
                //System.out.println("current player : " + currentPlayer.getPlayerName());
                //System.out.println(!playerChoice.equals(targetPlayer1.getPlayerName()) || !playerChoice.equals(targetPlayer2.getPlayerName()) || !playerChoice.equals(targetPlayer3.getPlayerName()) || !playerChoice.equals(currentPlayer.getPlayerName()));
                System.out.println("What?!");
            }


        }



        return length;
    }
}