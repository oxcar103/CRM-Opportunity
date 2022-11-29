package org.opportunity.entity;

import java.util.Date;

public class Action {
    public String Name;
    public VIA via;
    public Date date;

    public Action(String name, VIA via, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
