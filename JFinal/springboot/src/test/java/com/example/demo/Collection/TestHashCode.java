package com.example.demo.Collection;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/24/024 15:40
 * @Version 1.0
 */
@Getter
@Setter
public class TestHashCode {
    private int count;

    public TestHashCode(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "count:" + this.count + "  hashCode" + this.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj != null && obj.getClass() == TestHashCode.class) {
            TestHashCode hashCode = (TestHashCode)obj;
            return this.count == hashCode.count;
        }
        return false;
    }

/*    @Override
    public int hashCode() {
        return this.count;
    }*/

    public static void main(String[] args) {
        /**
         * @description 调用元素HashCode获得哈希码--》判断哈希码是否相等，不相等则录入
         *              ---》相等则判断equals()后是否相等，不相等在进行 hashcode录入，相等不录入
         */
        HashSet<TestHashCode> set = new HashSet();
        set.add(new TestHashCode(1));
        set.add(new TestHashCode(5));
        set.add(new TestHashCode(2));
        set.add(new TestHashCode(4));
        set.add(new TestHashCode(1));
        System.out.println(set.contains(new TestHashCode(1)));
        System.out.println(set);
    }
}
