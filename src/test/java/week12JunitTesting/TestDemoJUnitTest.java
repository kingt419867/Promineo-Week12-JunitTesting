package week12JunitTesting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.*;

class TestDemoJUnitTest {

	private  TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	} // setUp

	@ParameterizedTest
	@MethodSource("week12JunitTesting.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	} // assertThatTwoPositiveNumbersAreAddedCorrectly

	static Stream<Arguments> argumentsForAddPositive() {
		//@formatter:off
		return Stream.of(
		arguments(2, 4, 6, false),
		arguments(0, 6, 6, true),
		arguments(6, 0, 6, true),
		arguments(0, 0, 0, true),
		arguments(-2, 6, 4, true),
		arguments(6, -2, 4, true),
		arguments(-2, -2, -4, true)
		);
		//@formatter:on
	} //argumentsForAddPositive
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		// Given: a pair of positive integers, a and b
		int a = 10;
		int b = 20;
		// When: They are added together
		int expected = 30;
		// Then: They produce a positive sum, without error.
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
		
	} // assertThatPairsOfPositiveNumbersAreAddedCorrectly
	
	
	// 3. Create Your Own Method & JUnit Test, from the instructions.
	
	@Test
	void assertEqualsPythagoreanTheorem() {
		// Given: An allegedly Right Triangle
		Integer right = 3;
		Integer left = 4;
		Integer hypotenuse = 5;
		Integer rightSquare = 0;
		Integer leftSquare = 0;
		Integer hypSquare = 0;
		// When:  The sides are squared
		rightSquare = right * right;
		leftSquare = left * left;
		hypSquare = hypotenuse * hypotenuse;
		// Then: The sum of the squares of the left and right legs should equal the square of the hypotenuse.
		Integer sumOfSquares = rightSquare + leftSquare;
//		if (!hypSquare.equals(sumOfSquares)) {
//			System.out.println("It is not really a Right Triangle.");
//		} else {
//			System.out.println("It is a Right Triangle.");
//		}

		assertThat(testDemo.pythagorean(right, left, hypotenuse));  // This tests the method.
		assertEquals(sumOfSquares, hypSquare); // This tests the formula
	}
	
	// 4. Mocking a Class - TestDemo
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	} // assertThatNumberSquaredIsCorrect
	
} // class
