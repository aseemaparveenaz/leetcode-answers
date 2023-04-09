/*Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.
Example 1:



Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2

grid =[[0,0,1,1,0,1,0,0,1,0],[1,1,0,1,1,0,1,1,1,0],[1,0,1,1,1,0,0,1,1,0],[0,1,1,0,0,0,0,1,0,1],[0,0,0,0,0,0,1,1,1,0],[0,1,0,1,0,1,0,1,1,1],[1,0,1,0,1,1,0,0,0,1],[1,1,1,1,1,1,0,0,0,0],[1,1,1,0,0,1,0,1,0,1],[1,1,1,0,1,1,0,1,1,0]]
*/

class Solution {
    public int closedIsland(int[][] grid) {
        //heck not empty
        if(grid.length==0) return 0;
        int closedisland=0,rows=grid.length,col=grid[0].length;
        //i)check whether it is not 1st row or last row or 1st col orlast ol
        for(int i=1;i<rows-1;i++)
        {
              for(int j=1;j<col-1;j++)
              {
                  if(grid[i][j]==0)
                  {
                   if(isclosed(grid,i,j,rows,col))
                   {
                       closedisland++;
                   }
                  }
              } 
        }
        return closedisland;
    }
    //helper funtion
    public boolean isclosed(int[][] grid,int i,int j,int rows,int col)
    {
       // -1 is vistied , 1is land ,0is water so when wecheck with 0 
       //it shouldbe 1 or -1 so return true when it is
       if(grid[i][j]==1 || grid[i][j]==-1) return true;
      if(isOnperimeter(i,j,rows,col)) return false;
       grid[i][j]=-1; //mark as visited
       boolean left=isclosed(grid,i,j-1,rows,col);
       boolean right=isclosed(grid,i,j+1,rows,col);
       boolean up=isclosed(grid,i-1,j,rows,col);
       boolean bottom=isclosed(grid,i+1,j,rows,col);
       return left && right && up && bottom;
    }

    public boolean isOnperimeter(int i,int j,int rows,int col)
    {
        return i==0||j==0||i==rows-1 || j==col-1;
        //return i==rows-1 || j==col-1;
    }
}
