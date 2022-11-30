package org.opportunity;

import org.junit.jupiter.api.Test;
import org.opportunity.entity.Contact;
import org.opportunity.entity.FutureAction;
import org.opportunity.entity.InvalidDateException;
import org.opportunity.entity.VIA;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Objects;

@SpringBootTest
class OpportunityApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void FutureAction_FutureDate_CorrectInitialization() throws Exception {
		LocalDate date = LocalDate.now();
		FutureAction action = new FutureAction("Juan", VIA.EMAIL, date.plusDays(1));

		//assert action instanceof FutureAction;
		assert Objects.equals(action.getName(), "Juan");
		assert action.getVia() == VIA.EMAIL;
		assert Objects.equals(date.plusDays(1), action.getDate());
	}

	@Test
	void FutureAction_PastDate_InvalidDateException(){
		try {
			LocalDate date = LocalDate.now();
			new FutureAction("Juan", VIA.EMAIL, date.minusDays(1));
			assert false;
		} catch (InvalidDateException e){
			assert true;
		}
	}

	@Test
	void FutureAction_RightNow_InvalidDateException(){
		try {
			new FutureAction("Juan", VIA.EMAIL, LocalDate.now());
			assert false;
		} catch (InvalidDateException e){
			assert true;
		}
	}

	@Test
	void Contact_PastDate_CorrectInitialization() throws InvalidDateException {
		LocalDate date = LocalDate.now();
		Contact action = new Contact ("Juan", VIA.EMAIL, date.minusDays(1), "Presentation");

		//assert action instanceof Contact;
		assert Objects.equals(action.getName(), "Juan");
		assert action.getVia() == VIA.EMAIL;
		assert Objects.equals(date.minusDays(1), action.getDate());
		assert Objects.equals(action.getResume(), "Presentation");
	}

	@Test
	void Contact_FutureDate_InvalidDateException(){
		try {
			LocalDate date = LocalDate.now();
			new Contact("Juan", VIA.EMAIL, date.plusDays(1), "Presentation");
			assert false;
		} catch (InvalidDateException e) {
			assert true;
		}
	}

	@Test
	void Contact_RightNow_CorrectInitialization() throws InvalidDateException {
		LocalDate date = LocalDate.now();
		Contact action = new Contact("Juan", VIA.EMAIL, date, "Presentation");

		assert Objects.equals(action.getName(), "Juan");
		assert action.getVia() == VIA.EMAIL;
		assert Objects.equals(date, action.getDate());
		assert Objects.equals(action.getResume(), "Presentation");
	}

}
