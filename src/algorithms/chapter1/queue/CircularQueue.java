package algorithms.chapter1.queue;

import algorithms.chapter1.list.Node;

/**
 * @Description: 链表实现双向列表
 * @author: HuangYn
 * @date: 2018/12/14 15:54
 */
public class CircularQueue<T> {

    private Node<T> last;
    private int N = 0;

    public CircularQueue() {
    }

    public void enqueue(T item) {

        Node<T> node = new Node<>(item);
        if (N == 0) {
            last = node;
            last.next = last;
        } else {
            Node<T> oldLast = last;
            node.next = oldLast.next;
            oldLast.next = node;
            last = node;
        }
        N++;
    }

    public T dequeue() {
        if (N == 0) return null;
        T item = last.next.item;
        last.next = last.next.next;
        N--;
        return item;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {

        CircularQueue<Integer> queue = new CircularQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
