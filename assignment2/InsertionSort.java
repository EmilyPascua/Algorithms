package assignment2;

import java.util.Random;
import java.util.Scanner;

public class InsertionSort {

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
	
	//Algorithm from slides
	public static int[] sortArray(int[] array){
		int placeHolder, previousPos;
		for(int currentPos = 1; currentPos < array.length; currentPos++){
			placeHolder = array[currentPos];
			previousPos = currentPos - 1;
			while(previousPos >= 0 && array[previousPos] < placeHolder){
				array[previousPos + 1] = array[previousPos];
				previousPos = previousPos - 1;
			}
			array[previousPos + 1] = placeHolder;
		}
		return array;
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
