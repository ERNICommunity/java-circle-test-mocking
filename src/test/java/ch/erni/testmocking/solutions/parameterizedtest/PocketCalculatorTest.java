package ch.erni.testmocking.solutions.parameterizedtest;

import ch.erni.testmocking.parameterizedtest.Operator;
import ch.erni.testmocking.parameterizedtest.PocketCalculator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
class PocketCalculatorTest {

	@InjectMocks
	private PocketCalculator pocketCalculator;

	static Stream<Arguments> calculate_source() {
		return Stream.of(
				arguments(10, 7, Operator.ADD, 17),
				arguments(-5, 3, Operator.ADD, -2),
				arguments(Integer.MAX_VALUE, 1, Operator.ADD, Integer.MIN_VALUE),
				arguments(10, 7, Operator.SUBTRACT, 3),
				arguments(1, -2, Operator.SUBTRACT, 3),
				arguments(10, 7, Operator.MULTIPLY, 70),
				arguments(10, 0, Operator.MULTIPLY, 0),
				arguments(10, 7, Operator.DIVIDE, 1),
				arguments(42, -6, Operator.DIVIDE, -7),
				arguments(0, 0, Operator.DIVIDE, -1)
		);
	}

	@ParameterizedTest
	@MethodSource("calculate_source")
	void calculate(int number1, int number2, Operator operator, int expected) {
		assertThat(pocketCalculator.calculate(number1, operator, number2)).isEqualTo(expected);
	}

}