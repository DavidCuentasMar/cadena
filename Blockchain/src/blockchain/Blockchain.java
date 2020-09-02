/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author super
 */
public class Blockchain {

    public static final int DIFFICULTY = 3;
    
    public static HashMap<String, Object> javaContractsMap = new HashMap<String, Object>(){{
        put("JavaCoinContract", new JavaCoinContract() );
    }};
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Chain creation
        Chain theChain = new Chain();

        //Minner creation
        Miner miner1 = new Miner(new TransactionPool());
        
        //Adding Transaction to the miner's transacion pool
        miner1.txPool.addTransaction(new Transaction("addrx1","JavaCoinContract",new String[]{"Destiny", "10.0"}));
        miner1.txPool.addTransaction(new Transaction("addrx2","JavaCoinContract",new String[]{"Destiny", "20.0"}));
        miner1.txPool.addTransaction(new Transaction("addrx3","JavaCoinContract",new String[]{"Destiny", "30.0"}));
        
        //Create Genesis Block 
        Bloque b = new Bloque(0, LocalDateTime.now(), new ArrayList(), "0");
        theChain.addBlock(b);

          
        //Miner Generates Candidate Block
        Bloque minerBlock = miner1.GenerateCandiateBock();
        miner1.broadCastBlock(minerBlock);
        
        theChain.addBlock(minerBlock);

        
        theChain.listAllBlocks();
        
        
    }
    
}
