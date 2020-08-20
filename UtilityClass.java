import java.security.MessageDigest;

public class UtilityClass {

	private static final byte Oxff = 0;


	public static String getDifficultyString(int difficulty) {
		
		return new String(new char[difficulty]).replace('\0', '0');
	}
	
	
	public static String getSHA256Hash(String inputString) {
		
		try
		{
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        
			
			byte[] hash = digest.digest(inputString.getBytes("UTF-8"));
	        
			StringBuffer hexString = new StringBuffer(); 
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}

}