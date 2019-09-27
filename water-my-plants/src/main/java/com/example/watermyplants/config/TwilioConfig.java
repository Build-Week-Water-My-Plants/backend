package com.example.watermyplants.config;
//
//import com.sun.istack.NotNull;
//import com.twilio.Twilio;
//import com.twilio.http.TwilioRestClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ConfigurationProperties("twilio")
//public class TwilioConfig {
//
//
//    @Value("${twilio.trial-number.path}")
//    private String trialNumber;
//
//    @Value("${twilio.auth-token}")
//    private String authToken;
//
//    @Value("${twilio.account-sid}")
//    private String accountSid;
//
//    @Value("$(twilio.destinat-number.path)")
//    private String destinationNumber;
//
//
//    public TwilioConfig() {
//
//    }
//
//    public String getAccountSid() {
//        return accountSid;
//    }
//
//    public void setAccountSid(String accountSid) {
//        this.accountSid = accountSid;
//    }
//
//    public String getAuthToken() {
//        return authToken;
//    }
//
//    public void setAuthToken(String authToken) {
//        this.authToken = authToken;
//    }
//
//    public String getTrialNumber() {
//        return trialNumber;
//    }
//
//    public void setTrialNumber(String trialNumber) {
//        this.trialNumber = trialNumber;
//    }
//
//    public String getDestinationNumber() {
//        return destinationNumber;
//    }
//
//    public void setDestinationNumber(String destinationNumber) {
//        this.destinationNumber = destinationNumber;
//    }
//}
