package assignment4;

import java.util.Arrays;

public class MaximumArrayBf {
	static int maxRight;
	static int maxLeft;
	static int currMax;
	public static void main(String[] args) {
		int[] arr =  {-1,-1,-1, 1, 1, 1, 50, -1 -1 };
		findMaximumSum(arr);
		int[] subArr = new int[maxLeft - maxRight + 1];
		System.arraycopy(arr, maxRight, subArr, 0, maxLeft - maxRight + 1);
		System.out.println(Arrays.toString(subArr) + " = " + currMax);
	}

	public static void findMaximumSum(int[] arr) {
		int subSum;
		for (int i = 0; i < arr.length; i++) {
			subSum = 0;
			for (int j = i; j < arr.length; j++) {
				subSum += arr[j];
				if (subSum > currMax) {
					currMax = subSum;
					maxRight = i;
					maxLeft = j;
				}
			}
		}
	}
}
