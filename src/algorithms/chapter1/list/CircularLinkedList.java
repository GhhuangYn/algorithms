package algorithms.chapter1.list;

import java.util.Iterator;

/**
 * @Description: 实现循环链表
 * @author: HuangYn
 * @date: 2018/12/14 14:29
 */
public class CircularLinkedList<T> implements Iterable<T> {

    private Node<T> last;   //指向链表末尾
    private int N = 0;          //元素个数

    public CircularLinkedList() {

    }

    private boolean isEmpty() {
        return N == 0;
    }

    public void insert(T item) {

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

    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public T next() {
                T item = last.next.item;
                last = last.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {

        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.iterator().forEachRemaining(System.out::println);

    }


}
