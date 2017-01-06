package com.mr.kangaroo.strings;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
	@Test
	public void reverseWithXORTest(){
		String string = "abcdefg";
		Assert.assertSame("same string", StringUtils.reverseWithXOR(string), "gfedcba");
	}
	
	
	public static void main(String[] args) {
		int a = 10;
		int b = 12;
		
		a ^= b;
		b ^= a;
		a ^= b;
		
		System.out.println("a="+ a +" , b=" + b);
	}
	
}
