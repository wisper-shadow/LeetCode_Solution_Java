package com.code.jzoffer;

public class JZOffer_15 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(9));
    }

    public static int hammingWeight(int n) {
        int res = 0;
        while (true) {
            if (n == 0) {
                return res;
            }
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
    }
}
