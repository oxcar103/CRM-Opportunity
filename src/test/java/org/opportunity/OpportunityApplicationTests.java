package org.opportunity;

import org.aspectj.weaver.bcel.ExceptionRange;
import org.junit.jupiter.api.Test;
import org.opportunity.entity.Contact;
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
	void FutureAction_FutureDate_CorrectInitialization() throws Exception {
		LocalDate date = LocalDate.now();
		FutureAction action = new FutureAction("Juan", VIA.EMAIL, date.plusDays(1));

		assert action instanceof FutureAction;
		assert action.getName() == "Juan";
		assert action.getVia() == VIA.EMAIL;
		assert Objects.equals(date.plusDays(1), action.getDate());
	}

	@Test
	void FutureAction_PastDate_Exception() throws InvalidDateException {
		try {
			LocalDate date = LocalDate.now();
			new FutureAction("Juan", VIA.EMAIL, date.minusDays(1));
			assert false;
		} catch (InvalidDateException e){
			assert true;
		}
	}

	@Test
	void Contact_PastDate_CorrectInitialization() throws Exception {
		LocalDate date = LocalDate.now();
		Contact action = new Contact ("Juan", VIA.EMAIL, date.plusDays(1), "Presentation");

		assert action instanceof Contact;
		assert action.getName() == "Juan";
		assert action.getVia() == VIA.EMAIL;
		assert Objects.equals(date.plusDays(1), action.getDate());
		assert action.getResume() == "Presentation";
	}

	@Test
	void Contact_FutureDate_Exception() throws InvalidDateException {
		try {
			LocalDate date = LocalDate.now();
			new Contact("Juan", VIA.EMAIL, date.plusDays(1), "Presentation");
			assert false;
		} catch (InvalidDateException e) {
			assert true;
		}
	}
}
