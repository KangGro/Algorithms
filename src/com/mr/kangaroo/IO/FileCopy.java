package com.mr.kangaroo.IO;

import java.io.*;

/**
 * @author daisy
 * @desc 文件及文件夹拷贝
 *
 * 目录的遍历
 * 树的遍历
 * 二叉树的遍历
 *
 *
 *
 * @create 2018/4/15
 */
public class FileCopy {
    public static void copyDirectory(String from,String to) throws IOException {
        File file = new File(from);
        if (!file.exists()) {
            return;
        }
        String dirPath = file.getAbsolutePath();
        dirPath = dirPath.replace("/Users/mr-kangaroo/test/dir1", to);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if(files.length == 0){
                File dir = new File(dirPath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
            }
            for (File tmp : files) {
                copyDirectory(tmp.getAbsolutePath(), to);
            }
        } else {
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            copyFile(file, dirPath);
        }
    }

    public static void copyFile(File file, String filePath) throws IOException {
        String newFileName;
        String fileName = file.getName();
        if (fileName.indexOf(".") > 0) {
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            newFileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.lastIndexOf(".")) + "Copy" + suffix;
        } else {
            newFileName = fileName + "Copy";
        }
        File newFile = new File(filePath + "/" + newFileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        char[] buffer = new char[1024];
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
        int len;
        while ((len = reader.read(buffer)) > 0) {
            writer.write(buffer, 0, len);
        }
        reader.close();
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        copyDirectory("/Users/mr-kangaroo/test/dir1", "/Users/mr-kangaroo/test/dir1Copy");
    }
}
