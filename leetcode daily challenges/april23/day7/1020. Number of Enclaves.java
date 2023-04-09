/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 

Example 1:


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Example 2:
Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
*/
class Solution {
    public int numEnclaves(int[][] grid) {
        //anything that is connected to the boundary 1s cannot be the answer therefore connect all the 1s with the boundary 1s and the remaining 1s are tha lands are answer
    int row=grid.length,col=grid[0].length;
    for(int i=0;i<row;i++)
    {
        for(int j=0;j<col;j++)
        {
            //check for the 1s in the boundary
            if(i==0 || j==0 || i==row-1 || j==col-1)
            {
                if(grid[i][j]==1) 
                //sink the land connected to it
                dfs(i,j,grid);
            }
        }
    }
       //count the remaining 1s cellswhich is not connected to boundary
    int enclaves=0;
    for (int rowgrid[]:grid)
    {
        for(int colgrid:rowgrid)
        {
            if(colgrid==1)
               enclaves++;
        }
    }
    return enclaves;
    }
 


    public void dfs(int i, int j,int[][] grid)
    {
         if(i<0 || j<0 || i==grid.length || j==grid[0].length)// if outof bound //return
            {
                return;
            }
            //return if found sea cell
            if( grid[i][j]==0) return;
            grid[i][j]=0; //sink and make them useless
            dfs(i,j-1,grid); //left
             dfs(i,j+1,grid); //right
             dfs(i-1,j,grid); //up
             dfs(i+1,j,grid); //bottom
    }
}
