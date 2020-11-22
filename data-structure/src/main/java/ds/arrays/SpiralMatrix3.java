package ds.arrays;

public class SpiralMatrix3 {

	public static void main(String[] args) {
		SpiralMatrix3 spiralMatrix3 = new SpiralMatrix3();
		
		int[][] matrix = spiralMatrix3.spiralMatrixIII(5,6,1,4);
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j]+",");
			}
			System.out.println();
		}
	}
	
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] matrix = new int[R*C][2];
        int visited = 0, len=0;
        matrix[visited++] = new int[]{r0,c0};
        String[] direction = {"east","south","west","north"};
        int current_direction = 0;
        
        while(visited<R*C){
            if(current_direction==0 || current_direction==2){
                len++;
            }
            
            for(int i=0; i<len; i++){
                if(current_direction==0) {
                    c0++;
                } else if(current_direction==1) {
                    r0++;
                } else if(current_direction==2) {
                    c0--;
                } else {
                    r0--;
                }
                if(r0<R && r0>=0 && c0<C && c0>=0 && visited<R*C)
                	matrix[visited++] = new int[]{r0,c0};
            }
            current_direction++;
            current_direction %= 4;
        }
        
        return matrix;
    }
}

