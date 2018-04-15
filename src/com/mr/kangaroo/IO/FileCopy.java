package com.mr.kangaroo.IO;

import java.io.*;

/**
 * @author daisy
 * @desc 文件及文件夹拷贝
 * @create 2018/4/15
 */
public class FileCopy {
    public static void copyDirectory(String path, String destPath) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        String newPath = destPath;
        if (file.isDirectory()) {
            newPath  = newPath + "Copy";
            File newFile = new File(newPath);
            if(!newFile.exists()){
                newFile.mkdirs();
            }
            File[] files = file.listFiles();
            for (File tmp : files) {
                String tmpAbsolutePath = tmp.getAbsolutePath();
                copyDirectory(tmpAbsolutePath, newPath);
            }
        } else {
            copyFile(file, newPath);
        }
    }

    public static void copyFile(File file, String filePath) throws IOException {
        String newFileName;
        String fileName = file.getName();
        if (fileName.indexOf(".") > 0) {
            newFileName = fileName.substring(0, fileName.lastIndexOf(".")) + "Copy" + fileName.substring(fileName.lastIndexOf("."));
        } else {
            newFileName = fileName + "Copy";
        }
        File newFile = new File(filePath + "/" + newFileName);
        System.out.println(newFile);
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
        copyDirectory("/Users/mr-kangaroo/work/axure", "/Users/mr-kangaroo/work/axure");
    }
}
