package assignment2;

import java.util.Random;
import java.util.Scanner;

public class SelectionSort {

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
		printArray(sortArray(RandomArray));
		keyboard.close();
	}
	public static int[] sortArray(int[] array){
		int lowestElement;
		for(int currentPos = 0; currentPos < array.length - 1; currentPos++){
			lowestElement = currentPos;
			for(int j = currentPos + 1; j < array.length; j++){
				if(array[lowestElement] > array[j]) lowestElement = j;
			}
			//Swap the elements
			swapElements(array, currentPos, lowestElement);
		}
		return array;
	}
		
	private static void swapElements(int[] array, int currentPos, int lowestElement) {
		int placeHolder = array[currentPos];
		array[currentPos] = array[lowestElement];
		array[lowestElement] = placeHolder;		
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

}
