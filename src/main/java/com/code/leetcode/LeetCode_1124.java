package com.code.leetcode;

public class LeetCode_1124 {
    public static void main(String[] args) {
        System.out.println(longestWPI(new int[]{6, 6, 6}));
    }

    public static int longestWPI(int[] hours) {
        int len = 0;
        for (int i = 0; i < hours.length; i++) {
            int jia = 0;
            int jian = 0;
            for (int j = i; j < hours.length; j++) {
                if (hours[j] > 8) {
                    jia++;
                } else {
                    jian++;
                }
                if (jia > jian) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }
}
