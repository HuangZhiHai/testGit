package com.hm.rms.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
	
	public String SHA256(String text){
		return SHA(text,"SHA-256");
	}
	
	public String SHA512(String text){
		return SHA(text,"SHA-512");
	}
	
	public String MD5(String text){
		return SHA(text,"MD5");
	}
	
	public String SHA(String text,String type){
		String result="";
		
		try {
			//���������
			MessageDigest md=
				MessageDigest.getInstance(type);
			//��������
			md.update(text.getBytes());
			//���ؼ���֮����ֽ�����
			byte[] bs=md.digest();
			for(byte b : bs){
				result+=String.format("%02x", b);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
}
