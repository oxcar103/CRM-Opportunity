package org.opportunity.services;

public class Service {
    private static boolean inactive = true ;
    public static String content;

    public Service(String content) {
        this.inactive = false;
        this.content = content;
    }

    public static boolean isInactive() {
        return inactive;
    }

    public static String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
