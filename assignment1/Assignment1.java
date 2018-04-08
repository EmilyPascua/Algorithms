package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment1 {

	static ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter how many prime numbers you want to see:");
		int n = keyboard.nextInt();
		findPrimes(n);
		System.out.println("The first " + n + " prime number(s) are:");
		System.out.println(primeNumbers.toString());
		keyboard.close();
	}
	public static void findPrimes(int n){
		ArrayList<Integer> previousNumbers = new ArrayList<Integer>();
		for(int number = 2; n != primeNumbers.size(); number++){
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
