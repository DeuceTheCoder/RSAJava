package com.deuceCodes.RSAEncrypt;

import org.junit.Test;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EncryptionKeyMakerTest {
    @Test
    public void shouldGenerateKeyPair() throws Exception {
        EncryptionKeyMaker keyMaker = new EncryptionKeyMaker();
        KeyPair keyPair = keyMaker.generatePair();

        assertNotNull(keyPair);
        assertNotNull(keyPair.getPrivate());
        assertNotNull(keyPair.getPublic());
    }

    @Test
    public void shouldReturnSpecifiedKeys() throws Exception {
        KeyPair testKeyPair = new KeyPair(mock(RSAPublicKey.class), mock(RSAPrivateKey.class));
        KeyPairGenerator keyPairGenerator = mock(KeyPairGenerator.class);
        when(keyPairGenerator.generateKeyPair()).thenReturn(testKeyPair);

        EncryptionKeyMaker keyMaker = new EncryptionKeyMaker(keyPairGenerator);

        assertThat(keyMaker.generatePair(), is(equalTo(testKeyPair)));
    }
}
