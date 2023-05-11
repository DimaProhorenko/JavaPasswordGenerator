package pg;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Encryptor {
	private String setting = "DES";
	private KeyGenerator keyGenerator;
	private SecretKey key;
	private Cipher desCipher;
	
	public Encryptor() {
		try {
			keyGenerator = KeyGenerator.getInstance(setting);
			key = keyGenerator.generateKey();
			desCipher = Cipher.getInstance(setting);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public String encrypt(String s) {
		String encryptedString = "";
		try {
			byte[] text = s.getBytes("UTF8");
			desCipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] textEncrypted = desCipher.doFinal(text);
			encryptedString = new String(textEncrypted);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encryptedString;
		
	}
	
	public String decrypt(String s) {
		String decrypted = "";
		try {
			desCipher.init(Cipher.DECRYPT_MODE, key);
			byte[] textDecrypted = desCipher.doFinal(s.getBytes("YTF8"));
			decrypted = new String(textDecrypted);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		return decrypted;
	}
}
