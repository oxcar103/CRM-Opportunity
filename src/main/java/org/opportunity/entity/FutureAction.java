package org.opportunity.entity;

import java.time.LocalDate;

public class FutureAction extends Action{
    public FutureAction(String name, VIA via, LocalDate date) throws InvalidDateException {
        super(name, via, date);
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now())) {
            throw new InvalidDateException("You can't define a future action's date before today");
        }
    }
}
