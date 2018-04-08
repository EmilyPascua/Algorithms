package assignment4;

import java.util.Arrays;

public class MaximumArrayDc {
	public static void main(String[] args) {
		int[] arr = {35,50,-1,-31};
		int[] findMaxSubArray = findMaxSubArray(arr, 0, arr.length - 1);
		int[] maxSubSum = new int[findMaxSubArray[1] - findMaxSubArray[0] + 1];

		System.arraycopy(arr, findMaxSubArray[0], maxSubSum, 0, findMaxSubArray[1] - findMaxSubArray[0] + 1);
		System.out.println(Arrays.toString(maxSubSum)+ " = " +  findMaxSubArray[2]);
	}

	public static int[] findMaxSubArray(int[] arr, int low, int high) {
		if (high == low){
			int[] array = {low, high, arr[low]};
			return array;
		}
			int mid = (low + high) / 2;
			int[] leftHigh = findMaxSubArray(arr, low, mid);
			int[] rightHigh = findMaxSubArray(arr, mid +1, high);
			int[] crossMid = findMaxCrossingSubArray(arr, low, mid, high);
			
			if(leftHigh[2] >= rightHigh[2] && leftHigh[2] >= crossMid[2]){
				return leftHigh;
			}else if(rightHigh[2] >= leftHigh[2] && rightHigh[2] >= crossMid[2]){
				return rightHigh;
			}else{
				return crossMid;
			}			
	}

	public static int[] findMaxCrossingSubArray(int[] arr, int low, int mid, int high) {
		int sum = 0, maxRight = 0, maxLeft = 0;
		int leftSum = Integer.MIN_VALUE;
		for (int i = mid; i >= low; i--) {
			sum = sum + arr[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxRight = i;
			}
		}
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		for (int j = mid + 1; j <= high; j++) {
			sum = sum + arr[j];
			if (sum > rightSum) {
				rightSum = sum;
				maxLeft = j;
			}
		}
		int[] midCross = {maxRight, maxLeft, leftSum+rightSum};
		return midCross;
	}
}
