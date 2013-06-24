package com.deuceCodes.RSAEncrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

public class RSAMachine {
    public byte[] encrypt(String message, PublicKey publicKey) {
        return useCipher(message.getBytes(), publicKey, Cipher.ENCRYPT_MODE);
    }

    public String decrypt(byte[] cipherText, PrivateKey privateKey) {
        return new String(useCipher(cipherText, privateKey, Cipher.DECRYPT_MODE));
    }

    private byte[] useCipher(byte[] message, Key key, int mode) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

        if (cipher != null) {
            try {
                cipher.init(mode, key);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }

        byte[] outputText = null;
        try {
            outputText = cipher.doFinal(message);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return outputText;
    }

    public static byte[] stringToByteArray(String input) {
        byte[] bytes = new byte[input.length()];

        for(int i=0; i<input.length(); i++) {
            bytes[i] = (byte) input.charAt(i);
        }
        return bytes;
    }

    public static String byteArrayToString(byte[] input) {
        return new String(input);
    }
}
