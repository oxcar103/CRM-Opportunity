package org.opportunity.entity;

public class InvalidDateException extends Exception {
    public InvalidDateException(String str) {
        // calling the constructor of parent Exception
        super(str);
    }
}
