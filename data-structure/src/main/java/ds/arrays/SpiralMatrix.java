package ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		
		int [][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
				};
		int [][] matrix1 = {{2}};
//		matrix = spiralMatrix.prepareMatrix(4, 4);
		
		System.out.println(spiralMatrix.spiralOrder(matrix1));
	}
	
	public int[][] prepareMatrix(int m, int n){
		int[][] matrix = new int[m][n];
		int k=1;
		for(int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				matrix[i][j]=k++;
			}
		}
		return matrix;
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        
        List<Integer> output = new ArrayList<>();
        if(matrix.length == 0)
            return output;
        
        if(rowCount==1){
            for(int i=0; i<colCount; i++)
            	output.add(matrix[0][i]);
            return output;
        }
        
        if(colCount==1){
            for(int i=0; i<rowCount; i++)
            	output.add(matrix[i][0]);
            return output;
        }
        
        int row=0, col=0, rowsToWrite=rowCount, columnsToWrite=colCount;
        int cellWritten=0;
        while(cellWritten<rowCount * colCount){
        	// step 1
            // left to right
            for(int i=0; i<columnsToWrite && cellWritten<rowCount * colCount; i++){
                output.add(matrix[row][col++]);
                cellWritten++;
            }
            col--;
            rowsToWrite--;
            
            // step 2
            row++;
            // top to down
            for(int i=0; i<rowsToWrite && cellWritten<rowCount * colCount; i++){
                output.add(matrix[row++][col]);
                cellWritten++;
            }
            row--;
            columnsToWrite--;
            
            // step3
            col--;
            // right to left
            for(int i=0; i<columnsToWrite && cellWritten<rowCount * colCount; i++){
                output.add(matrix[row][col--]);
                cellWritten++;
            }
            rowsToWrite--;
            col++;
            
            // step4
            row--;
            // bottom to top
            for(int i=0; i<rowsToWrite && cellWritten<rowCount * colCount; i++){
                output.add(matrix[row--][col]);
                cellWritten++;
            }
            columnsToWrite--;
            row++;
            col++;
        }
        
        return output;
    }
}

