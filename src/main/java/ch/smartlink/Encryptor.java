package ch.smartlink;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * Created by chuong on 06/04/2016.
 */
public  class Encryptor {
    public static String encrypt(String input, String key){
        byte[] crypted = null;
        try{
            Cipher cipher = getCipher(key, Cipher.ENCRYPT_MODE);
            crypted = cipher.doFinal(input.getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }
        return Base64.encodeBase64String(crypted);
    }

    public static String decrypt(String input, String key){
        byte[] output = null;
        try{
            Cipher cipher = getCipher(key, Cipher.DECRYPT_MODE);
            output = cipher.doFinal(Base64.decodeBase64(input));
        }catch(Exception e){
            e.printStackTrace();
        }
        return new String(output);
    }

    private static Cipher getCipher(String encryptionKey, int cipherMode)
            throws Exception {
        String encryptionAlgorithm = "AES";
        byte[] keyValue = DatatypeConverter.parseHexBinary(encryptionKey);
        SecretKeySpec keySpecification = new SecretKeySpec(keyValue, encryptionAlgorithm);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(cipherMode, keySpecification);

        return cipher;
    }
}