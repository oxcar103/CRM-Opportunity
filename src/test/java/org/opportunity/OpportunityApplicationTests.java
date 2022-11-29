package org.opportunity;

import org.aspectj.weaver.bcel.ExceptionRange;
import org.junit.jupiter.api.Test;
import org.opportunity.entity.FutureAction;
import org.opportunity.entity.InvalidDateException;
import org.opportunity.entity.VIA;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.Objects;

import static org.assertj.core.api.Fail.fail;

@SpringBootTest
class OpportunityApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void Action_FutureDate_CorrectInitialization() throws Exception {
		LocalDate date = LocalDate.now();
		FutureAction action = new FutureAction("Juan", VIA.EMAIL, date.plusDays(1));

		assert action instanceof FutureAction;
		assert action.getName() == "Juan";
		assert action.getVia() == VIA.EMAIL;
		assert Objects.equals(date.plusDays(1), action.getDate());
	}

	@Test
	void Action_PastDate_Exception() throws InvalidDateException {
		try {
			LocalDate date = LocalDate.now();
			new FutureAction("Juan", VIA.EMAIL, date.minusDays(1));
			assert false;
		} catch (InvalidDateException e){
			assert true;
		}
	}
}
