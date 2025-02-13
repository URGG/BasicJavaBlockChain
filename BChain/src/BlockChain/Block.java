package BlockChain;
import java.util.Date;
import com.google.gson.GsonBuilder;

public class Block {

    public String hash;
    public String previousHash;
    private String data;
    private long timeStammp;


    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStammp = new Date().getTime();
    }

    public String calculateHash(){
        String calculatedhash = StringUtil.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				Integer.toString(nonce) + 
				data 
				);
		return calculatedhash;
    }

    public void mineBlock(int difficulty){
        String target = StringUtil.getDifficultyString(difficulty);
            while(!hash.substring(0, difficulty).equals(target)){
                nonce++;
                hash = calculateHash();
            }

            System.out.println("Block mined" + hash);

    }
     

}
