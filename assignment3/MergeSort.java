package assignment3;

import java.util.Random;
import java.util.Scanner;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] RandomArray;
		int size;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Insert a size for the randomly generated array.");
		
		size = keyboard.nextInt();
		RandomArray = generateRandomArr(new int[size]);
		
		System.out.println("Original Array: ");
		printArray(RandomArray);
		
		System.out.println("\nSorted Array: ");
		printArray(sortArray(RandomArray, 0, RandomArray.length - 1));
		
		keyboard.close();
	}
	
	public static int[] generateRandomArr(int[] array){
		Random rand = new Random();
		for(int i = 0; i < array.length; ++i) {
			array[i] = rand.nextInt(100);
		}
		return array;
	}
	
	public static void printArray(int[] array){
		System.out.print("[ ");
		for(int i = 0; i <array.length;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println(" ]");
	}


	public static int[] sortArray(int[] array,int firstIndex,int lastIndex){
		if(firstIndex<lastIndex){
			int middleIndex = (firstIndex+lastIndex)/2;
			//Divides the problem
			sortArray(array, firstIndex,middleIndex);
			sortArray(array,middleIndex+1,lastIndex);
			merge(array, firstIndex, middleIndex,lastIndex);
		}
		return array;
	}

	private static void merge(int[] array, int firstIndex, int middleIndex, int lastIndex) {
		//Computes the length of the subarray
		int leftSide = middleIndex - firstIndex + 1;
		int rightSide = lastIndex - middleIndex;
		//Subarray left and right
		int[] L = new int[leftSide+1];
		int[] R = new int[rightSide+1];
		//Copies onto the subarrays
		for(int i = 0; i < leftSide; i++){
			L[i] = array[firstIndex+i];
		}
		for(int j = 0; j < rightSide; j++){
			R[j] = array[middleIndex+j + 1];
		}
		//Sentinals onto the end of the array (Used later)
		L[leftSide] = Integer.MAX_VALUE;
		R[rightSide] = Integer.MAX_VALUE;
		//Counters
		int i = 0, j = 0;
		for(int k = firstIndex; k < lastIndex + 1; k++){
			if(L[i] <= R[j]){
				array[k] = L[i];
				i = i +1;
			}else{
				array[k] = R[j];
				j = j + 1;
			}
		}
		
	}
}
