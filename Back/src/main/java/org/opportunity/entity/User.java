package org.opportunity.entity;

import java.util.List;

public class User {
    public String username;
    public String password;
    List<Opportunity> opportunities;

    public User(String username, String password, List<Opportunity> opportunities) {
        this.username = username;
        this.password = password;
        this.opportunities = opportunities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }
}
