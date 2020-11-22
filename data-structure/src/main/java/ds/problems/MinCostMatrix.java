package ds.problems;

public class MinCostMatrix {
	public static void main(String[] args) {
		int[][] grid = {
				{1,2,3},
				{4,5,6}
		};
		MinCostMatrix minCostMatrix = new MinCostMatrix();
		int minCost = minCostMatrix.minPathSum(grid);
		
		System.out.println("minCost: "+minCost);
	}
	
	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length==0){
            return 0;
        }
        
        int[][] cost = new int[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                cost[i][j] = grid[i][j];
                if(i>0 && j>0)
                    cost[i][j] += Math.min(cost[i-1][j],cost[i][j-1]);
                else if(j>0)
                    cost[i][j] += cost[i][j-1];
                else if(i>0)
                    cost[i][j] += cost[i-1][j];
                else
                    ;
            }
        }
        
        return cost[cost.length-1][cost[0].length -1];
    }
}
