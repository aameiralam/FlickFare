package com.jdbcLearning.Models;



public class Subscription {

    private int subscriptionId;
    private String subscriptionType;
    private String startDate;
    private String subscriptionStatus;

    public Subscription(){

    }

    public Subscription(String subscriptionType, String startDate, String subscriptionStatus) {
        this.startDate = startDate;
        this.subscriptionStatus = subscriptionStatus;
        this.subscriptionType = subscriptionType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "startDate=" + startDate +
                ", subscriptionId=" + subscriptionId +
                ", subscriptionType='" + subscriptionType + '\'' +
                ", subscriptionStatus='" + subscriptionStatus + '\'' +
                '}';
    }
}
