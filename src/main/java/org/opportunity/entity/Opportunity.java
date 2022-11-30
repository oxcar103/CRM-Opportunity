package org.opportunity.entity;

import com.sun.istack.NotNull;

import java.util.List;

public class Opportunity {
    public String name;
    public List<Action> actions;

    public Opportunity(String name, @NotNull List<Action> actions) {
        this.name = name;
        this.actions = actions;
    }

    public Opportunity() {
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
