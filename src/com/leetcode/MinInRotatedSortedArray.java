package com.leetcode;

public class MinInRotatedSortedArray {
    public int solution(int[] array) {
        if(array.length == 1) {
            return array[0];
        }
        
        int start = 0;
        int end = array.length - 1;        
        
        while(start < end - 1) {
            
            if(array[start] < array[end]) {
                return array[start];
            } else {
                int mid = (start + end) / 2;
                if(array[start] == array[end] &&  array[start] == array[mid]) {
                  start++;
                  end--;
                } else if(array[start] > array[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        
        return Math.min(array[start], array[end]);
    }
    
    public static void main(String args[]) {
        System.out.println(new MinInRotatedSortedArray().solution(new int[]{4, 4, -2, -1, 4, 4, 4, 4}));
        System.out.println(new MinInRotatedSortedArray().solution(new int[]{3, 4, 0, 1, 2}));
        System.out.println(new MinInRotatedSortedArray().solution(new int[]{2, 3, 4, 0, 1}));
        System.out.println(new MinInRotatedSortedArray().solution(new int[]{1, 2, 3, 4, 0}));
        System.out.println(new MinInRotatedSortedArray().solution(new int[]{0, 1, 2, 3, 4}));
    }
}
