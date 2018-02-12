package com.mr.kangaroo.strings;

import java.util.BitSet;
import java.util.StringTokenizer;

public class StringUtils {

    private static final char SPACE = ' ';

    /**
     * 翻转字符串，遍历字符串字符拼接；
     *
     * @param  string [description]
     * @return [description]
     */
    public static final String reverseWithStringConcat(String string) {
        int len = string.length();
        char[] chars = new char[string.length()];
        for (int i = len - 1; i >= 0; i--) {
            chars[len - i] = string.charAt(i);
        }
        return String.valueOf(chars);
    }

    /**
     * 翻转字符串，利用StringBuilder的reverse()方法；
     *
     * @param  string [description]
     * @return [description]
     */
    public static final String reverseWithStringBuilderMethod(String string) {
        StringBuilder builder = new StringBuilder(string);
        return builder.reverse().toString();
    }

    /**
     * 翻转字符串，利用二分法将字符串的前半部分和对称的后半部分交换；
     *
     * @param  string [description]
     * @return [description]
     */
    public static final String reverseWithSwaps(String string) {
        char[] charArray = string.toCharArray();
        int len = charArray.length;
        int mid = (int) Math.floor(charArray.length / 2);
        char c;
        for (int i = len - 1; i >= mid; i--) {
            c = charArray[i];
            charArray[i] = charArray[len - i];
            charArray[len - i] = c;
        }
        return String.valueOf(charArray);
    }

    /**
     * [reverseWithXOR description]
     *
     * @param  string [description]
     * @return [description]
     */
    public static final String reverseWithXOR(String string) {
        char[] array = string.toCharArray();
        int length = array.length;
        int half = (int) Math.floor(array.length / 2);
        for (int i = 0; i < half; i++) {
            array[i] ^= array[length - i - 1];
            array[length - i - 1] ^= array[i];
            array[i] ^= array[length - i - 1];
        }
        return String.valueOf(array);
    }

    public static final String reverseWordsByCharWithAdditionalStorage(String string) {
        StringBuilder builder = new StringBuilder();

        char c = 0;
        int index = 0;
        int last = string.length();
        int length = string.length() - 1;
        StringBuilder temp = new StringBuilder();
        for (int i = length; i >= 0; i--) {
            c = string.charAt(i);
            if (c == SPACE || i == 0) {
                index = (i == 0) ? 0 : i + 1;
                temp.append(string.substring(index, last));
                if (index != 0)
                    temp.append(c);
                builder.append(temp);
                temp.delete(0, temp.length());
                last = i;
            }
        }

        return builder.toString();
    }

    public static final String reverseWordsWithTwoCursorFlag(String string) {
        int cursorA = string.length() - 1;
        int cursorB = 0;
        StringBuilder builder = new StringBuilder();
        StringBuilder tmpBuilder = new StringBuilder();
        for (int i = cursorA; i >= 0; i--) {
            char c;
            if ((c = string.charAt(i)) == SPACE || i == 0) {
                cursorB = (i == 0) ? i : i + 1;
                tmpBuilder.append(string.substring(cursorB, cursorA + 1));
                if (cursorB != 0)
                    tmpBuilder.append(c);
                builder.append(tmpBuilder);
                tmpBuilder.delete(0, tmpBuilder.length());
                cursorA = i;
            }
        }
        return builder.toString();
    }

    public static final String reverseWordsUsingStringTokenizer(String string) {
        StringBuilder builder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(string);
        while (st.hasMoreElements()) {
            builder.append(st.nextToken()).append(" ");
        }
        return builder.toString();
    }

    public static final String reverseWordsUsingSplit(String string) {
        StringBuilder builder = new StringBuilder();
        String[] tmp = string.split("\\s*");
        for (int i = (tmp.length - 1); i >= 0; i--) {
            builder.append(tmp[i]).append(" ");
        }
        return builder.toString();
    }

    /**
     * 是否是回文；
     *
     * @param string
     * @return
     */
    public static final boolean isPalindrom(String string) {
        String reverse = new StringBuilder(string).reverse().toString();
        return string.equals(reverse);
    }

    public static final boolean isPalindromUsingIterator(String string) {
        char[] array = string.toCharArray();
        int len = array.length - 1;
        int mid = Math.round(array.length / 2);
        for (int i = array.length; i >= mid; i--) {
            if (array[i] != array[len - i]) {
                return false;
            }
        }
        return true;
    }

    public static final String[] generateSubsets(String string) {
        final int len = string.length();
        final int size = (int) Math.pow(2, len);
        final BitSet[] sets = new BitSet[size];
        final String[] output = new String[size];
        for (int i = 0; i < size; i++) {
            final BitSet set = new BitSet(size);
            final StringBuilder builder = new StringBuilder();
            if (i > 0) {
                for (int j = len - 1; j >= 0; j--) {
                    if (j == len - 1) {
                        if (i % 2 != 0) {
                            set.set(j, true);
                        }
                    } else {
                        boolean prev = sets[i - 1].get(j);
                        boolean next = true;
                        for (int k = j + 1; k < len; k++) {
                            next = next && sets[i - 1].get(k);
                        }
                        if (next)
                            prev = !prev;
                        set.set(j, prev);
                    }
                    if (set.get(j)) {
                        builder.append(string.charAt(j));
                    }
                }
            }
            sets[i] = set;
            output[i] = builder.toString();
        }
        return output;
    }
}
