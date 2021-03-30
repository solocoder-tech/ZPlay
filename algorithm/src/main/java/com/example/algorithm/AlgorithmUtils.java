package com.example.algorithm;

import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class AlgorithmUtils {
    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * eg:
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] ints = null;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                int sum = nums[i] + nums[i1];
                if (sum == target) {
                    ints = new int[2];
                    ints[0] = i;
                    ints[1] = i1;
                    return ints;
                }
            }
        }
        return ints;
    }

    /**
     * 2. 两数相加
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 342 + 465 = 807
     * 2->4->3
     * 5->6->4
     * 7->0->8
     * <p>
     * 每个链表中的节点数在范围 [1, 100] 内
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();

        ListNode tempNode = listNode;
        ListNode tempL1 = l1;
        ListNode tempL2 = l2;
        int tempNextVal = 0;

        while (tempL1 != null || tempL2 != null) {
            int sum = (tempL1 == null ? 0 : tempL1.val) + (tempL2 == null ? 0 : tempL2.val);
            int tempVal = (sum + tempNextVal) % 10;
            tempNextVal = (sum + tempNextVal) / 10;

            tempNode.next = new ListNode(tempVal);

            //移动指针
            tempNode = tempNode.next;
            if (tempL1 != null) {
                tempL1 = tempL1.next;
            }
            if (tempL2 != null) {
                tempL2 = tempL2.next;
            }
        }
        //最后进位的情况
        if (tempNextVal != 0) {
            tempNode.next = new ListNode(tempNextVal);
        }

        return listNode.next;
    }

    /**
     * 3.无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * eg:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> result = new HashSet<>();
        int temp = 0;
        for (int k = 0; k < s.length(); k++) {
            for (int i = k; i < s.length(); i++) {
                char c = s.charAt(i);
                boolean add = result.add(c);
                temp = Math.max(temp, result.size());
                if (!add) {
                    result.clear();
                    break;
                }
            }
        }
        return temp;
    }

    /**
     * 4. 寻找两个正序数组的中位数
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出并返回这两个正序数组的 中位数 。
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //合并  排序  查找中间index
        int[] arr = new int[nums1.length + nums2.length];
        for (int i = 0; i < arr.length; i++) {
            if (i < nums1.length) {
                arr[i] = nums1[i];
            } else {
                arr[i] = nums2[i - nums1.length];
            }
        }
        Arrays.sort(arr);
        double result = 0;
        if (arr.length % 2 == 0) {
            result = (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
        } else {
            result = arr[arr.length / 2];
        }

        return result;
    }

    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * eg:
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * "回文串”是一个正读和反读都一样的字符串
     */
    public String longestPalindrome(String s) {
        String result = "";
        return result;
    }
}
