package ch.erni.testmocking.solutions.mockedstatic;

import ch.erni.testmocking.mockedstatic.UsesStaticService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
class UsesStaticServiceTest {

	@InjectMocks
	private UsesStaticService service;

	@Test
	void getWeekDay() {
		LocalDate date = LocalDate.of(2025, Month.JANUARY, 1);

		try (MockedStatic<LocalDate> mockedLocalDate = mockStatic(LocalDate.class)) {
			mockedLocalDate.when(LocalDate::now).thenReturn(date);

			var day = service.getWeekDay();

			assertThat(day).isEqualTo(DayOfWeek.WEDNESDAY);
		}
	}

}