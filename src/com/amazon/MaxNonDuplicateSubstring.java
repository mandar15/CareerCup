/*
 * Given s string, Find max size of a sub-string, in which no duplicate chars present.
 */

package com.amazon;

public class MaxNonDuplicateSubstring {
    
    private static boolean CASE_SENSITIVE_CHECK = true;

    private static void findMaxNonDuplicateSubstring (String str){
        int hashTable[] = new int[255];
        int longestSubstring[] = new int[str.length()];
        int start = 0;
        int max = 0;
        int maxSubStringEnd = 0;
        
        for(int i = 0; i < 255; i++) {
            hashTable[i] = -1;
        }
        
        for(int i = 0; i < str.length(); i++) {
            int charASCII;
            if(CASE_SENSITIVE_CHECK) {
                charASCII = Character.toLowerCase(str.charAt(i));
            } else {
                charASCII = str.charAt(i);
            }
             
            if(hashTable[charASCII] >= start) {
                start = hashTable[charASCII] + 1;
            }
            
            hashTable[charASCII] = i;
            longestSubstring[i] = start;

            if(max < (i - longestSubstring[i] + 1)) {
                max = i - longestSubstring[i] + 1;
                maxSubStringEnd = i;
            }
        }
        
        System.out.println("max non duplicate substring: \"" + str.substring(longestSubstring[maxSubStringEnd], maxSubStringEnd + 1) + "\" with length: " + max);
    }
    
    public static void main(String args[]) {
        findMaxNonDuplicateSubstring("abca$ _acdF90AA");
    }
}
