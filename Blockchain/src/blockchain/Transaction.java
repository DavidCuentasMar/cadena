/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

/**
 *
 * @author pwightman
 */
public class Transaction {
    String from_address;
    String to_address;
    String[] data;
    String hash;
    
    String dig_sign;

    Transaction(String from_address, String to_address, String[] data) {
        this.from_address = from_address;
        this.to_address = to_address;
        this.data = data;
        //generar hash
        //firma
    }


    public String getFrom_address() {
        return from_address;
    }

    public String getTo_address() {
        return to_address;
    }

    public String[] getData() {
        return data;
    }

}
