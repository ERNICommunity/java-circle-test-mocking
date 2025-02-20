package ch.erni.testmocking.mockedstatic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
class UsesStaticServiceTest {

	@InjectMocks
	private UsesStaticService service;

	@Test
	void getWeekDay() {
		LocalDate date = LocalDate.of(2025, Month.JANUARY, 1);

		// Everytime I run this test I get a different result ?!

		var day = service.getWeekDay();

		assertThat(day).isEqualTo(DayOfWeek.WEDNESDAY);
	}

}