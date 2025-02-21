package ch.erni.testmocking.parameterizedtest;

import org.springframework.stereotype.Service;

@Service
public class PocketCalculator {

	public int calculate(int number1, Operator operator, int number2) {
		return switch (operator) {
			case ADD -> number1 + number2;
			case SUBTRACT -> number1 - number2;
			case MULTIPLY -> number1 * number2;
			case DIVIDE -> handleDivision(number1, number2);
		};
	}

	private int handleDivision(int number1, int number2) {
		if (number2 == 0) {
			return -1;
		}

		return number1 / number2;
	}

}
