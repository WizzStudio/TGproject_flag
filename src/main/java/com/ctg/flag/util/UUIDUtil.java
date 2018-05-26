package com.ctg.flag.util;

import java.util.UUID;

public class UUIDUtil {
	public static String getRandomId() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	public static String getRandomCode() {
		return getRandomId();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			String a = getRandomCode().substring(0, 8);
			System.out.println("xdxhadmin" + (i+1) + " | " + a);
		}
	}

}
