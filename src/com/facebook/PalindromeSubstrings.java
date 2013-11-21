/*
 * Write a function for retrieving the total number of substring palindromes. 
 * For example the input is 'abba' then the possible palindromes= a, b, b, a, bb, abba 
 * So the result is 6. 
 */

package com.facebook;

import java.util.HashSet;
import java.util.Set;

public class PalindromeSubstrings {
    private static int findTotalPalindromeSubstrings(String s){
        /*
         * palindromicSubstringFlag[i][j] is true if there is a palindromic substring of length i ending at position j in the original string 
         */
        boolean palindromicSubstringFlag[][] = new boolean[s.length() + 1][s.length()];
        Set<String> palindromicSubstring = new HashSet<String>();

        for(int j = 0; j < s.length(); j++) {
            palindromicSubstringFlag[0][j] = true;
            palindromicSubstringFlag[1][j] = true;
            palindromicSubstring.add(s.charAt(j) + "");
        }
        
        for(int substringLength = 2; substringLength <= s.length(); substringLength++) {
            for(int substringEnd = substringLength - 1; substringEnd < s.length(); substringEnd++) {
                int substringStart =  substringEnd - substringLength + 1;
                
                if( (s.charAt(substringEnd) == s.charAt(substringStart)) && palindromicSubstringFlag[substringLength - 2][substringEnd - 1] ){
                    palindromicSubstringFlag[substringLength][substringEnd] = true;
                    palindromicSubstring.add(s.substring(substringStart, substringEnd + 1));
                }
                
            }
        }
        
        System.out.println("Palindromic substrings: " + palindromicSubstring);
        System.out.println("Total palindromic substrings: " + palindromicSubstring.size());
        
        return palindromicSubstring.size();            
    }
    
    public static void main(String args[]) {
       findTotalPalindromeSubstrings("XYCCYYYYCABAC"); 
    }
}
