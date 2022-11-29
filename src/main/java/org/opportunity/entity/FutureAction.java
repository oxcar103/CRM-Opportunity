package org.opportunity.entity;

import java.time.LocalDate;

public class FutureAction extends Action{
    public String Name;
    public VIA via;
    public LocalDate date;

    public FutureAction(String name, VIA via, LocalDate date) throws InvalidDateException {
        super(name, via, date);
        if (date.isBefore(LocalDate.now())) {
            throw new InvalidDateException("You can't define a future action's date before today");
        }
    }
}
