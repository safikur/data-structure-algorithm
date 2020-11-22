package ds.problems;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
	
	public static void main(String[] args) {
		UniquePaths paths = new UniquePaths();
		System.out.println(paths.uniquePaths2(3,3));
	}

	public int uniquePaths(int m, int n) {
        Map<String,Integer> memo = new HashMap<>();
        return uniquePaths(m,n,memo);
    }
	
	public int uniquePaths2(int m, int n) {
		int[][] paths = new int[m][n];
		paths[m-1][n-1]=1;
		
		for(int i=0; i<n; i++)
			paths[m-1][i] = 1;
		for(int i=0; i<m; i++)
			paths[i][n-1] = 1;
		
        for(int j=n-2; j>=0; j--) {
        	for(int i=m-2; i>=0; i--) {
        		paths[i][j] = paths[i][j+1] + paths[i+1][j];
        	}
        }
        
        return paths[0][0];
    }
    
    private int uniquePaths(int m, int n, Map<String, Integer> memo){
        String key = m+"_"+n;
        if(memo.containsKey(key))
            return memo.get(key);
        
        if(m==1 || n==1)
            return 1;
        if(m==0 || n==0)
            return 0;
        
        int paths = uniquePaths(m,n-1, memo) + uniquePaths(m-1, n, memo);
        memo.put(key,paths);
        
        return paths;
    }
}
