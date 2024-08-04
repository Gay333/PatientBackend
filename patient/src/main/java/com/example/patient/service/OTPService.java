package com.example.patient.service;

/*import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OTPService {

    @Value("${vonage.api.key}")
    private String apiKey;

    @Value("${vonage.api.secret}")
    private String apiSecret;

    public String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public void sendOTP(String phoneNumber, String otp) {
        VonageClient client = VonageClient.builder()
                .apiKey(apiKey)
                .apiSecret(apiSecret)
                .build();

        TextMessage message = new TextMessage("YourAppName",
                phoneNumber,
                "Your OTP is: " + otp);

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            System.out.println("Message sent successfully.");
        } else {
            System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
        }
    }
}
*/

//package com.example.patient.service;

import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OTPService {
    private final PatientService patientService;
    public OTPService(PatientService patientService){this.patientService=patientService;}
    @Value("${vonage.api.key}")
    private String apiKey;

    @Value("${vonage.api.secret}")
    private String apiSecret;

    private Map<String, String> otpStorage = new HashMap<>();

    public String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public void sendOTP(String phoneNumber, String otp) {
        // Ensure the phone number is in the correct format
        if(patientService.checkPhone(phoneNumber)) {
            if (!phoneNumber.startsWith("+")) {
                phoneNumber = "+91" + phoneNumber; // Assuming +91 for India, change as needed
            }
            if (phoneNumber.equals("")) {

                VonageClient client = VonageClient.builder()
                        .apiKey(apiKey)
                        .apiSecret(apiSecret)
                        .build();

                TextMessage message = new TextMessage("YourAppName",
                        phoneNumber,
                        "Your OTP is: " + otp);

                SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

                if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
                    System.out.println("Message sent successfully.");
                    otpStorage.put(phoneNumber, otp); // Store the OTP
                } else {
                    System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
                }
            } else {
                System.out.println("No phone Number!");
            }
        }
        else{
            System.out.println("No such phone Number exists!");
        }
    }

    public boolean verifyOTP(String phoneNumber, String otp) {
        String storedOtp = otpStorage.get(phoneNumber);
        return storedOtp != null && storedOtp.equals(otp);
    }
}
