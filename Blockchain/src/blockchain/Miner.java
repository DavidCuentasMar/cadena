/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author laptop
 */
public class Miner {

    TransactionPool txPool;

    Miner(TransactionPool txPool) {
        this.txPool = txPool;
    }

    public Bloque GenerateCandiateBock() {
        Bloque b = new Bloque(0, LocalDateTime.now(), txPool.getTransactions(), "");
        checkTransactions(b.transactions);
        return b;
    }

    public void checkTransactions(ArrayList<Transaction> transactions) {
        for (Transaction tx : transactions) {
            //TO DO: CHECK IF ADDRESS IS JAVACONTRACT
            System.out.println("JavaContract: " + Blockchain.javaContractsMap.get(tx.to_address));
            System.out.println("From: " + tx.from_address);
            System.out.println("Data:" + tx.data);
            System.out.println("----");
            ((JavaCoinContract) Blockchain.javaContractsMap.get(tx.to_address)).ejecutar(tx);
        }
    }

    void broadCastBlock(Bloque minerBlock) {
        System.out.println("Broadcast Block....");
    }

}
