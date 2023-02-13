package com.code.leetcode;

public class LeetCode_1234 {
    public static void main(String[] args) {
        System.out.println(balancedString("WQWRQQQW"));
    }

    public static int balancedString(String s) {
        char[] chars = s.toCharArray();
        int[] countAll = new int[4];
        for (char ch : chars) {
            switch (ch) {
                case 'Q':
                    countAll[0]++;
                    break;
                case 'W':
                    countAll[1]++;
                    break;
                case 'E':
                    countAll[2]++;
                    break;
                case 'R':
                    countAll[3]++;
                    break;
            }
        }
        if (countAll[0] == chars.length / 4 && countAll[1] == chars.length / 4 && countAll[2] == chars.length / 4) {
            return 0;
        }
        int res = chars.length;
        int balanceNum = chars.length / 4;
        for (int i = 0, j = 0; i < chars.length; i++) {
            while (j < chars.length && !checkCon(countAll, balanceNum)) {
                switch (chars[j]) {
                    case 'Q':
                        countAll[0]--;
                        break;
                    case 'W':
                        countAll[1]--;
                        break;
                    case 'E':
                        countAll[2]--;
                        break;
                    case 'R':
                        countAll[3]--;
                        break;
                }
                j++;
            }
            if (!checkCon(countAll, balanceNum)) {
                break;
            }
            res = Math.min(res, j - i);
            switch (chars[i]) {
                case 'Q':
                    countAll[0]++;
                    break;
                case 'W':
                    countAll[1]++;
                    break;
                case 'E':
                    countAll[2]++;
                    break;
                case 'R':
                    countAll[3]++;
                    break;
            }
        }
        return res;
    }

    private static boolean checkCon(int[] countAll, int balanceNum) {
        return countAll[0] <= balanceNum && countAll[1] <= balanceNum && countAll[2] <= balanceNum && countAll[3] <= balanceNum;
    }
}
