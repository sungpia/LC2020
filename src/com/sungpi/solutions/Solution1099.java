package com.sungpi.solutions;

import java.util.Arrays;

public class Solution1099 {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int front = 0;
        int rear = A.length - 1;
        int max = -1;
        while (front < rear) {
            int s = A[front] + A[rear];
            if (s < K) {
                if (s > max) {
                    max = s;
                }
            }
            if (s < K) {
                front++;
            } else {
                rear--;
            }
        }
        System.out.print(max);
        return max;
    }
}
