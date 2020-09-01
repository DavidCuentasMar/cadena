/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author laptop
 */
public class Miner {


    public static void checkTransactions(ArrayList<Transaction> transactions){
        for (Transaction tx : transactions) {
            //TO DO: CHECK IF ADDRESS IS JAVACONTRACT
            System.out.println("JavaContract: " + Blockchain.javaContractsMap.get(tx.to_address)); 
            System.out.println("From: " + tx.from_address);
            System.out.println("Data:" + tx.data);
       }
    }
    
}
