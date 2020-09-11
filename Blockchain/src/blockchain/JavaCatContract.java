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
public class JavaCatContract extends JavaContract{
    
    public static HashMap<String, Double> balances; 
    public String owner;
    
    public JavaCatContract(String owner, Double capital) {
        this.balances = new HashMap<String, Double>();
        this.owner = owner;
        balances.put(owner,capital);
    }

    @Override
    public boolean ejecutar(Transaction tx) {
        try{
            if(balances.get(tx.from_address) < Double.parseDouble(tx.data[1])) return false;
            if(balances.get(tx.data[0]) == null) balances.put(tx.data[0],0.0);
            balances.put(tx.from_address, balances.get(tx.from_address) - Double.parseDouble(tx.data[1]));
            balances.put(tx.data[0], balances.get(tx.data[0]) + Double.parseDouble(tx.data[1]));
            return true;
        }catch(Exception e) {
            return false;
        }
    }
    
}
