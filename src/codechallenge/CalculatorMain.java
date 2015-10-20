package codechallenge;

import java.util.Scanner;

public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String regel = sc.next();
		System.out.println(Calculator.Calculate(regel));
		
	}

}
