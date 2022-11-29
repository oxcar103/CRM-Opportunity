package org.opportunity.entity;

import java.time.LocalDate;

public class Action {
    public String Name;
    public VIA via;
    public LocalDate date;

    public Action(String name, VIA via, LocalDate date) {
        Name = name;
        this.via = via;
        this.date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public VIA getVia() {
        return via;
    }

    public void setVia(VIA via) {
        this.via = via;
    }

    public LocalDate getDate() {  return date;  }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
