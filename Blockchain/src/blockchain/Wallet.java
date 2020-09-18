package blockchain;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import utils.DigitalSignature;
public class Wallet {
    public String publicKey;
    private String privateKey;
    private Miner miner;
    
    public Wallet() {
        KeyPair keyPair = DigitalSignature.generateKeyPair();
        this.publicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
        this.privateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
    }
    public void generateTransaction(String destinationAddress, String data){
        Transaction tx = new Transaction(this.publicKey, destinationAddress, new String[]{data});
        //Sign Transaction        
        tx.signTransaction(this.privateKey);
        sendTransaction(tx);
    }
    public void sendTransaction(Transaction tx){
        this.miner.reciveTransaction(tx);
    }

    public Miner getMiner() {
        return miner;
    }

    public void setMiner(Miner miner) {
        this.miner = miner;
    }
    
}
