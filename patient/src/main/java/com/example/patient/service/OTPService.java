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

import com.example.patient.model.Patient;
import com.example.patient.repository.PatientRepository;
import com.example.patient.service.PatientService;
import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OTPService {
    private final PatientService patientService;
    public OTPService(PatientService patientService, PatientRepository patientRepository){this.patientService=patientService;this.patientRepository = patientRepository;}
    @Value("${vonage.api.key}")
    private String apiKey;

    @Value("${vonage.api.secret}")
    private String apiSecret;

    private Map<String, String> otpStorage = new HashMap<>();
    private PatientRepository patientRepository;

    //public OTPService(){}

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
            if (!phoneNumber.equals("")) {

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

    public boolean verifyOTP(String phoneNumber, String otp, HttpSession session) {
        String storedOtp = otpStorage.get(phoneNumber);
        boolean x = storedOtp != null && storedOtp.equals(otp);
        Iterable<Patient> patient = patientRepository.findPhone(phoneNumber);
        if(x){
            for(Patient p: patient) {
                session.setAttribute("patient_id", p.getPatient_Id());
                System.out.println("PATIENT: " + session.getAttribute("patient_id"));
                return storedOtp != null && storedOtp.equals(otp);
            }
        }
        return false;

    }
}
