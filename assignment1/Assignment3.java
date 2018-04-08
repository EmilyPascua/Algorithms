package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment3 {
	
	static ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a number:");
		int n = keyboard.nextInt();
		//New
		if(isPrime(generatePrevious(n), n)){
			System.out.println(1 + " * " + n);
		}else{
			findPrimes(generatePrevious(n),n);
			System.out.println("The prime factorization of " + n + " is:");
			format(primeFactorization(n, primeNumbers));
		}
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
	
	public static ArrayList<Integer> primeFactorization(int number, ArrayList<Integer> primeNumbers){
		ArrayList<Integer> primeFactorization = new ArrayList<Integer>();
		for(int i = 0; number != 1;){
			if(number % primeNumbers.get(i) == 0){
				number = number / primeNumbers.get(i);
				primeFactorization.add(primeNumbers.get(i));
			}else{
				i++;
			}
		}
		return primeFactorization;
	}
	
	public static void format(ArrayList<Integer> primeFactorization){
		int currentNumber = primeFactorization.get(0), numberAhead = 0;
		int power = 0;
		for(int i = 0; i < primeFactorization.size(); i++){
			currentNumber = primeFactorization.get(i);
			//For the out of bound
			if(i != primeFactorization.size() - 1){
				numberAhead = primeFactorization.get(i+1);
				if(currentNumber == numberAhead){
					power++;
				}else if(currentNumber != numberAhead && power != 0){
					System.out.print(currentNumber + "^" + (power + 1) + " * ");
					power = 0;
				}else{
					System.out.print(currentNumber + " * ");
				}
			}else{
				currentNumber = numberAhead;
				if(power > 0){
					System.out.println(currentNumber + "^" + (power + 1));
				}else{
					System.out.println(currentNumber);
				}
			}
		}
	}
		
}
	
