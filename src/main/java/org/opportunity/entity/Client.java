package org.opportunity.entity;

import java.util.Iterator;
import java.util.List;

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

    public Client(Opportunity opp, String reason){
        this(opp.getName(), opp.getActions(), reason);
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
