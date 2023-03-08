public class Dice
{
    private int rollDice;

    public Dice ()
    {
        rollDice = (int)(Math.random()*(10))+1;
    }

    public int getRollDice()
    {
        return rollDice;
    }
}
