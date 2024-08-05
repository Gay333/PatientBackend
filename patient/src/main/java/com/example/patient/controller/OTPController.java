package com.example.patient.controller;
/*
import com.example.patient.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
public class OTPController {

    @Autowired
    private OTPService otpService;

    @PostMapping("/generate")
    public String generateOTP(@RequestParam String phoneNumber) {
        System.out.println(phoneNumber);
        String otp = otpService.generateOTP();
        otpService.sendOTP(phoneNumber, otp);
        return "OTP sent successfully"; // Do not return the OTP in production
    }
}
*/

import com.example.patient.service.OTPService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
public class OTPController {

    @Autowired
    private OTPService otpService;

    @PostMapping("/generate")
    public String generateOTP(@RequestParam String phoneNumber) {
        String otp = otpService.generateOTP();
        otpService.sendOTP(phoneNumber, otp);
        return "OTP sent successfully"; // Do not return the OTP in production
    }

    @PostMapping("/verify")
    public boolean verifyOTP(@RequestParam String phoneNumber, @RequestParam String otp, HttpSession session) {
        return otpService.verifyOTP(phoneNumber, otp, session);
    }
}

