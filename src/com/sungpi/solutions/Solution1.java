package com.sungpi.solutions;

import java.util.HashMap;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] ret = new int[2];
        for (int i=0; i<nums.length; ++i) {
            hashMap.put(target - nums[i], i);
        }

        for (int i=0; i<nums.length; ++i) {
            if ((hashMap.containsKey(nums[i])) && (hashMap.get(nums[i]) != i)) {
                ret[0] = i;
                ret[1] = hashMap.get(nums[i]);
                return ret;
            }
        }
        return ret;
    }
}
