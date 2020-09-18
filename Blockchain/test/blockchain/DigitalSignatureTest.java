/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import utils.DigitalSignature;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author laptop
 */
public class DigitalSignatureTest {
    
    public DigitalSignatureTest() {
    
    }

    /**
     * Test of generateKeys method, of class DigitalSignature.
     */
    @Test
    public void testGenerateKeys() throws Exception {
        DigitalSignature digiSig = new DigitalSignature();
        JSONObject obj = digiSig.sender();
        boolean result = digiSig.receiver(obj);
        assertTrue(result);
    }
    
}
