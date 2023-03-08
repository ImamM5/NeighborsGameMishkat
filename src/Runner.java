public class Runner
{
    public static void main(String [] args)
    {
        PlayGame newGame = new PlayGame();
        newGame.setName();
        newGame.printIntro();
        for (int i = 0; i< 25; i++)
        {
            newGame.playerPrintTable();
            newGame.printDiceRoll();
            newGame.printUpdateTable();
        }



    }
}
