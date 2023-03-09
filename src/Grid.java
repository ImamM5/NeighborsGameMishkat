import java.util.*;
public class Grid
{
    private int[][] grid;

    public Grid()
    {
        grid = new int[5][5];
    }

    public int[][] getGrid() {
        return grid;
    }

    public void updateGrid(int x, int y, int value)
    {
        x--;
        y--;

        grid[y][x]=value;
    }

    public void printTable()
    {
        int xNum =1;
        int yNUM=1;

        System.out.print("   ");
        for(int i =0; i< grid.length;i++)
        {
            System.out.print(Colors.ANSI_RED+"x"+xNum + " "+Colors.ANSI_RESET);
            xNum++;
        }
        System.out.println();

        for (int i= 0; i< grid.length; i++)
        {
            System.out.println(Colors.ANSI_RED+"y"+yNUM+ " "+Colors.ANSI_RESET+ Arrays.toString(grid[i]));
            yNUM++;
        }
    }
}
