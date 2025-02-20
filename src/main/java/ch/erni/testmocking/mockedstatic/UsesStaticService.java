package ch.erni.testmocking.mockedstatic;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class UsesStaticService {

	public DayOfWeek getWeekDay() {
		return LocalDate.now().getDayOfWeek();
	}

}
