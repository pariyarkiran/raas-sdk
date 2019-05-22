package com.lftechnology.raas.sdk.dto;

import java.util.List;

/**
 * Object holds transaction limit information of specific sender and their recipients
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class TransactionLimit {

    private String currentTier;

    private SenderLimit sender;

    private List<ReceiverLimit> receiver;

    public String getCurrentTier() {
        return currentTier;
    }

    public void setCurrentTier(String currentTier) {
        this.currentTier = currentTier;
    }

    public SenderLimit getSender() {
        return sender;
    }

    public void setSender(SenderLimit sender) {
        this.sender = sender;
    }

    public List<ReceiverLimit> getReceiver() {
        return receiver;
    }

    public void setReceiver(List<ReceiverLimit> receiver) {
        this.receiver = receiver;
    }

    @Override public String toString() {
        return "TransactionLimit{" + "currentTier='" + currentTier + '\'' + ", sender=" + sender + ", receiver=" + receiver + '}';
    }
}

