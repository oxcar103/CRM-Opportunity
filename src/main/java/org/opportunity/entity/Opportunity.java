package org.opportunity.entity;

import java.util.List;

public class Opportunity {
    public String Name;
    public List<Action> actions;

    public Opportunity(String name, List<Action> actions) {
        Name = name;
        this.actions = actions;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
