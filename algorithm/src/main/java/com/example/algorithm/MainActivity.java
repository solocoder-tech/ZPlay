package com.example.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AlgorithmUtils";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int pwwkew = AlgorithmUtils.lengthOfLongestSubstring("pwwkew");
        Log.e(TAG, "===" + pwwkew);

    }

    private void test002() {
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode listNode1 = new ListNode(0);
//        ListNode listNode2 = new ListNode(0);
        ListNode listNode = AlgorithmUtils.addTwoNumbers(listNode1, listNode2);
        Log.e(TAG, listNode.toString());
    }

    private void test001() {
        int[] nums = {3, 3};
        int[] ints = AlgorithmUtils.twoSum(nums, 6);
        if (ints != null) {
            Log.e("AlgorithmUtils", Arrays.toString(ints));
        } else {
            Log.e("AlgorithmUtils", "没有找到");
        }
    }
}
