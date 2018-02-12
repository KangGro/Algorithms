package com.mr.kangaroo.strings;

import java.util.Arrays;
import java.util.BitSet;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
    @Test
    public void reverseWithXORTest() {
        String string = "abcdefg";
        Assert.assertSame("same string", StringUtils.reverseWithXOR(string), "gfedcba");
    }

    @Test
    public void reverseWordsWithTwoCursorFlagTest() {
        String string = "same string ";
        Assert.assertSame("same string", StringUtils.reverseWordsWithTwoCursorFlag(string), " string same ");
    }

    public static void main(String[] args) {
//		String ss = StringUtils.reverseWordsWithTwoCursorFlag("asas mnhg pojj s   ");
//		System.out.println(ss);

        String string = "abc";

        System.out.println(Arrays.toString(StringUtils.generateSubsets(string)));
        int[] s = {32, 63, 72, 100, 111, 117, 119, 121, 20320, 21568};

        BitSet bitset = new BitSet(22909);

        for (int i = 0; i < s.length; i++) {
            bitset.set(s[i]);
        }
        System.out.println(bitset.size());

    }
}
