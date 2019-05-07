package com.halodoc.logprocessor.controller;

import com.halodoc.logprocessor.service.LogProcessingService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
@ComponentScan
public class LogController {

    private static final int SUCCESSFUL = 0;
    private static final int SUCCESS = 200;
    private static final int FAILURE = 400;
    private LogProcessingService logProcessingService;

    public LogController(LogProcessingService logProcessingService) {
        this.logProcessingService = logProcessingService;
    }

    @GetMapping("/")
    public String home(){
        return "Log processor home";
    }

    @GetMapping("/initialize")
    public String initializeLogProcessing(){
        this.logProcessingService.initialize();
        return "Log processor home";
    }

    @PostMapping("/postLogs")
    public int postLogs(@RequestBody String logs) {
        if(this.logProcessingService.processLog(logs) == SUCCESSFUL) {
            return SUCCESS;
        }

        return FAILURE;
    }

}
