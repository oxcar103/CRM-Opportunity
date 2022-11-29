package org.opportunity;

import org.junit.jupiter.api.Test;
import org.opportunity.entity.Action;
import org.opportunity.entity.VIA;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@SpringBootTest
class OpportunityApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void Action_FutureDate_CorrectInitialization(){
		LocalDate date = LocalDate.now();
		Action action = new Action("Juan", VIA.EMAIL, date.plusDays(1));

		assert action instanceof Action;
		assert action.getName() == "Juan";
		assert action.getVia() == VIA.EMAIL;
		assert Objects.equals(date.plusDays(1), action.getDate());
	}
}
