package org.opportunity;

import org.junit.jupiter.api.Test;
import org.opportunity.entity.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
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

	@Test
	void Opportunity_ValidContacts_CorrectInitialization() throws InvalidDateException, NullPointerException {
		String name = "Juan";
		List<Action> actions = List.of(new Contact(name, VIA.EMAIL, LocalDate.now(), "Presentation"));

		Opportunity opp = new Opportunity(name, actions);

		assert Objects.equals(opp.getName(), name);
		assert Objects.equals(opp.getActions(), actions);
	}

	@Test
	void Opportunity_NoContacts_NullPointerException(){
		String name = "Juan";

		try {
			new Opportunity(name, null);
			assert false;
		} catch (NullPointerException e){
			assert true;
		}
	}
	@Test
	void Client_ValidContacts_CorrectInitialization() throws InvalidDateException, NullPointerException {
		String name = "Juan";
		String reason = "Item sold";
		List<Action> actions = List.of(new Contact(name, VIA.EMAIL, LocalDate.now(), "Presentation"),
				new Contact(name, VIA.VISIT, LocalDate.now(), "Information"));

		Client cli = new Client(name, actions, reason);

		assert Objects.equals(cli.getName(), name);
		assert Objects.equals(cli.getActions(), actions);
		assert Objects.equals(cli.getReason(), reason);
	}

	@Test
	void Client_NoContacts_NullPointerException(){
		String name = "Juan";
		String reason = "Item sold";

		try {
			new Client(name, null, reason);
			assert false;
		} catch (NullPointerException e){
			assert true;
		}
	}

	@Test
	void Client_PreviousOpportunity_ValidInitialization() throws InvalidDateException, NullPointerException {
		String name = "Juan";
		String reason = "Item sold";
		List<Action> actions = List.of(new Contact(name, VIA.EMAIL, LocalDate.now(), "Presentation"));

		Opportunity opp = new Opportunity(name, actions);
		Client cli = new Client(opp, reason);

		assert Objects.equals(cli.getName(), name);
		assert Objects.equals(cli.getActions(), actions);
		assert Objects.equals(cli.getReason(), reason);
	}
}
