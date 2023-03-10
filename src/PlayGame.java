import java.util.*;

public class PlayGame
{
    private String name;
    private int[][] table;
    private Grid grid;
    private int diceVal=-1;
    private int score =0;

    public PlayGame()
    {
        name = "Not set!";
        grid = new Grid();
        table = grid.getGrid();
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
        System.out.println("\n"+ Colors.ANSI_GREEN+ name+ Colors.ANSI_RESET+"'s table: ");
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
            Dice.setRollDice();
            diceVal= Dice.getRollDice();
            System.out.println("You roll your dice and get: "+ diceVal);
        }
        else
        {
            while (!ans.equals("r"))
            {
                Dice.setRollDice();
                diceVal= Dice.getRollDice();
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

        //checks if the given coordinate is empty or not
        while (table[y-1][x-1] !=0)
        {
            System.out.print("That coordinate already has a value please try another coordinate: ");
            coordinates = input.nextLine();
            comma = coordinates.indexOf(",");
            x = Integer.parseInt(coordinates.substring(1, comma));
            y = Integer.parseInt(coordinates.substring(comma+2, coordinates.length()-1));
        }
        if (table[y-1][x-1] == 0)
        {
            grid.updateGrid(x, y, diceVal);
        }
    }

    public int calcScore()
    {
        //horizontal count
        for (int row =0; row< table.length; row++)
        {
            for (int column =0; column< table[0].length-1; column++)
            {
                    if (table[row][column] == table[row][column+1])
                    {
                        score+= table[row][column] + table[row][column+1];
                        column++;
                    }
                    else if (column != 0 && table[row][column]== table[row][column-1])
                    {
                        score+= table[row][column];
                    }
            }
        }
        //vertical count
        for (int column =0; column < table[0].length; column++)
        {
            for (int row =0; row< table.length-1; row++)
            {
                if (table[row][column] == table[row+1][column])
                {
                    score+= table[row][column] + table[row+1][column];
                    row++;
                }
                else if (row!=0 && table[row][column]== table[row-1][column])
                {
                    score+= table[row][column];
                }
            }
        }

        return score;
    }
}
