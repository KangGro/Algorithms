package com.mr.kangaroo.strMatch;

import java.util.Arrays;

/**
 * 串匹配算法;
 * 
 * next数组,部分匹配表理解:
 * 
 * http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 * @author admin
 */
public class KMPMatch {
	private static String sourceString = "abcffasaabcdassdaasdbabcabcaacdabcdllafdaasaabcd";
	private static String patternString = "abcabcaa";
	
	/**
	 * 根據模式串生成部分匹配表;
	 * @param pattern
	 * @return
	 */
	public static int[] partitionMatchTable(String pattern){
		if(pattern != null && pattern.length() == 0) return null;
		int[] next = new int[pattern.length()];
		for (int i = 0; i < pattern.length(); i++) {
			if(i == 0){
				next[i] = 0;
			}else{
				int val = 0;
				int j = 0,k = i - 1;
				while(j < i && k >=0){
					if(pattern.substring(0, j+1).equals(pattern.substring(k))){
						val++;
					}
				}
				next[i] = val;
				j++;
				k--;
			}
		}
		return next;
	}
	
	public static void kmpMatcher(String sourceString){
		int[] next = partitionMatchTable(patternString);
		System.out.println(Arrays.toString(next));
	}
	
	public static void main(String[] args) {
		kmpMatcher(sourceString);
	}
}
