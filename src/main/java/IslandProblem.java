public class IslandProblem
{

  public static void main(String[] args)
  {
    int c[][] = {
        {1, 0, 0, 0, 0},
        {0, 1, 0, 0, 0},
        {1, 0, 1, 0, 0},
        {0, 1, 0, 0, 0},
        {1, 0, 0, 0, 0}
    };
    System.out.println(numIslands(c));
  }

  public static int numIslands(int[][] grid)
  {
    int cnt = 0;
    for (int i = 0; i < grid.length; i++)
    {
      for (int j = 0; j < grid[i].length; j++)
      {
        if (grid[i][j] == 1)
        {
          cnt += 1;
          callBFS(grid, i, j);
        }
      }
    }
    return cnt;
  }

  public static void callBFS(int[][] grid, int i, int j)
  {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)
      return;
    grid[i][j] = 0;
    callBFS(grid, i + 1, j + 1);
    callBFS(grid, i + 1, j - 1);
    callBFS(grid, i - 1, j + 1);
    callBFS(grid, i - 1, j - 1);
  }
}
