/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.security.MessageDigest;
import utils.DigitalSignature;
import utils.HashUtils;

/**
 *
 * @author pwightman
 */
public class Transaction {

    String from_address;
    String to_address;
    String[] data;
    String hash;
    String signature;

    Transaction(String from_address, String to_address, String[] data) {
        this.from_address = from_address;
        this.to_address = to_address;
        this.data = data;
        this.hash = HashUtils.calculateHash(this.toString4Hash());
    }
    
    public void signTransaction(String privateKey){
        DigitalSignature.sign(this, privateKey);
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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
    //Taken from:
    //https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java

    public String toString4Hash() {
        StringBuffer s = new StringBuffer();
        s.append(from_address);
        s.append(to_address);
        s.append(data);
        return s.toString();
    }

    public void setSignature(String sig) {
        this.signature = sig;
    }
    public String getSignature(String sig) {
        return this.signature;
    }

}
