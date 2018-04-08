package assignment3;

public class BinarySearch {

	public static void main(String[] args) {
		int[] Array = { 1, 2, 3, 4, 5, 6, 7 };
		int value = 10;
		printArray(Array);
		value = findValue(Array,value, 0, Array.length-1);
		System.out.println("");
		System.out.println("The index of your value is: " + value );
	}
	public static void printArray(int[] array){
		System.out.print("[ ");
		for(int i = 0; i <array.length;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println(" ]");
	}
	public static int findValue(int[] array, int value, int firstIndex, int lastIndex){
		int moveTowardsRight, moveTowardsLeft;
		//int middle = array.length/2;
		if(lastIndex >= 1){
	        int middle = firstIndex + (lastIndex - firstIndex)/2;
	        //Middle is the value
	        if(middle >= array.length){
	        	return -1;
	        }
	        if(array[middle] == value) {
				return middle;
			}
			//The left side possibly contains value
			if(array[middle] > value) {
				moveTowardsLeft = middle - 1; 
				System.out.println(" Move left.");
				return findValue(array, value, firstIndex, moveTowardsLeft);
			}
			//Right contains the value
			moveTowardsRight = middle + 1;
			return findValue(array, value,  moveTowardsRight, lastIndex);
			
			
		}
		//Value dne
		return -1;
	}
}
