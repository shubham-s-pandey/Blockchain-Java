import java.util.*;
public class Block {
	
	private String previousHash;
	private String currentBlockHash;
	private String data;
	private long timestamp;
	private int nonce;
    public Block(String previousHash, String data) {
	
	this.previousHash = previousHash;
	this.data = data;
	this.timestamp = new Date().getTime();
    this.currentBlockHash = calculateHash();	
}
    private String calculateHash()  {
    	String calculateHash =UtilityClass.getSHA256Hash(
    			previousHash+data+Long.toString(timestamp)+ 
    			Integer.toString(nonce)
    			);
    	return calculateHash;
    }
    
	public void mineBlock(int difficulty) {

		String target = UtilityClass.getDifficultyString(difficulty);
		
		while(!currentBlockHash.substring(0, difficulty).equals(target))
        {
        	nonce++;
        	currentBlockHash=calculateHash();
            
        	
	    }

		System.out.println("Block MIned"+currentBlockHash);

		
		
	}
}
