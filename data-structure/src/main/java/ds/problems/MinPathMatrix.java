package ds.problems;

public class MinPathMatrix {

	public static void main(String[] args) {
		int[][] grid = {
				{1,2,3},
				{4,5,6}
		};
		MinPathMatrix minPathMatrix = new MinPathMatrix();
		int [][] path = minPathMatrix.minPath(grid);
		
		for(int i=0; i<path.length; i++) {
			System.out.println();
			System.out.print("("+path[i][0]+","+path[i][1]+")");
		}
	}
	
	public int[][] minPath(int[][] grid) {
		int[][] path = new int[grid.length + grid[0].length - 1][2];
		int cost[][] = calculateCost(grid);
		
		int n =cost.length-1;
		int i=n,j=n,k=0;
		while(i!=0 && j!=0) {
			if(i==0) {
				j--;
			} else if(j==0){
				i--;
			} else if(cost[i-1][j]<cost[i][j-1]) {
				i--;
			} else {
				j--;
			}
			path[k] = new int[] {i,j};
		}
		path[0]=new int[] {0,0};
		path[n]=new int[] {n,n};
		
		return path;
	}
	
	public int[][] calculateCost(int[][] grid) {
        if(grid == null || grid.length==0){
            return grid;
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
        
        return cost;
    }
}
