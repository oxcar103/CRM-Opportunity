package org.opportunity.entity;

import java.time.LocalDate;

public class Contact extends Action {
    public String resume;

    public Contact(String name, VIA via, LocalDate date, String resume) throws Exception {
        super(name, via, date);
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
