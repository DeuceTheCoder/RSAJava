package com.deuceCodes.RSAEncrypt;

import java.security.KeyPair;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RSAMachineTest {

    private RSAMachine rsaMachine;
    private EncryptionKeyMaker keyMaker;
    private KeyPair pair;

    @Before
    public void setUp() throws Exception {
        rsaMachine = new RSAMachine();
        keyMaker = new EncryptionKeyMaker();
        pair = keyMaker.generatePair();
    }

    @Test
    public void shouldDecryptCipherText() throws Exception {
        String plainText = "Hello World";

        byte[] cipherText = rsaMachine.encrypt(plainText, pair.getPublic());
        String message = rsaMachine.decrypt(cipherText, pair.getPrivate());

        assertThat(message, is(equalTo(plainText)));
    }

}
