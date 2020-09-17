/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author super
 */
public class Blockchain {

    public static final int DIFFICULTY = 3;
    
    public static HashMap<String, Object> javaContractsMap = new HashMap<String, Object>(){{
        put("JavaCatContract", new JavaCatContract("addrx1",50.0) );
    }};
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // Se levenata el primer nodo y por medio de una venv se le dice si copie una blockchain o cree             
        
//        try {
//            DigitalSignature digiSig = new DigitalSignature();
//            JSONObject obj = digiSig.sender();
//            boolean result = digiSig.receiver(obj);
//            System.out.println(result);
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(DigitalSignature.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvalidAlgorithmParameterException ex) {
//            Logger.getLogger(DigitalSignature.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvalidKeyException ex) {
//            Logger.getLogger(DigitalSignature.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(DigitalSignature.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SignatureException ex) {
//            Logger.getLogger(DigitalSignature.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvalidKeySpecException ex) {
//            Logger.getLogger(DigitalSignature.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // Chain creation
        Chain theChain = new Chain();
        
        //Create Genesis Block 
        Bloque b = new Bloque(0, LocalDateTime.now(), new ArrayList(), "0");
        theChain.addBlock(b);

        //Minner creation
        Miner miner1 = new Miner(new TransactionPool());
        
        //Adding Transaction to the miner's transacion pool
        //check transaction strucutre before adding to txpool
        // JAVA SGIN 
        miner1.txPool.addTransaction(new Transaction("addrx1","JavaCatContract",new String[]{"addrx2", "1.0"}));
        miner1.txPool.addTransaction(new Transaction("addrx2","JavaCatContract",new String[]{"Destiny", "5.0"}));
        miner1.txPool.addTransaction(new Transaction("addrx3","JavaCatContract",new String[]{"Destiny", "30.0"}));
        
        
        

          
        //Miner Generates Candidate Block
        Bloque minerBlock = miner1.GenerateCandiateBock();
        miner1.broadCastBlock(minerBlock);
        
        theChain.addBlock(minerBlock);
        
        theChain.listAllBlocks();
        
        System.out.println(JavaCatContract.balances);
        
        
    }
    
}
