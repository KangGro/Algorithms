package com.mr.kangaroo.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密类
 * 
 */
public class MD5 {

	/**
	 * 返回经MD5加密后的密文
	 */
	public static String getSecurityKey(String str) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes("utf-8"));
			byte b[] = md.digest();

			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString();
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
