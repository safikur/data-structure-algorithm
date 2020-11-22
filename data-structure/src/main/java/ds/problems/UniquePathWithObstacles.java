package ds.problems;

public class UniquePathWithObstacles {

	public static void main(String[] args) {
		int grid[][] = {
				{0,0,0,0,0},
				{0,1,0,0,0},
				{0,0,0,1,0},
				{0,0,0,0,0}
				};
		UniquePathWithObstacles obstacles = new UniquePathWithObstacles();
		
		
		System.out.println(obstacles.uniquePathsWithObstacles(grid));
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int grid_row = obstacleGrid.length;
        int grid_col = obstacleGrid[0].length;
        int path[][] = new int[grid_row+1][grid_col+1];
        // path[grid_row-1][grid_col-1] = 1;
        
        for(int row=grid_row-1; row>=0; row--){
            for(int col=grid_col-1; col>=0; col--){
                if(obstacleGrid[row][col]==1){
                    path[row][col]=0;
                } else if(row==(grid_row-1) && col == (grid_col-1)){
                    path[row][col] = 1;
                } else {
                    path[row][col] = path[row][col+1] + path[row+1][col];
                }
            }
        }
        
        return path[0][0];
    }
}
