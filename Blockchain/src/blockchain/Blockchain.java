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
    
    ArrayList<JavaContract> contracts;
    
    public static HashMap<String, Object> javaContractsMap = new HashMap<String, Object>(){{
        put("JavaCoin", new JavaCoinContract());
    }};
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Chain theChain = new Chain();
        TransactionPool txPool = new TransactionPool();
        
        txPool.addTransaction(new Transaction(
                "addrx1",
                "contractAddress",
                new String[]{"Destiny", "10.0"})
        );
        txPool.addTransaction(new Transaction("addrx2","contractAddress",new String[]{"Destiny", "20.0"}));
        txPool.addTransaction(new Transaction("addrx3","contractAddress",new String[]{"Destiny", "30.0"}));
        
        Bloque b = new Bloque(0, LocalDateTime.now(), txPool.getTransactions(), "0");
        //Before adding the block to the cain we should check all transactios to see if they are okey
        Miner.checkTransactions(txPool.getTransactions());
        theChain.addBlock(b);
        
        
        theChain.listAllBlocks();
        
        
    }
    
}
