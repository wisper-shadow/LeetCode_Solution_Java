package com.code.leetcode;

public class LeetCode_4 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 1 && nums2.length == 0) {
            return nums1[0];

        }
        if (nums1.length == 0 && nums2.length == 1) {
            return nums2[0];
        }
        if (nums1.length == 1 && nums2.length == 1) {
            return ((double) (nums1[0] + nums2[0])) / 2;
        }
        int idx1 = 0;
        int idx2 = 0;
        int all = 0;
        int stop = (nums1.length + nums2.length) / 2;
        int a = 0;
        int b = 0;
        while (all <= stop) {
            if (idx1 == nums1.length) {
                idx2++;
                b = a;
                a = nums2[idx2 - 1];
            } else if (idx2 == nums2.length) {
                idx1++;
                b = a;
                a = nums1[idx1 - 1];

            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
                b = a;
                a = nums1[idx1 - 1];
            } else {
                idx2++;
                b = a;
                a = nums2[idx2 - 1];
            }
            all++;
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return a;
        } else {
            return ((double) a + b) / 2;
        }
    }
}
