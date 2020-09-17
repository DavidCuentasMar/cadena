/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.security.MessageDigest;

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
        this.hash = this.calculateHash(this.toString4Hash());
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getDig_sign() {
        return dig_sign;
    }

    public void setDig_sign(String dig_sign) {
        this.dig_sign = dig_sign;
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

    public String calculateHash(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String toString4Hash() {
        StringBuffer s = new StringBuffer();
        s.append(from_address);
        s.append(to_address);
        s.append(data);
        return s.toString();
    }

}
