package com.hm.rms.util;

public class EncryptUtilTest {

	public static void main(String[] args) {
		String str="admin 1";
		EncryptUtil eu=new EncryptUtil();
		System.out.println(eu.SHA512(str));
		System.out.println(eu.MD5(str));
		System.out.println(eu.SHA256(str));
	}

}
