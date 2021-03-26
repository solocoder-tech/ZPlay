package com.example.algorithm;

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
     *
     * 每个链表中的节点数在范围 [1, 100] 内
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        for (int i = 0;i<100;i++){

        }









        ListNode listNode = new ListNode();
        int sum = l1.val + l2.val;
        listNode.val = sum % 10;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int sum1 = -1;

        //第二个开始算起
        for (; ; ) {
            temp1 = temp1 == null ? null : temp1.next;
            temp2 = temp2 == null ? null : temp2.next;

            if (temp1 == null && temp2 == null) {
                //看有没有进位的情况
                if (sum1 != -1) {
                    ListNode listNode1 = new ListNode();
                    listNode1.val = sum1 / 10;
                    listNode.next = listNode1;
                }
                break;
            }

            if (temp1 != null && temp2 == null) {
                listNode.next = temp1;
            } else if (temp1 == null && temp2 != null) {
                listNode.next = temp2;
            } else {
                //创建节点
                ListNode listNode1 = new ListNode();
                sum1 = temp1.val + temp2.val;
                listNode1.val = sum1 % 10;

                listNode.next = listNode1;//?
            }

            listNode.next = listNode.next.next;
        }
        return listNode;
    }

}
