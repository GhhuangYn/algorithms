package algorithms.chapter1.stack.test;

import algorithms.chapter1.queue.MyQueue;

import java.util.Iterator;

/**
 * @Description: 编写一个Queue用理，接收参数k并输出倒数第k个字符串
 * @author: HuangYn
 * @date: 2018/12/14 10:54
 */
public class Test1_3_15 {

    public static void main(String[] args) {

        MyQueue<String> queue = new MyQueue<>();
        for (int i = 0; i < 10; i++) queue.enqueue("hello_" + i);
        int k = 4;
        if (k > queue.size()) System.exit(-1);
        int i = 0, total = queue.size();
        Iterator<String> iterator = queue.iterator();
        while (total - i > k && iterator.hasNext()) {
            iterator.next();
            i++;
        }
        iterator.forEachRemaining(System.out::println);
    }
}
