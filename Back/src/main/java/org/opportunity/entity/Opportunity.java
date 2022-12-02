package org.opportunity.entity;

import com.sun.istack.NotNull;

import java.util.List;

public class Opportunity {
    public String name;
    public List<Action> actions;

    public Opportunity(java.lang.String name, @NotNull List<Action> actions) throws NullPointerException{
        if (actions.isEmpty()) throw new NullPointerException("You can't create opportunity without contacts");
        this.name = name;
        this.actions = actions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
