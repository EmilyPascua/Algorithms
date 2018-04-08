package assignment3;

public class DivideAndConquerPower {

	public static void main(String[] args) {
		System.out.println(1.5+5);
	}
	public static int findToNPower(int number, int power){
		if(power == 1){
			return number;
		}else if(power % 2 == 0){
			return findToNPower(number, power/2) * findToNPower(number, power/2);
		}else{
			return findToNPower(number,(power - 1)/2) * findToNPower(number, (power - 1)/2) * number;
		}	
	}
}
