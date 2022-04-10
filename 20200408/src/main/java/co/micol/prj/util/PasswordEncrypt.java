package co.micol.prj.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service("pEncrypt")
//@Component도 가능.
public class PasswordEncrypt {
	MessageDigest md;
	String str;
	
	public String pe(String password) {
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			str = String.format("%064x", new BigInteger(1, md.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return str;
	
	}
}
