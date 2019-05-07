package com.halodoc.logprocessor.domain;

public class LogParser {

    public static LogType parse(String log) {
        if (isValidLog(log)) {
            final LogType logType = getLogType(log);
            return logType;
        }
        return LogType.NOT_VALID;
    }

    private static LogType getLogType(String log) {
        String[] logs = log.split("");
        String logType = logs[2];
        return LogType.valueOf(logType);
    }

    private static boolean isValidLog(String log) {
        // Do all check for validity of log and format.
        return true;
    }
}
