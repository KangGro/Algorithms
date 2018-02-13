package com.mr.kangaroo.strings;

import java.util.Arrays;

/**
 * @author daisy
 * @desc
 * @create 2018/2/13
 */
public class StringReplace {

    public static int countReplace(String src, String target) {
        int result = 0;
        char[] srcChars = src.toCharArray();
        char[] targetChars = target.toCharArray();
        int targetLen = targetChars.length;
        int srcIndex = 0;
        while (srcIndex + targetLen < srcChars.length - 1) {
            int counter = 0;
            for (int i = 0; i < targetLen; i++) {
                if (srcChars[srcIndex + i] == targetChars[i]) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter == targetLen) {
                srcIndex = srcIndex + targetLen;
                result++;
            } else {
                srcIndex++;
            }
        }
        return result;
    }

    public static void replace(String src, String target, String replace) {
        if (src == null || src.length() == 0 || target == null || target.length() == 0 || replace == null || replace.length() == 0) {
            return;
        }
        char[] targetChars = target.toCharArray();
        char[] replaceChars = replace.toCharArray();
        char[] srcChars = src.toCharArray();
        int count = countReplace(src, target);
        if (replace.length() - target.length() > 0) {
            char[] destChars = new char[src.length() + (replace.length() - target.length()) * count];
            System.arraycopy(srcChars, 0, destChars, 0, srcChars.length);
            int p1 = srcChars.length - 1;
            int p2 = destChars.length - 1;
            while (p2 >= p1 && p1 >= 0) {
                int flag = 0;
                for (int i = 0; i < targetChars.length; i++) {
                    if (srcChars[p1 - i] == targetChars[targetChars.length - i - 1]) {
                        flag++;
                    } else {
                        break;
                    }
                }
                if (flag == targetChars.length) {
                    p1 = p1 - (targetChars.length);
                    for (int j = 0; j < replaceChars.length; j++) {
                        destChars[p2 - j] = replaceChars[replaceChars.length - j - 1];
                    }
                    p2 = p2 - replaceChars.length;
                } else {
                    destChars[p2--] = srcChars[p1--];
                }
            }
            System.out.println(Arrays.toString(destChars));
        } else {
            int len = srcChars.length + (replaceChars.length - targetChars.length) * count;
            int p1 = 0;
            int p2 = 0;
            while (p1 <= len) {
                int flag = 0;
                for (int i = 0; i < targetChars.length; i++) {
                    if (srcChars[p1 + i] == targetChars[i]) {
                        flag++;
                    } else {
                        break;
                    }
                }
                if (flag == targetChars.length) {
                    for (int j = 0; j < replaceChars.length; j++) {
                        srcChars[p1 + j] = replaceChars[j];
                    }
                    p2 = p1 + targetChars.length;
                    p1 = p1 + replaceChars.length;
                    int index = p1;
                    while (p2 < srcChars.length) {
                        srcChars[index++] = srcChars[p2++];
                    }
                    srcChars[srcChars.length - 1] = 0;
                } else {
                    p1++;
                }
            }
            System.out.println(Arrays.toString(srcChars));
        }
    }

    public static void main(String[] args) {
        String src = "qwqsdas gfgsdasa";
        System.out.println(Arrays.toString(src.toCharArray()));
        System.out.println(countReplace(src, "sd"));
        replace(src,"sd","XXX");
        System.out.println("------------------");
        replace(src,"sd","Y");
    }
}
