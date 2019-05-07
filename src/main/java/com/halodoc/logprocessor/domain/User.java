package com.halodoc.logprocessor.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private int userId;

    private List<LogType> logTypes = new ArrayList<>();

    private AtomicInteger currentLogCount;

    private long lastTimeStamp;

    private int frequency;

    private long waitTime;

    private String email;

    private String phone;

    private NotificationSentStatus notificationSentStatus;

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<LogType> getLogTypes() {
        return this.logTypes;
    }

    public void setLogTypes(List<LogType> logTypes) {
        this.logTypes = logTypes;
    }

    public long getLastTimeStamp() {
        return this.lastTimeStamp;
    }

    public void setLastTimeStamp(long lastTimeStamp) {
        this.lastTimeStamp = lastTimeStamp;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public long getWaitTime() {
        return this.waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public NotificationSentStatus getNotificationSentStatus() {
        return this.notificationSentStatus;
    }

    public void setNotificationSentStatus(NotificationSentStatus notificationSentStatus) {
        this.notificationSentStatus = notificationSentStatus;
    }

    public AtomicInteger getCurrentLogCount() {
        return this.currentLogCount;
    }

    public void setCurrentLogCount(AtomicInteger currentLogCount) {
        this.currentLogCount = currentLogCount;
    }
}
