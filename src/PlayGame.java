import java.util.*;

public class PlayGame
{
    private String name;
    private int[][] table;

    public PlayGame()
    {
        name = "Not set!";
        Grid grid = new Grid();
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
}
