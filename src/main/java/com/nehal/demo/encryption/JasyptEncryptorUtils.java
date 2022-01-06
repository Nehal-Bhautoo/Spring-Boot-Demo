package com.nehal.demo.encryption;

import org.jasypt.properties.PropertyValueEncryptionUtils;
import org.jasypt.util.text.BasicTextEncryptor;

public final class JasyptEncryptorUtils {
    private static final String salt = "lybgeek";
    private static final BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();

    static {
        basicTextEncryptor.setPassword(salt);
    }

    private JasyptEncryptorUtils() {}

    /**
     *Plaintext encryption
     * @param plaintext -
     * @return ciphertext
     */
    public static String encode(String plaintext){
        System.out.println("plaintext string:" + plaintext);
        String ciphertext = basicTextEncryptor.encrypt(plaintext);
        System.out.println("encrypted string:" + ciphertext);
        return ciphertext;
    }

    /**
     *Decryption
     * @param ciphertext -
     * @return null
     */
    public static String decode(String ciphertext){
        System.out.println("encrypted string:" + ciphertext);
        ciphertext = "ENC(" + ciphertext + ")";
        if (PropertyValueEncryptionUtils.isEncryptedValue(ciphertext)){
            String plaintext = PropertyValueEncryptionUtils.decrypt(ciphertext,basicTextEncryptor);
            System.out.println("decrypted string:" + plaintext);
            return plaintext;
        }
        System.out.println ("decryption failed");
        return "";
    }
}
