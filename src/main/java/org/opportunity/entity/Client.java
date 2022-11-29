package org.opportunity.entity;

import com.sun.istack.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Client extends Opportunity{
    public String reason;
    Iterator<Action> sale;
    public Client(String name, List<Action> actions, String reason, Iterator<Action> sale) {
        super(name, actions);
        this.reason = reason;
        this.sale = sale;
    }
    public Client(String name, List<Action> actions, String reason) {
        this(name, actions, reason, actions.listIterator());

        while(sale.hasNext())
            sale.next();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Iterator<Action> getSale() {
        return sale;
    }

    public void setSale(Iterator<Action> sale) {
        this.sale = sale;
    }

}
