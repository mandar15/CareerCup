/*
Give you an array which has n integers,it has both positive and negative integers.Now you need sort this array in a special way.After that,the negative integers should in the front,and the positive integers should in the back.Also the relative position should not be changed.
eg. -1 1 3 -2 2 ans: -1 -2 1 3 2.
o(n)time complexity and o(1) space complexity is perfect.
*/

package google.com;

public class RelativeSorting {
    
    private static void swapNumbers(int array[], int a, int b) {
        array[a] += array[b];
        array[b] = array[a] - array[b];
        array[a] = array[a] - array[b];
    }
    
    private static void swapNumberList(int array[], int left, int right) {
        while(left < right) {
            swapNumbers(array, left, right);
            left++;
            right--;
        }        
    }
    
    private static void positiveNegativeSwap(int array[]) {
        int leftMarker = -1;
        int rightMarker = -1;        
        int leftPointer = 0;
        int rightPointer = array.length - 1;
        
        while (leftPointer < rightPointer) {
            if(array[leftPointer] > 0 && array[rightPointer] < 0) {
                swapNumbers(array, leftPointer, rightPointer);
                if(leftMarker == -1 && rightMarker == -1) {
                    leftMarker = leftPointer;
                    rightMarker = rightPointer;
                }
                leftPointer++;
                rightPointer--;
            }
            else if (array[leftPointer] < 0) {
                leftPointer++;
            }
            else if(array[rightPointer] > 0){
                rightPointer--;
            }                
        }
        
        if(array[leftPointer] < 0) {
            swapNumberList(array, leftMarker, leftPointer);
            swapNumberList(array, leftPointer + 1, rightMarker);
        }
        else {
            swapNumberList(array, leftMarker, leftPointer - 1);
            swapNumberList(array, leftPointer, rightMarker);            
        }
    }
    
    public static void main(String args[]) {
        int array[]= {-1, 1, 3, -2, 2};
        
        positiveNegativeSwap(array);
        
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }
}
