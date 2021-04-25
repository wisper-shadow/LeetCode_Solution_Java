package com.code.leetcode;

import java.util.HashSet;

/*
 * 给你一个二进制字符串 s 和一个整数 k 。
 * 如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 True ，否则请返回 False 。
 *
 * 输入：s = "00110110", k = 2
 * 输出：true
 * 解释：长度为 2 的二进制串包括 "00"，"01"，"10" 和 "11"。它们分别是 s 中下标为 0，1，3，2 开始的长度为 2 的子串。
 *
 * 解法：使用滑动窗口，用第一个结果减去首位，乘以二之后加上下一位，维护一个最大不超过2^k的哈希表
 *
 * 注意点：运算符的优先级
 */
public class LeetCode_1461 {
    public static void main(String[] args) {
        System.out.println(hasAllCodes("00110110", 2));
    }

    public static boolean hasAllCodes(String s, int k) {
        if (s.length() < (1 << k) + k - 1) {
            return false;
        }
        char[] arr = s.toCharArray();
        Integer curVal = Integer.valueOf(s.substring(0, k), 2);
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(curVal);
        for (int i = 0; i < arr.length - k; i++) {
            curVal = ((curVal - ((arr[i] - '0') << k - 1)) << 1) + arr[i + k] - '0';
            hashSet.add(curVal);
        }
        return hashSet.size() == (1 << k);
    }
}
