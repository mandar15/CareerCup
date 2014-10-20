/**
 * Matrix operations:
 *  a. Rotate by 90deg
 */

package com.personal;

public class MatrixOperations {
    
    private static void rotate90(int matrix[][], int n) {
        
        int start = 0;
        int end = n - 1;
        
        while(n > 1) {
            
            int offset = end;
            
            for(int k = 0; k < n - 1; k++) {                            
                
                int first = matrix[start][start + k];
                
                //Fill the top row using the left row
                matrix[start][start + k] = matrix[offset][start];
                
                //Fill the left row using the bottom row
                matrix[offset][start] = matrix[end][offset];
                
                //Fill the bottom row using the right row
                matrix[end][offset] = matrix[start + k][end];
                
                //Fill the left row using the top row
                matrix[start + k][end] = first;
                
                offset--;
            }
            
            start++;
            end--;
            n -= 2;
        }
    }
    
    private static void matrixPrint(int matrix[][], int n) {
        
        for(int i = 0; i < n; i++) {            
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            
            System.out.println();
        }
        System.out.println();
    }
    
    private static int[][] initRandomSquareMatrix(int n) {
        
        int matrix[][] = new int[n][n];
        int offset = 100;
        
        for(int i = 0; i < n; i++) {            
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * offset);
            }
        }
            
        
        return matrix;
    }
    
    public static void main(String Arg[]) {
        int size = 6;
        
        int matrix[][] = initRandomSquareMatrix(size);
        matrixPrint(matrix, size);
        rotate90(matrix, size);
        matrixPrint(matrix, size);
    }
}
