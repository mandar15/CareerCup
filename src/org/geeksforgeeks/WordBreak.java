/*
 * Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words.
 */

package org.geeksforgeeks;

public class WordBreak {
    private static String[] dictionary = {"and", "i", "like", "sam", "sung", "samsung", "mobile", "ice", "creams", "icecream", "man", "go", "mango"};
    private static int wordMatrix[][];   
    
    private static void performWordBreak(String sent) {
        wordMatrix = new int[sent.length()][dictionary.length];
        for(int i = 0; i < sent.length(); i++) {
            String substr = sent.substring(0, i + 1);
            for(int j = 0; j < dictionary.length; j++) {
                wordMatrix[i][j] = -1;
                
                if(substr.endsWith(dictionary[j])) {                    
                    int p = substr.length() - dictionary[j].length() - 1;
                    if(p >= 0) {
                        for(int k = 0; k < dictionary.length; k++){
                            if(wordMatrix[p][k] >= 0) {
                                wordMatrix[i][j] = k;
                            }
                        }                        
                    } else {
                        wordMatrix[i][j] = j;
                    }
                }
            }
        }        
    }
    
    private static void containsDictionaryWords(String sent) {
        performWordBreak(sent);
        for(int i = sent.length() - 1, j = 0; j < dictionary.length; j++) {
            if(wordMatrix[i][j] >= 0) {
                System.out.println("\nSentence: " + sent + " is comprised of dictionary words");
                String dictSent = "";
                while(i >= 0) {
                    dictSent = dictionary[j] + " " + dictSent;
                    int  nextColumn = wordMatrix[i][j];
                    i = i - dictionary[j].length();
                    j = nextColumn;                      
                }
                System.out.println("Word Break: " + dictSent.trim());
                return;
            }
        }
        System.out.println("\nSentence: " + sent + " isn't comprised of dictionary words");
    }
    
    public static void main (String args[]) {        
        containsDictionaryWords("ilikesamsungmobileandmangoicecreams");
        containsDictionaryWords("ilikesamsungmobileandmangoicecream");
        containsDictionaryWords("mangoicecreamandsamsung");
        containsDictionaryWords("mangoicecreamandsamsungs");
    }    
}
