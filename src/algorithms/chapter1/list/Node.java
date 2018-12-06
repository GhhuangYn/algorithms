package algorithms.chapter1.list;

/**
 * @Description: 链表的节点
 * @author: HuangYn
 * @date: 2018/12/6 17:21
 */
public class Node<T> {

    public T item;
    public Node<T> next;   //指向下一个节点

    public Node() {

    }

    public Node(T item) {
        this.item = item;
    }

}
