/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.util.ArrayList;

/**
 *
 * @author laptop
 */
public class TransactionPool {
    ArrayList<Transaction> transactions;
    
    public TransactionPool() {
        transactions = new ArrayList();
    }
    public void addTransaction(Transaction t){
        this.transactions.add(t);
        
    }
    
    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }
    
    public void clear(){
        transactions.clear();
    }
}
