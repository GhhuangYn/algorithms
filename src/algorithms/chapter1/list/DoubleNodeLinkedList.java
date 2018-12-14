package algorithms.chapter1.list;

/**
 * @Description:
 * @author: HuangYn
 * @date: 2018/12/14 17:31
 */
public class DoubleNodeLinkedList {

    public static void main(String[] args) {

        //构造双向链表
        DoubleNode<String> node1 = new DoubleNode<>("node1");
        DoubleNode<String> node2 = new DoubleNode<>("node2");
        DoubleNode<String> node3 = new DoubleNode<>("node3");
        DoubleNode<String> node4 = new DoubleNode<>("node4");

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;

        printList(node1);

        //下面开始进行相关的操作

        //1.表头插入节点
//        DoubleNode<String> first = insertFirst(node1,"node5");
//        printList(first);

        //2.在指定节点之前插入节点
//        DoubleNode<String> first = insertNode(node1, "node1", "node5");
        //3.删除指定节点
        DoubleNode<String> first = deleteNode(node1, "node1");
        printList(first);
        printList(node1);
    }

    /**
     * 在表头插入节点
     *
     * @param first
     * @param <T>
     * @return
     */
    public static <T> DoubleNode<T> insertFirst(DoubleNode<T> first, T item) {
        DoubleNode<T> node = new DoubleNode<>(item);
        node.next = first;
        first.prev = node;
        return node;
    }

    /**
     * 删除指定节点
     *
     * @param first
     * @param target
     * @param <T>
     * @return
     */
    public static <T> DoubleNode<T> deleteNode(DoubleNode<T> first, T target) {

        DoubleNode<T> p = first;
        while (p != null) {
            if (p.item.equals(target)) {

                if (p.prev == null) {    //如果是第一个结点
                    p.next.prev = null;
                    return p.next;
                } else {
                    p.prev.next = p.next;
                    if (p.next != null) {       //如果是最后一个节点
                        p.next.prev = p.prev;
                    }
                    return first;
                }
            }
            p = p.next;
        }
        return first;
    }

    /**
     * 在指定元素之前插入节点
     *
     * @param <T>
     * @param first
     * @param target
     * @param item
     * @return
     */
    public static <T> DoubleNode<T> insertNode(
            DoubleNode<T> first, T target, T item) {

        DoubleNode<T> node = new DoubleNode<>(item);
        DoubleNode<T> p = first;
        while (p != null) {
            if (p.item.equals(target)) {
                if (p.prev != null) {       //如果不是第一个结点
                    p.prev.next = node;
                    p.prev = node;
                    node.next = p;
                    return first;
                } else {
                    p.prev = node;          //如果是第一个节点
                    node.next = p;
                    return node;
                }
            }
            p = p.next;
        }
        return first;
    }

    private static <T> void printList(DoubleNode<T> current) {
        while (current != null) {
            System.out.print(current.item);
            current = current.next;
            if (current != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }


}
