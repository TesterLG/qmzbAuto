package com.huice.Interface;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//http://tool.oschina.net/encrypt?type=2
public final class Md5Tool {
	private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	private static Md5Tool instance = null;

	private Md5Tool() {
	}

	public static void main(String[] args) {
		System.out.println(new Md5Tool().SHA1("md5", "UTF-8"));
	}
	
	public synchronized static Md5Tool getInstance() {
		if (instance == null) {
			instance = new Md5Tool();
		}
		return instance;
	}

	public String getShortToken(String source, String CharSet) {
		return encoder(source, CharSet).substring(8, 24);
	}

	public String getLongToken(String source, String CharSet) {
		return encoder(source, CharSet).toString();
	}

	public String SHA1(String source, String CharSet) {
		try {
			MessageDigest digest = MessageDigest
					.getInstance("SHA-1");
			digest.update(source.getBytes(CharSet));
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private StringBuffer encoder(String source, String CharSet) {
		if (source == null) {
			source = "";
		}
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(source.getBytes(CharSet));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toHex(md5.digest());
	}

	private StringBuffer toHex(byte[] bytes) {
		StringBuffer str = new StringBuffer(32);
		int length = bytes.length;
		for (int i = 0; i < length; i++) {
			str.append(hexDigits[(bytes[i] & 0xf0) >> 4]);
			str.append(hexDigits[bytes[i] & 0x0f]);
		}
		bytes = null;
		return str;
	}
	
}
