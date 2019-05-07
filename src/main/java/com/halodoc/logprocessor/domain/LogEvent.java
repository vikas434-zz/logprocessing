package com.halodoc.logprocessor.domain;

public class LogEvent {

    private LogType logType;

    private long currentTimeStamp;

    public LogEvent(LogType logType) {
        this.logType = logType;
        this.currentTimeStamp = System.currentTimeMillis();
        System.out.println("Publishing logtype of "+logType+" at time "+currentTimeStamp);
    }

    public LogType getLogType() {
        return this.logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    public long getCurrentTimeStamp() {
        return this.currentTimeStamp;
    }

    public void setCurrentTimeStamp(long currentTimeStamp) {
        this.currentTimeStamp = currentTimeStamp;
    }
}
