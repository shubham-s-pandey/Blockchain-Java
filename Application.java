import java.util.ArrayList;
import java.util.List;


public class Application {

	
	public static List<Block> blockchain = new ArrayList<Block>();
	
	final static int difficulty=4;
	
	public static void main(String[] args) {

		
		System.out.println("Create Genesis Block");
		addBlock(new Block("0", "This is first transaction"));
	}
	
	private static void addBlock(Block newBlock) {
	
		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);
		System.out.println("Block added to new block");
	}
	

}
