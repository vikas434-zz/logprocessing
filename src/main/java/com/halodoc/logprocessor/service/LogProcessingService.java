package com.halodoc.logprocessor.service;

import com.halodoc.logprocessor.domain.LogEvent;
import com.halodoc.logprocessor.domain.LogType;

public interface LogProcessingService {

    public int processLog(String logs);

    public LogEvent publishLogEvent(LogType logType);

    void initialize();
}
