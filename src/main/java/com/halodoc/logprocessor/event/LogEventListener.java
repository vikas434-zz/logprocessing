package com.halodoc.logprocessor.event;

import com.halodoc.logprocessor.domain.LogEvent;

public interface LogEventListener {

    public void catchLogEvent(LogEvent logEvent);
}
