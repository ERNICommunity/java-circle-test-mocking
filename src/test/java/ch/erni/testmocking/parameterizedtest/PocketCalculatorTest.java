package ch.erni.testmocking.parameterizedtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
class PocketCalculatorTest {

	@InjectMocks
	private PocketCalculator pocketCalculator;

	@Test
	void add() {
		assertThat(pocketCalculator.calculate(10, Operator.ADD, 7)).isEqualTo(17);
		assertThat(pocketCalculator.calculate(-5, Operator.ADD, 3)).isEqualTo(-2);
		assertThat(pocketCalculator.calculate(Integer.MAX_VALUE, Operator.ADD, 1)).isEqualTo(Integer.MIN_VALUE);
	}

	@Test
	void subtract() {
		assertThat(pocketCalculator.calculate(10, Operator.SUBTRACT, 7)).isEqualTo(3);
		assertThat(pocketCalculator.calculate(1, Operator.SUBTRACT, -2)).isEqualTo(3);
	}

	@Test
	void multiply() {
		assertThat(pocketCalculator.calculate(10, Operator.MULTIPLY, 7)).isEqualTo(70);
		assertThat(pocketCalculator.calculate(43, Operator.MULTIPLY, 0)).isEqualTo(0);
	}

	@Test
	void divide() {
		assertThat(pocketCalculator.calculate(10, Operator.DIVIDE, 7)).isEqualTo(1);
		assertThat(pocketCalculator.calculate(42, Operator.DIVIDE, -6)).isEqualTo(-7);
		assertThat(pocketCalculator.calculate(0, Operator.DIVIDE, 0)).isEqualTo(-1);
	}

}