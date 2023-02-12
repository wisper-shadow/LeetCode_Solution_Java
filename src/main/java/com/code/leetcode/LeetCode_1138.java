package com.code.leetcode;

public class LeetCode_1138 {
    public static void main(String[] args) {
        System.out.println(alphabetBoardPath("code"));
    }

    public static String alphabetBoardPath(String target) {
        char[] chars = target.toLowerCase().toCharArray();
        int[][] corr = new int[chars.length][2];
        int[][] diffCorr = new int[chars.length][2];
        for (int i = 0; i < chars.length; i++) {
            corr[i][0] = (chars[i] - 97) / 5;
            corr[i][1] = (chars[i] - 97) % 5;
        }
        StringBuilder sb = new StringBuilder();
        diffCorr[0] = corr[0];
        for (int i = 1; i < chars.length; i++) {
            diffCorr[i][0] = corr[i][0] - corr[i - 1][0];
            diffCorr[i][1] = corr[i][1] - corr[i - 1][1];
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'z') {
                if (diffCorr[i][1] > 0) {
                    appendNChar(sb, diffCorr[i][1], 'R');
                } else {
                    appendNChar(sb, -diffCorr[i][1], 'L');
                }
                if (diffCorr[i][0] > 0) {
                    appendNChar(sb, diffCorr[i][0], 'D');
                } else {
                    appendNChar(sb, -diffCorr[i][0], 'U');
                }
            } else {
                if (diffCorr[i][0] > 0) {
                    appendNChar(sb, diffCorr[i][0], 'D');
                } else {
                    appendNChar(sb, -diffCorr[i][0], 'U');
                }
                if (diffCorr[i][1] > 0) {
                    appendNChar(sb, diffCorr[i][1], 'R');
                } else {
                    appendNChar(sb, -diffCorr[i][1], 'L');
                }
            }
            sb.append('!');

        }
        return sb.toString();
    }

    private static void appendNChar(StringBuilder sb, int n, char ch) {
        for (int i = 0; i < n; i++) {
            sb.append(ch);
        }
    }
}
