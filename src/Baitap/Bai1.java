package Baitap;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Bai1 {
    private static String bytesToHex( byte[]hash){
        StringBuilder hexString = new StringBuilder();
        for (byte b: hash){
            String hex= Integer.toHexString(0xff & b);
            if (hex.length()==1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public static void main(String[] args) {
        final MessageDigest digest; 
        String str = "Hello world";
        try {
            digest= MessageDigest.getInstance("SHA3-256");
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
        final byte[] hashed = digest.digest(str.getBytes(StandardCharsets.UTF_8));
        String sha3Hex = bytesToHex(hashed);
        System.out.println(sha3Hex);
    }
}
