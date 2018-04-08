package assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HiringProblem {

	public static void main(String[] args) {
		int n = 5;
		int[] ranks = createArray(n);
		ArrayList<Integer> emptyArrayList = new ArrayList<Integer>();
		randomizeInPlace(ranks, ranks.length);
		System.out.println("n = " + n);
		System.out.println(Arrays.toString(ranks));
		System.out.println("Method 1: " + Math.log(n));
		System.out.println("Method 2: " + computeRandAverageHires(n));
		System.out.print("Method 3: ");
		computeFactAverageHires(ranks, 0, emptyArrayList, n);
	}

	public static int hireAssistant(int[] ranks) {
		int best = Integer.MAX_VALUE, expectedHires = 0;
		for (int i = 0; i < ranks.length; i++) {
			if (best > ranks[i]) {
				best = ranks[i];
				expectedHires = expectedHires + 1;
			}
		}
		return expectedHires;
	}

	public static void randomizeInPlace(int[] ranks, int n) {
		for (int i = 0; i < ranks.length; i++) {
			Random rg = new Random();
			int randIndex = rg.nextInt(n);
			int placeHolder = ranks[randIndex];
			ranks[randIndex] = ranks[i];
			ranks[i] = placeHolder;
		}
	}

	public static int[] createArray(int n) {
		int[] enumuratedArray = new int[n];
		int value = n;
		for (int i = 0; i < n; i++) {
			enumuratedArray[i] = value;
			value--;
		}
		return enumuratedArray;
	}

	public static double computeRandAverageHires(int n) {
		ArrayList<Integer> expectedHires = new ArrayList<Integer>();
		int numberOfArrays = 10000;

		for (int i = 0; i < numberOfArrays; i++) {
			int[] ranks = createArray(n);
			randomizeInPlace(ranks, ranks.length);
			// System.out.println(Arrays.toString(ranks));
			expectedHires.add(hireAssistant(ranks));
		}
		int count = 0;
		double sum = 0;
		while (count != expectedHires.size()) {
			sum += expectedHires.get(count);
			count++;
		}
		double average = sum / expectedHires.size();
		return average;
	}

	public static void computeFactAverageHires(int[] permutations, int beginning, ArrayList<Integer> expectedHires, int n) {
		for (int i = beginning; i < permutations.length; i++) {
			int placeHolder = permutations[beginning];
			permutations[beginning] = permutations[i];
			permutations[i] = placeHolder;
			computeFactAverageHires(permutations, beginning + 1, expectedHires, n);
			permutations[i] = permutations[beginning];
			permutations[beginning] = placeHolder;
		}
		if (beginning == permutations.length - 1) {
			expectedHires.add(hireAssistant(permutations));
			if (expectedHires.size() == factorial(n)) {
				int count = 0;
				double sum = 0;
				while (count != expectedHires.size()) {
					sum += expectedHires.get(count);
					count++;
				}
				double average = sum / expectedHires.size();
				System.out.println(average);
			}
		}
	}

	public static int factorial(int n) {
		if (n == 0){
			return 1;
		}
		else{
			return (n * factorial(n - 1));
		}
	}

}
