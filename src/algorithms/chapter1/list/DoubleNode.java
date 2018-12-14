package algorithms.chapter1.list;

/**
 * @Description: 双向链表的节点
 * @author: HuangYn
 * @date: 2018/12/14 17:29
 */
public class DoubleNode<T> {

    public DoubleNode<T> prev;
    public DoubleNode<T> next;
    public T item;

    public DoubleNode() {
    }

    public DoubleNode(T item) {
        this.item = item;
    }

}
