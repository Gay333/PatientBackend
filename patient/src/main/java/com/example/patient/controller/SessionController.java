/*package com.example.patient.controller;

import com.example.patient.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/active-sessions")
    public Map<String, ? extends Session> getActiveSessions() {
        return sessionService.getActiveSessions();
    }
}
*/