package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
	
	static ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter desired n to list primes less than n:");
		int n = keyboard.nextInt();
		findPrimes(generatePrevious(n),n);
		System.out.println("The first " + n + " prime number(s) are:");
		System.out.println(primeNumbers.toString());
		keyboard.close();
	}
	
	//Generate the ArrayList
	public static ArrayList<Integer> generatePrevious(int n) {
		ArrayList<Integer> previousNumbers = new ArrayList<Integer>();
		for(int i = 2; i <= n; i++){
			previousNumbers.add(n);
		}
		return previousNumbers;
	}
	public static void findPrimes(ArrayList<Integer>previousNumbers, int n){
		for(int number = 2; n > number; number++){
			previousNumbers.add(number);			
			if(number == 2)	primeNumbers.add(number);
			else{
				if(isPrime(previousNumbers,number)){
					primeNumbers.add(number);
				}
			}
		}
	}
	public static boolean isPrime(ArrayList<Integer> previousNumbers, int currentNumber){
		for(int i = 0; i < previousNumbers.size() - 1; i++){
			if(currentNumber % previousNumbers.get(i) == 0){
				return false;
			}
		}
		return true;
	}

}
