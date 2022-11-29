package org.opportunity.entity;

import java.util.Date;

public class Contact extends Action {
    public String Resume;

    public Contact(String name, VIA via, Date date, String resume) {
        super(name, via, date);
        Resume = resume;
    }

    public String getResume() {
        return Resume;
    }

    public void setResume(String resume) {
        Resume = resume;
    }
}
