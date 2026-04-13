package com.company.myfiles;

public class OTPUtil {
    public static String generateOTP() {
        int otp = (int)(Math.random() * 900000) + 100000;
        return String.valueOf(otp);
    }
}