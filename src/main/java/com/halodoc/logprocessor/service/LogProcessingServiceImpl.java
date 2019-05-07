package com.halodoc.logprocessor.service;

import com.halodoc.logprocessor.dao.UserDao;
import com.halodoc.logprocessor.domain.LogEvent;
import com.halodoc.logprocessor.domain.LogParser;
import com.halodoc.logprocessor.domain.LogType;
import com.halodoc.logprocessor.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LogProcessingServiceImpl implements LogProcessingService {

    private static final int SUCCESS = 200;
    private static final int FAILURE = 400;

    @Autowired
    private UserDao userDao;

    @Override
    public int processLog(String log) {
        final LogType logType = LogParser.parse(log);
        if(logType != LogType.NOT_VALID) {
            // This will publish event for all the users waiting on this to listen.
            this.publishLogEvent(logType);
            return SUCCESS;
        } else {
            return FAILURE;
        }

    }

    @Override
    public LogEvent publishLogEvent(LogType logType) {
        final LogEvent logEvent = new LogEvent(logType);
        return logEvent;
    }

    @Override
    public void initialize() {
        List<User> users = this.userDao.getAllUsers();
        createUserEventListner(users);
    }

    /**
     * This creats user event listener for all the users.
     * @param users
     */
    private void createUserEventListner(List<User> users) {
    }


}
