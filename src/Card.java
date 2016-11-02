/**
 * The card class will be created to give certain state and functionality to all cards and
 * classes which inherit from the Cards class.
 * Created by padcf on 01/11/16.
 */
public interface Card  {

    int getCardValue();
    String getCardAbility();
    String getCardName();

    void specialFunction();


}