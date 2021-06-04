package com.code.leetcode;

import java.util.Arrays;

public class LeetCode_1744 {
    public static void main(String[] args) {
//        int[] candiesCount = new int[]{7, 4, 5, 3, 8};
//        int[][] queries = new int[][]{{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}};
        int[] candiesCount = new int[]{5, 2, 6, 4, 1};
        int[][] queries = new int[][]{{3, 1, 2}, {4, 10, 3}, {3, 10, 100}, {4, 100, 30}, {1, 3, 1}};
        System.out.println(Arrays.toString(canEat(candiesCount, queries)));
    }

    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] answer = new boolean[queries.length];
        // 求和，注意整形溢出
        long[] sumCandiesCount = new long[candiesCount.length];
        sumCandiesCount[0] = 0;
        for (int i = 1; i < candiesCount.length; i++) {
            sumCandiesCount[i] = sumCandiesCount[i - 1] + candiesCount[i - 1];
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = check(candiesCount, sumCandiesCount, queries[i]);
        }
        return answer;
    }

    private static boolean check(int[] candiesCount, long[] sumCandiesCount, int[] query) {
        int favoriteType = query[0];
        int favoriteDay = query[1];
        int dailyCap = query[2];
        if (sumCandiesCount[favoriteType] + candiesCount[favoriteType] <= favoriteDay) {
            return false;
        }
        return sumCandiesCount[favoriteType] + 1 <= (long) (favoriteDay + 1) * dailyCap;
    }
}
