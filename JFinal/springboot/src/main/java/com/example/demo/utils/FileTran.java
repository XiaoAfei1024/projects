package com.example.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2020/2/20/020 9:43
 * @Version 1.0
 */
public class FileTran {

    /**
     * @Title: getBytes
     * @Description: 文件转换为byte数组
     * @param filePath
     * @return byte[]
     * @Vesion v1.0
     * @throws
     */
    public static byte[] getBytes(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * @Title: createFile
     * @Description: 创建文件
     * @param :data 	文件轉換成的數組
     * @param filePath 	臨時存儲文件目錄
     * @param fileName 	文件名
     * @Vesion v1.0
     * @return: void
     * @throws
     */
    public static void createFile(byte[] data, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists()) {// 判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * @Title: createFile
     * @Description: 创建文件
     * @param :data 	文件轉換成的數組
     * @param filePath 	臨時存儲文件目錄
     * @param fileName 	文件名
     * @Vesion v1.0
     * @return: void
     * @throws
     */
    public static File createAndReturnFile(byte[] data, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists()) {// 判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return file;
    }

    /**
     * @Title: deleteFile
     * @Description: 刪除文件
     * @param: @param fileRealPath	文件全路徑
     * @param: @return
     * @Vesion v1.0
     * @return: boolean
     * @throws
     */
    public static boolean deleteFile(String fileRealPath) {
        File file = new File(fileRealPath);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + fileRealPath + "不存在！");
            return false;
        }
        return file.delete();
    }

    /**
     * @Title: deleteDir
     * @Description: 遞歸刪除文件夾
     * @param: @param file	需要刪除的文件夾
     * @param: @return
     * @Vesion v1.0
     * @return: boolean
     * @throws
     */
    public static void deleteDir(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles())
                deleteDir(f);
        }
        file.delete();
    }


    /**
     * @Title: createDir
     * @Description: 创建文件夹
     * @param: @param path
     * @param: @return
     * @Vesion v1.0
     * @return: boolean
     * @throws
     */
    public static boolean createDir(String path) {
        if(StringUtils.isBlank(path)) {
            return false;
        }
        File file = new File(path);
        if(!file.exists()) {
            file.mkdir();
        }
        return true;
    }
}

