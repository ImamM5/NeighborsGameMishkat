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
        System.out.println("\nYour score was: "+ Colors.ANSI_CYAN+ newGame.calcScore()+ Colors.ANSI_RESET+ "!");



    }
}
