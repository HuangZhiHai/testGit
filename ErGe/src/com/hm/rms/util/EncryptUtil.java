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
			//单项加密类
			MessageDigest md=
				MessageDigest.getInstance(type);
			//加密数据
			md.update(text.getBytes());
			//返回加密之后的字节数组
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
