package com.mr.kangaroo.strMatch;

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
	 * "部分匹配值"就是"前缀"和"后缀"的最长的共有元素的长度;
	 * 根据部分匹配值来确定移动的字符数， 已匹配的字符数 - 对应的部分匹配表中的值;
	 * ABCDABD
	 * 0000120
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
				int j = 0;
				while(j < i){
					String prefix = pattern.substring(0, j + 1);
					String sufix = pattern.substring(i -j,i+1);
					if(prefix.equals(sufix)){
						if(prefix.length() > val){
							val = prefix.length();
						}
					}
					j++;
				}
				next[i] = val;
			}
		}
		return next;
	}
	
	public static void kmpMatcher(String sourceString){
		int[] next = partitionMatchTable(patternString);
		int i = 0 , j = 0;
		String[] source = sourceString.split("");
		String[] pattern = patternString.split("");
		int pos = 0;
		while(i < sourceString.length() && j < patternString.length()){
			if(source[i].equals(pattern[j]) || j == 0){
				++i;
				++j;
			}else{
				j = next[j];
			}
		}
		if(j > patternString.length()){
			pos = i - patternString.length() + 1;
		}
		System.out.println(pos);
	}
	
	public static void main(String[] args) {
		kmpMatcher(sourceString);
	}
}
