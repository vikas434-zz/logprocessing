package com.halodoc.logprocessor.domain;

public abstract class AbstractLogProcessor {

    private LogType logType;

    abstract LogEvent publishLogEvent();

}
