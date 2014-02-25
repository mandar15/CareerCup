/*
 * Write a function to match Text With a Pattern. The Pattern can contain '.' and '*'. '.' means a any character and '*' means 0 or more occurrence of the Previous character.
 */

package com.facebook;

public class StringMatching {
       
    private static boolean isMatching(String text, String pattern) {
        char lastPatternChar = '\0';
        int i = 0;
        int j = 0;
        boolean mismatch = false;
        for(;i < text.length() && j < pattern.length(); i++) {

            char textChar = text.charAt(i);    
            char patternChar = pattern.charAt(j);    
            
            switch(patternChar) {
            case '\0':
                System.out.println("Incorrect Pattern");
                return false;
            case '*':
                if(textChar == lastPatternChar) {
                    /*
                     * matches "aaa" with "a*"
                     */
                    break; 
                } else if(mismatch) {
                    /*
                     * matches "ak" with "ao*k"
                     */
                    System.out.println("Next Pattern char = *. Skipping the previous mismatch pattern character " + lastPatternChar);
                    mismatch = false;                    
                } else if(textChar != lastPatternChar) {
                    /*
                     * matches "abc" with "ab*c"
                     */
                    System.out.println("Mismatch (textChar, patternChar) : (" + textChar + "," + patternChar + "). Checking for the nextPatternChar");
                }
                i--;
                j++;
                continue;
            case '.':
                patternChar = textChar;
            default:
                if(mismatch) {
                    /*
                     * found a mismatch previously and next character in pattern is not a *
                     * eg "abcf" and "abdf"
                     */
                    System.out.println("Mismatch (textChar, patternChar) : (" + textChar + "," + lastPatternChar + ") and nextPatternChar is not *");
                    return false;
                }
                if(patternChar != textChar) {
                    i--;
                    if(patternChar == lastPatternChar) {
                        /*
                         * matches "abbc" with "ab**bc"
                         */
                        System.out.println("Skipping the patternChar: " + patternChar);
                        j++;
                        continue;
                    }
                    /*
                     * Mismatch found. Checks if the nextChar in Pattern is *. If the nextChar is not a * then there is a certain mismatch. 
                     */
                    System.out.println("Mismatch (textChar, patternChar) : (" + textChar + "," + patternChar + "), Checking if the nextPatternChar = *");                    
                    mismatch = true;
                }
                lastPatternChar = patternChar;
                j++;
            }
        }
        
        if(i == text.length() && (j == pattern.length() || (j == pattern.length() - 1 && pattern.charAt(j) == '*'))) {
            return true;
        } else {
            return false;
        }        
    }
    
    private static void printResult(String text, String pattern) {
        System.out.println("Case (" + text + "," + pattern + "): ");
        System.out.println(isMatching(text, pattern) + "\n");
    }
    
    public static void main(String args[]) {
        String text = "Facebook";
        printResult(text, "");
        printResult(text, "\0acebook");
        printResult(text, "Facebook");
        printResult(text, "Fac..ook");
        printResult(text, "Fac..*ok");
        printResult(text, "Fac..o*k");
        printResult("Facebk", "Fac..o*k");
        printResult("Facebk", "Fac..ok");
        printResult(text, "Face*book");
        printResult(text, "Face*book*");
        printResult(text, "Face**b*ook");
        printResult(text, "Facebo*ok");
        printResult(text, "Faceb.*o***o*k");
    }
}
