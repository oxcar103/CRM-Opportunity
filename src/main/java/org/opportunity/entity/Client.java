package org.opportunity.entity;

import java.util.List;

public class Client extends Opportunity{

    public Client(String name, List<Action> actions) {
        super(name, actions);
    }
}
