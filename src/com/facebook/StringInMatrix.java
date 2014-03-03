/*
 * Given a matrix of letters and a word, check if the word is present in the matrix. E,g., suppose matrix is: 
 * a b c d e f 
 * z n a b c f 
 * f g f a b c 
 * and given word is fnz, it is present. However, gng is not since you would be repeating g twice. 
 * You can move in all the 8 directions around an element.
 */

package com.facebook;

public class StringInMatrix {
    private static char matrix[][] = {{'a', 'b', 'c', 'd', 'e', 'f'}, {'z', 'n', 'a', 'b', 'c', 'f'}, {'f', 'g', 'f', 'a', 'b', 'c'}};
    private static String word = "fcafnaz";
    
    private static boolean findMatch(int i, int j, int k) {
        if(k == word.length()) {
            return true;
        }
        
        i--;
        j--;
        int istart = i;
        int jstart = j;
        int iend = i + 2;
        int jend = j + 2; 

        
        //Loop around the currently found match to find the next match
        do {
            //Check if i and j don't violate matrix constraints 
            if((i >= 0 && i < matrix.length && j >=0 && j < matrix[0].length)) {
                //System.out.println(i + " " + j);
                if(word.charAt(k) == matrix[i][j]) {
                    System.out.println("Found a match at position (" + i + "," + j + ") in the Matrix for character: " + matrix[i][j]);
                    matrix[i][j] = (char)(matrix[i][j] - 'a' + 'A');
                    k++;
                    if(findMatch(i, j, k)) {
                        return true;
                    } else {
                        matrix[i][j] = (char)(matrix[i][j] - 'A' +  'a');
                    }
                }
            }
            
            //Looping logic
            if(i == istart && j < jend) {
                j++;
            } else if(j == jend && i < iend) {
                i++;
            } else if(i == iend && j > jstart) {
                j--;
            } else if(j == jstart && i > istart) {
                i--;
            }
            //System.out.println(i + " " + j + " " + istart + " " + jstart + " " + word.charAt(k));

        }while((i != istart) || (j != jstart));
        
        return false;
    }
    
    private static boolean isWordInMatrix(){
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(word.charAt(0) == matrix[i][j]) {
                    System.out.println("Found a match at position (" + i + "," + j + ") in the Matrix for character: " + matrix[i][j]);
                    matrix[i][j] = (char)(matrix[i][j] - 'a' + 'A');
                    if(findMatch(i, j, 1)) {
                        return true;
                    }else {
                        System.out.println("---------------------------------------------------------------");
                        matrix[i][j] = (char)(matrix[i][j] - 'A' +  'a');
                    }
                }
            }
        }
        
        return false;
    }
    
    public static void main(String args[]) {
        System.out.println("Found match: " + isWordInMatrix());
        
    }
}
