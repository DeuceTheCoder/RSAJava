package com.deuceCodes.RSAEncrypt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class EncryptionKeyMaker {

    private static KeyPairGenerator keyPairGenerator;

    public EncryptionKeyMaker() {
        this(null);
    }

    protected EncryptionKeyMaker(KeyPairGenerator generator) {
        initKeyGenerator(generator);
    }

    private void initKeyGenerator(KeyPairGenerator generator) {
        if (generator == null) {
            try {
                keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } else {
            keyPairGenerator = generator;
        }

        keyPairGenerator.initialize(1024);
    }

    public KeyPair generatePair() {
        return keyPairGenerator.generateKeyPair();
    }
}
