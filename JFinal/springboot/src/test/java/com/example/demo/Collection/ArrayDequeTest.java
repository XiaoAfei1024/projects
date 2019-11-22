package com.example.demo.Collection;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/10/010 14:54
 * @Version 1.0
 */
public class ArrayDequeTest {

    @Test
    public void test() {
        //队列
        ArrayDeque<String> queue = new ArrayDeque();
        queue.offer("1111");
        queue.offer("2222");
        queue.offer("3333");
        queue.offer("4444");
        queue.offer("5555");
        //获取
        System.out.println(queue.peek());
        System.out.println(queue);
        //出队
        System.out.println(queue.poll());
        System.out.println(queue);
    }

    @Test
    public void testStack() {
        //栈
        ArrayDeque<String> stack = new ArrayDeque();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack);
        //获取最后添加的元素,但不删除
        System.out.println(stack.peek());
        System.out.println(stack);
        //弹出最后添加的元素
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    @Test
    public void testLinkedList() {
        //双向链表
        LinkedList<String> list = new LinkedList<>();
        //入队
        list.offer("1");
        //压栈
        list.push("2");
        //在另一端入队
        list.addFirst("3");
        list.forEach(s -> System.out.println(s));
        System.out.println(list);
        //获取队头
        System.out.println(list.peekFirst());
        //获取队尾
        System.out.println(list.peekLast());

        //弹栈
        System.out.println(list.pop());
        System.out.println(list);
        //双端的后端出列
        System.out.println(list.pollLast());
        System.out.println(list);
    }

    @Test
    public void testPriorityQueue() {
        //有序队列
        PriorityQueue<Integer> queue = new PriorityQueue(10);
        Random rand = new Random();
        for (int i = 0; i < queue.size(); i++) {
            queue.offer(rand.nextInt(90) + 10);
        }
        System.out.println(queue);
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.poll() + " , ");
        }
    }

    @Test
    public void test1() throws ParseException, InterruptedException {
//如果想比较日期则写成"yyyy-MM-dd"就可以了
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String t1 = "2012-11-30 16:11:16";
        String t2 = "2012-11-30 16:18:18";
        //将字符串形式的时间转化为Date类型的时间
        Date a = new Date();
        Thread.sleep(1000);
        Date b = new Date();
        //Date类的一个方法，如果a早于b返回true，否则返回false
        if (a.before(b)) {
            System.out.println(true);
        } else {
            System.out.println(false);

        }
    }
}
