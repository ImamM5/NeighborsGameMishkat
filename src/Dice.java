public class Dice
{
    private static int rollDice;


    public static void setRollDice()
    {
        rollDice = (int)(Math.random()*(10))+1;
    }

    public static int getRollDice()
    {
        return rollDice;
    }
}
