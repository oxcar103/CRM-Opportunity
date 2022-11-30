package org.opportunity.entity;

import java.time.LocalDate;

public class Contact extends Action {
    public String resume;

    public Contact(String name, VIA via, LocalDate date, String resume) throws InvalidDateException {
        super(name, via, date);
        if (date.isAfter(LocalDate.now())) throw new InvalidDateException("You can't define a contact's date after today");
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
