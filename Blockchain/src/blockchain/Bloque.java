/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import utils.HashUtils;

/**
 *
 * @author super
 */
public class Bloque {
    
    int idCadena;
    int index;
    LocalDateTime timestamp;
    ArrayList<Transaction> transactions;
    String previousHash;
    String hash;
    int nonce;
    Random r;

    public Bloque(int index, LocalDateTime timestamp, ArrayList transactions, String previousHash) {
        this(index, timestamp, transactions, previousHash, Blockchain.DIFFICULTY);
    }
    
    public Bloque(int index, LocalDateTime timestamp, ArrayList transactions, String previousHash, int difficulty) {
        r = new Random();
        this.index = index;
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.nonce = r.nextInt();
        this.hash = HashUtils.calculateHash(this.toString4Hash());
        validate(difficulty);
    }

    public void renonce(){
        this.nonce = r.nextInt();
    }
    
    public void rehash(){
        this.hash = HashUtils.calculateHash(toString4Hash());
    }
    
    public String getDifficultyString(int difficulty){
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < difficulty; i++) {
            s.append("0");
        }
        return s.toString();
    }
    
    public String validate(int difficulty){
        int j=0;
        String s = getDifficultyString(difficulty);
        
        while(!(hash.substring(0, difficulty).startsWith(s))){
            renonce(); //Finde a new nonce
            rehash();  //Recalculate the hash value
            j++;
        }
        System.out.println(j+" intentos");
        return hash;
    }
    
    public boolean verifyHash(int difficulty){
        
        if(this.hash.equals(HashUtils.calculateHash(this.toString4Hash())))
            return true;
        
        return false;
    }
    
    public String toString4Hash(){
        StringBuffer s = new StringBuffer();
        s.append(index);
        s.append(timestamp);
        s.append(transactions);
        s.append(previousHash);
        s.append(nonce);
        return s.toString();
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }



    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }
   
    public String toString(){
        StringBuffer s = new StringBuffer();
        
        s.append(index); s.append("\t");
        s.append(timestamp); s.append("\t");
        s.append(transactions); s.append("\t");
        s.append(this.previousHash); s.append("\t");
        s.append(nonce); s.append("\t");
        s.append(hash);
        
        return s.toString();
    }
    
    
}
