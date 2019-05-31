package com.wy.leetcode.question258;

/**
 * @author wangyong
 * @date 2019/5/31
 * @description 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 */
public class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return num;
        }
        int result = num % 9;
        return result == 0? 9 : result;
    }
}
