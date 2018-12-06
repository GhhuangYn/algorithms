package algorithms.chapter1.queue;

import algorithms.chapter1.list.Node;

/**
 * @Description:        使用链表实现队列
 * @author: HuangYn
 * @date: 2018/12/6 20:50
 */
public class MyQueue<T> {

    private Node<T> first;      //第一个元素
    private Node<T> last;       //最后一个元素
    private int N;              //元素个数

    private boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(T item) {
        Node<T> oldLast = last;
        last = new Node<>(item);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public T dequeue() {

        if (!isEmpty()) {
            Node<T> node = first;
            first = first.next;
            N--;
            return node.item;
        }
        System.out.println("队列为空!");
        return null;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
