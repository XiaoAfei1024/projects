package com.example.demo;

import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.springframework.util.FileCopyUtils.BUFFER_SIZE;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/6/20/020 13:13
 * @Version 1.0
 */
public class TestList {
    @Test
    public void testSort() {

        //输入的数组
        Integer[] integers = {6, 5, 11, 1, 8, 7, 88, 77, 88};
        List<Integer> list = Arrays.asList(integers);
        //小->大排序
        list.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(list);
    }

    @Test
    public void test() {
        int count = 0;
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            for (int j = 0; j < 100; j++) {
                Map<Integer, String> map = new HashMap<>();
                map.put(i + j, "test");
                count++;
            }
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("外大內小" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10000000; j++) {
                Map<Integer, String> map = new HashMap<>();
                map.put(i + j, "test2");
                count++;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("外小內大" + (endTime - startTime));
    }



    /**
     * try-finally
     * @param src
     * @param dst
     * @throws IOException
     * 调试不方便
     */
    public static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    //try-with-resources ：代码简洁易懂，容易对异常进行诊断
    public static void newCopy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)
        ) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }


}
