import java.util.*;

public class PlayGame
{
    private String name;
    private int[][] table;
    private Grid grid;
    private Dice dice;
    private int diceVal=-1;

    public PlayGame()
    {
        name = "Not set!";
        grid = new Grid();
        table = grid.getGrid();
        dice = new Dice();

    }


    public void setName()
    {
        System.out.print("What is your name?: ");
        Scanner input= new Scanner(System.in);
        name = input.nextLine();
    }

    public void printIntro()
    {
        System.out.println("\n---------------------------------------------------");
        System.out.println("Hello "+ name + " welcome to NEIGHBORS board game");
        System.out.println("Below you will see your current board.\nNext you will have to roll the dice and input the coordinates of your table.\nScores will be added at the end");
    }

    public void playerPrintTable()
    {
        System.out.println("\n"+name+"'s table: ");
        grid.printTable();
    }

    public void printDiceRoll()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("\n(R)oll the dice: ");
        String ans = input.nextLine();
        ans = ans.toLowerCase();

        if (ans.equals("r"))
        {
            diceVal= dice.getRollDice();
            System.out.println("You roll your dice and get: "+ diceVal);
        }
        else
        {
            while (!ans.equals("r"))
            {
                diceVal= dice.getRollDice();
                System.out.print("Please press (r) to roll: ");
                ans = input.nextLine();
            }
            System.out.println("You roll your dice and get: "+ diceVal);
        }
    }

    public void printUpdateTable()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Input coordinates to update table in the form of (x, y): ");
        String coordinates = input.nextLine();
        int comma = coordinates.indexOf(",");
        int x = Integer.parseInt(coordinates.substring(1, comma));
        int y = Integer.parseInt(coordinates.substring(comma+2, coordinates.length()-1));
        grid.updateGrid(x, y, diceVal);
    }
}
