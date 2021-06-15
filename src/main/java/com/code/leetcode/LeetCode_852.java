package com.code.leetcode;

public class LeetCode_852 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        // travel the hole array from top to the end
        /* int index = 0;
           for (int i = 1; i < arr.length; i++) {
               if (arr[i] > arr[index]) {
                   index = i;
               }
           }
           return index;
         */

        // using Binary Search
        int left = 0;
        int right = arr.length;
        int mid = (left + right) / 2;
        while (left < right) {
            if (arr[mid] > arr[mid + 1])
                right = mid;
            else
                left = mid + 1;
            mid = (left + right) / 2;
        }
        return mid;
    }
}
