package assignment3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MergeSort2 {
	
	public static void main(String[] args) {
		int listSize;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Insert a size for the randomly generated array.");
		
		listSize = keyboard.nextInt();
		ArrayList<Integer> randomArray = generateRandomArr(listSize);
		
		System.out.println("Original Array: ");
		for (int s : randomArray)
		{
			System.out.print(s + " ");
		}		
		System.out.println("\nSorted Array: ");
		sortArray(randomArray);
		for (int s : randomArray)
		{
			System.out.print(s + " ");
		}		
		
		keyboard.close();
	}
	
	public static ArrayList<Integer> generateRandomArr(int listSize){
		ArrayList<Integer> array = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i = 0; i < listSize; ++i) {
			array.add(rand.nextInt(100));
		}
		return array;
	}
	public static void sortArray(ArrayList<Integer> list) {
		if (list.size() > 1) {
			int mid = (list.size() - 1)/2;
			
			ArrayList<Integer> left = new ArrayList<>();
			ArrayList<Integer> right = new ArrayList<>();
			
			for (int i = 0 ; i < mid ; i++) {
				left.add(list.get(i));
			}
			sortArray(left);
			for (int i = mid + 1 ; i < list.size() - 1 ; i++) {
				right.add(list.get(i));
			}
			sortArray(right);
			
			merge(left,right,list);
		}
	}
	
	private static void merge(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> result) {
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i) != list2.get(j)) {
				result.set(k, list1.get(i));
				i++;
			}
			else {
				result.set(k, list2.get(j));
				j++;
			}
			k++;
		}
		while (i < list1.size()) {
			result.set(k, list1.get(i));
			i++;
			k++;
		}
		while (j < list2.size()) {
			result.set(k,list2.get(j));
			j++;
			k++;
		}
	}
	
}
