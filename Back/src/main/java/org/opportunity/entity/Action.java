package org.opportunity.entity;

import java.time.LocalDate;


public abstract class Action {
    public String name;
    public VIA via;
    public LocalDate date;

    public Action(String name, VIA via, LocalDate date){
        this.name = name;
        this.via = via;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
