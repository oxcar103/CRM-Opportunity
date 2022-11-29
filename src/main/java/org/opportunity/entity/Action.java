package org.opportunity.entity;

import java.util.Date;

enum Via{
    EMAIL,
    PHONE,
    VISIT
}
public class Action {
    public String Name;
    public Via via;
    public Date date;

    public Action(String name, Via via, Date date) {
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

    public Via getVia() {
        return via;
    }

    public void setVia(Via via) {
        this.via = via;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
