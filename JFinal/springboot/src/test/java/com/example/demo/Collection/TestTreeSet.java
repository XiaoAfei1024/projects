package com.example.demo.Collection;

import com.example.demo.domain.City;
import org.junit.Test;

import java.util.TreeSet;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/28/028 10:20
 * @Version 1.0
 */
public class TestTreeSet {
    @Test
    public void test1(){
        TreeSet<Err> cityTreeSet = new TreeSet<>();
        cityTreeSet.add(new Err());
        cityTreeSet.add(new Err());
        System.out.println(cityTreeSet);

        
    }
}

class Err implements Comparable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
