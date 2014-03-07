/*
 * Given a matrix with 1's and 0's, a rectangle can be made with 1's. What is the maximum area of the rectangle. 
 *
 * 00010 
 * 11100 
 * 11110 
 * 11000 
 * 11010 In this test case the result needs to be 8. 
 * 
 */

package com.facebook;

final class Area {
    int r;
    int c;
    
    Area(int val) {
        r = c = val; 
    }       
}

public class MaxAreaRectangle {
    private static int matrix [][] = {
        {0,1,1,1,1,1},
        {0,1,1,1,1,1},
        {0,1,1,1,1,1},
        {0,1,1,0,1,0},
        {0,1,1,1,1,1},
        {1,1,1,1,1,1}
    }; 
    
    private static void initRow(Area area[][], int k, int rowPtr){
        int i = (k + 1) % 2;
        area[k][0] = new Area(matrix[rowPtr][0]);
        if(matrix[rowPtr][0] == 1) {
            area[k][0].r = 1;
            area[k][0].c = area[i][0].c + 1;            
        }else{
            area[k][0].r = 0;
            area[k][0].c = 0;            
        }
        
        for(int j = 1; j < area[0].length; j++) {
            if(matrix[rowPtr][j] == 1) {
                area[k][j].r = area[k][j - 1].r + 1;
                area[k][j].c = area[i][j].c + 1;
            } else {
                area[k][j].r = 0;
                area[k][j].c = 0;
            }
        }
    }

    
    private static int maxArea() {
        Area area[][] = new Area[2][matrix[0].length];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                area[i][j] = new Area(matrix[i][j]);
            }
        }
        
        int k = 1;
        int maxArea = 0;        
        for(int i = 1; i < matrix.length; i++) {
            initRow(area, k, i);
            for(int j = 1; j < matrix[i].length; j++) {
                if((matrix[i][j] & matrix[i - 1][j] & matrix[i][j - 1] & matrix[i - 1][j - 1]) == 1){

                    int columns = area[k][j].c;                    
                    for(int rows = 2, l = j - 1; rows <= area[k][j].r; rows++, l--) {                        
                        columns = Math.min(columns, area[k][l].c);
                        
                        if(maxArea < rows * columns) {
                            maxArea = rows * columns;
                        }
                    }
                }
            }
            k = (k + 1) % 2;
        }
        
        return maxArea;
    }
        
    public static void main(String args[]) {
        System.out.println("Max area: " + maxArea());
    }
}
