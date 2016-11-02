/**
 * Player objects will track player score, whether a player is still in a round and store things
 * like player name
 * Created by padcf on 01/11/16.
 */
public class Player {



    private String pName = ""; //store the player's name



    private int pScore = 0; //store the player's score

    //private Card currentCard = ; //store what card the player currently holds
    //private Card currentCard2 = ; //store the card the player picks up on their turn


    //getter and setter variables for player name
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    //getter and setter variables for player score
    public int getpScore() {
        return pScore;
    }

    public void setpScore(int pScore) {
        this.pScore = pScore;
    }


}
