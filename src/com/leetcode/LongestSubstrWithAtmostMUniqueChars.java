package com.leetcode;

import java.util.*;

public class LongestSubstrWithAtmostMUniqueChars {
       
    private static void findLongestSubstr(String str, int m) {
        Queue<Character> queue = new ArrayDeque<Character>(m);
        Map<Character, Integer> map = new HashMap<Character, Integer>(m);

        int maxSubstrLen = 0;
        int maxSubstrEnd = 0;
        int currSubstrLen = 0;
        
        for(int i = 0; i < str.length(); i++) {
            Character c = new Character(str.charAt(i));
            
            if(map.get(c) != null) {
                if(str.charAt(i) != str.charAt(i - 1)) {
                    map.put(c, new Integer(i - 1));
                    queue.remove();
                    queue.add(c);                    
                }
                
                currSubstrLen++;
            } else {
                if(queue.size() == m) {
                    Character deleteChar = queue.remove();
                    map.remove(deleteChar);                    
                    queue.add(c);
                    map.put(c, new Integer(i - 1));
                    
                    currSubstrLen = i - map.get(queue.peek());
                } else {
                    queue.add(c);
                    map.put(c, new Integer(i - 1));
                    
                    currSubstrLen++;                    
                }
            }
            
            if(maxSubstrLen < currSubstrLen) {
                maxSubstrLen = currSubstrLen;
                maxSubstrEnd = i;
            }
        }
        
        System.out.println("Max substr of string: " + str + " of atmost length: " + m + " is: " + str.substring(maxSubstrEnd - maxSubstrLen + 1, maxSubstrEnd + 1));        
    }
    
    public static void main(String args[]) {
        
        int m = 2;
        String str = "caabbaadd";
        
        findLongestSubstr(str, m);        
    }
}
