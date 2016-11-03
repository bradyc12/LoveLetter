/**
 * This class create the Guard card and has the guard card functionality
 * Created by padcf on 01/11/16.
 */
import java.util.Scanner;

public class Guard implements Card{

    private int cardValue = 2;
    private String cardName = "Guard";
    private String cardAbility = "this is the guard's ability";
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
    public void specialFunction(Player currentPlayer, Player targetPlayer1, Player targetPlayer2, Player targetPlayer3) {

        System.out.println("Current player: " + currentPlayer.getPlayerName());
        System.out.println("Target player 1: " +targetPlayer1.getPlayerName());
        System.out.println("Target player 2: " +targetPlayer2.getPlayerName());
        System.out.println("Target player 3: " +targetPlayer3.getPlayerName());

        //having chosen guard card, we now want ot chose a player to apply that card on.
        //loop around until a player has been chosen. Then do what needs to be done.

        while(true){
            System.out.println("Choose a player");
            String playerChoice = sc.nextLine();
            playerChoice.toLowerCase();



            //deal with exceptional input
            if(playerChoice.equals(currentPlayer.getPlayerName()))
            {
                System.out.println("DON'T BE A FOOL - CHOOSE ANOTHER PLAYER");
            }
            else if(!playerChoice.equals(targetPlayer1) || !playerChoice.equals(targetPlayer2) || !playerChoice.equals(targetPlayer3))
            {
                System.out.println("What?!");
            }

            //check to see if player is still in the round
            if(playerChoice.equals(targetPlayer1.getPlayerName()))
            {
                if(playerChoice.equals((targetPlayer1.getIsPlaying() == false)))
                {
                    System.out.println("This player is out of the round");
                }
                else
                {

                    while(true)
                    {
                        System.out.println("Name a card to guess");
                        String cardChoice = sc.nextLine();

                        /*if(cardChoice.equals("Guard") || (!cardChoice.equals("Priest") || !cardChoice.equals("Baron") || !cardChoice.equals("Handmaid") || !cardChoice.equals("Prince") || !cardChoice.equals("King") || !cardChoice.equals("Countess") || !cardChoice.equals("Princess") ))
                        {
                            System.out.println("Choose another card.");
                        }
                        else
                        {*/
                            if(cardChoice.equals(playerChoice.equals(targetPlayer1.getCard1().getCardName())))
                            {
                                System.out.println("You've guessed correctly! Player " + targetPlayer1.getPlayerName() + " is out of the round");
                                targetPlayer1.setPlaying(false);
                                break;
                            }
                            else
                            {
                                System.out.println("Player " +  targetPlayer1.getPlayerName() + " does not have that card.");
                                System.out.println(targetPlayer1.getCard1().getCardName());
                                break;
                            }

                        //}


                    }
                    break;

                }
            }


        }




    }
}
