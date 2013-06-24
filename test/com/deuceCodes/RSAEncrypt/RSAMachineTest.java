package com.deuceCodes.RSAEncrypt;

import com.deuceCodes.RSAEncrypt.RSAMachine;
import org.junit.Before;
import org.junit.Test;

import java.security.KeyPair;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.not;

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
