package ds.arrays;

public class SpiralMatrix2 {

	public static void main(String[] args) {
		SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
		
		int[][] matrix = spiralMatrix2.generateMatrix(3);
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				System.out.print(matrix[i][j]+",");
			}
			System.out.println();
		}
	}
	
	public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n==1){
            matrix[0][0] = 1;
            return matrix;
        }
        
        int row=0, col=0, k=1, cellWritten=0, columnsToWrite=n, rowsToWrite=n;
        while(cellWritten<n*n){
            // step1: write left to right
            for(int i=0; i<columnsToWrite && cellWritten<n*n; i++){
                matrix[row][col++]=k++;
                cellWritten++;
            }
            col--;
            rowsToWrite--;
            
            // step2: write top to bottom
            row++;
            for(int i=0; i<rowsToWrite && cellWritten<n*n; i++){
                matrix[row++][col]=k++;
                cellWritten++;
            }
            row--;
            columnsToWrite--;
            
            // step3: write right to left
            col--;
            for(int i=0; i<columnsToWrite && cellWritten<n*n; i++){
                matrix[row][col--]=k++;
                cellWritten++;
            }
            rowsToWrite--;
            col++;
            
            // step4: write bottom to top
            row--;
            // bottom to top
            for(int i=0; i<rowsToWrite && cellWritten<n*n; i++){
                matrix[row--][col]=k++;
                cellWritten++;
            }
            columnsToWrite--;
            row++;
            col++;
        }
        
        return matrix;
    }
}

