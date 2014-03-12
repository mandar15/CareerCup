/*
 * You are given an integer K, and a sorted array as an input which has been rotated about an unknown pivot. For example, 4 5 6 7 8 9 1 2 3. 
 * We need to write a function which should return the index of K in the array, if K is present, else return -1.
 */

package com.facebook;

public class PivotalBinarySearch {
    private static int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    
    private static int search(int K) {
        
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end) / 2;
        
        while(start <= end) {
            System.out.println("(Start, End, Mid) :: (" + array[start] + "," + array[end] + "," + array[mid] + ")");
            if(array[mid] == K) {
                return mid;
            } else if(array[start] <= array[mid]){
                //Lower half of the array is sorted
                if(K <= array[mid] && K >= array[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //Upper half of the array is sorted
                if(K >= array[mid] && K <= array[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }                
            }
            mid = (start + end)/2;
        }
        
        return -1;
    }
    
    private static void pivotalShift(int n) {
        while(n > 0) {
            for(int i = 1 ; i < array.length; i++) {
                int temp = array[i - 1];
                array[i - 1] = array[i];
                array[i] = temp;
            }
            n--;
        }
        
        System.out.println("Given array:");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String args[]) {
        pivotalShift(3);        
        int K = 2;
        
        System.out.println("Index of K = " + K +" in the array: " + search(K));
    }
}
