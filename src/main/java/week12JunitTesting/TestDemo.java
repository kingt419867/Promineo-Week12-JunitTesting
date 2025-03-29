package week12JunitTesting;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		int sum = 0;
		if (a > 0 && b > 0) {
			sum = a+b;
			System.out.println("The sum is: " + sum);
			return sum;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	} // addPositive
	
	// 3. Create Your Own Method & JUnit Test, from the instructions. 
	public boolean pythagorean(int right, int left, int hypotenuse) {
		Integer sumOfSquares = 0;
		Integer rightSquare = right * right;
		Integer leftSquare = left * left;
		Integer hypSquare = hypotenuse * hypotenuse;
		System.out.println("The Square of the Hypotenuse is " + hypSquare);
		sumOfSquares = rightSquare + leftSquare;
		System.out.println("The Sum of the Squares of the Legs is " + sumOfSquares);
		boolean isRightTriangle = false;
		if (sumOfSquares.equals(hypSquare)) {
			System.out.println("It is a Right Triangle.");
			isRightTriangle = true;
		} else {
			System.out.println("It is not really a Right Triangle.");
			isRightTriangle = false;
		}
		return isRightTriangle;
	}
	
	// 4. Mocking a Class - TestDemo
	public int randomNumberSquared() {
		Integer randomNumber = getRandomInt();
		Integer squared = randomNumber * randomNumber;
		System.out.println("\nThe random number is " + randomNumber);
		System.out.println("The squared number is " + squared);
		return squared;
	} // randomNumberSquared

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
} // class
