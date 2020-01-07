package stack;

import java.io.File;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/12/18/018 11:36
 * @Version 1.0
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static  final  int DEFAULT_INITIAL_CAPACITY = 16;
    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }
    public Object newPop() {
        if (size == 0) throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }
    //此方法会造成内存泄漏（无意识的对象保持）
    public Object pop() {
        if (size == 0) throw new EmptyStackException();
        return elements[--size];
    }
    private void ensureCapacity() {
        if(elements.length == size) elements = Arrays.copyOf(elements,2*size + 1);
    }
}
