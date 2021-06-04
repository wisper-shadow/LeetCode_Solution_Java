package com.code.leetcode;

import java.util.HashSet;

/*
 * 给你两个单链表的头节点headA和headB，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回null。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'。
 */
public class LeetCode_160 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 1};
        int[] arr2 = new int[]{5, 0, 1};
        int[] same = new int[]{8, 4, 5};
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(0);
        ListNode p1 = headA;
        for (int i : arr1) {
            p1.next = new ListNode(i);
            p1 = p1.next;
        }
        ListNode p2 = headB;
        for (int i : arr2) {
            p2.next = new ListNode(i);
            p2 = p2.next;
        }
        for (int i : same) {
            ListNode tmp = new ListNode(i);
            p1.next = tmp;
            p2.next = tmp;
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(getIntersectionNode(headA.next, headB.next));

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = headA;
        do {
            set.add(p);
            p = p.next;
        } while (null != p);
        p = headB;
        do {
            if (set.contains(p))
                return p;
            p = p.next;
        } while (null != p);
        return null;
    }

}
