package algorithms.chapter1.list;

/**
 * @Description:
 * @author: HuangYn
 * @date: 2018/12/6 17:30
 */
public class LinkedListOperation {

    public static void main(String[] args) {

        Node<String> head = new Node<>("head");     //头指针
        Node<String> node1 = new Node<>("node1");
        Node<String> node2 = new Node<>("node2");
        Node<String> node3 = new Node<>("node3");
        Node<String> node4 = new Node<>("node4");
        Node<String> node5 = new Node<>("node5");

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printList(head);

        //在表头插入节点
      /*  Node<String> newNode = new Node<>("newNode");
        head.next = newNode;
        newNode.next = node1;
        printList(head);
*/
        //在node1和node2之间插入node4
      /*  Node<String> node4 = new Node<>("node4");
        node1.next = node4;
        node4.next = node2;

        printList(head);*/

        //移除第一个节点
      /*  head.next = node1;
        printList(head);*/

        //移除指定内容的元素
     /*   remove(head, "node3");
        printList(head);
*/
        //链表末尾添加一个元素
        add(head, new Node<>("node5"));
        printList(head);

        //删除最后一个节点
//        removeLast(head);
//        printList(head);

        //查询一个元素
//        System.out.println(find(head, "nod33"));

        //删除一个节点的后续节点
//        removeAfter(node4);
//        printList(head);

        //反转链表
//        reverse(head);
//        head.next = reverse2(head.next);
//        printList(head);


    }

    private static <T> void printList(Node<T> current) {
        while (current != null) {
            System.out.print(current.item);
            current = current.next;
            if (current != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    /**
     * 删除指定元素的节点（第一个）
     *
     * @param head
     * @param item
     * @param <T>
     */
    private static <T> void remove(Node<T> head, T item) {

        if (item instanceof String) {
            Node<String> p = (Node<String>) head;
            while (p.next != null) {
                if (p.next.item.equals(item)) {
                    if (p.next.next != null)        //如果是最后一个元素
                        p.next = p.next.next;
                    else {
                        p.next = null;
                        break;
                    }
                }
                p = p.next;
            }
        }
    }

    /**
     * 在链表末尾添加一个元素
     *
     * @param head
     * @param newNode
     * @param <T>
     */
    private static <T> void add(Node<T> head, Node<T> newNode) {

        Node<T> p = head;
        while (p.next != null) p = p.next;  //找到最后一个节点
        p.next = newNode;
    }

    //删除尾节点
    private static <T> void removeLast(Node<T> head) {

        Node<T> p = head;
        while (p.next.next != null) p = p.next; //找到倒数第二个位置
        p.next = null;
    }

    /**
     * 查找一个元素
     *
     * @param head 链表
     * @param item 需要查找的元素
     * @return 如果找到返回true
     */
    private static <T> boolean find(Node<T> head, T item) {

        Node<T> p = head;
        while (p.next != null) {
            if (p.next.item.equals(item))
                return true;
            p = p.next;
        }
        return false;
    }

    /**
     * 删除指定节点的后续节点
     *
     * @param node
     * @param <T>
     */
    private static <T> void removeAfter(Node<T> node) {
        Node<T> p = node;
        if (p.next != null) {
            p.next = p.next.next;
        }
    }

    /**
     * 反转列表（破坏性地）：迭代的方法
     *
     * @param head
     * @param <T>
     */
    private static <T> void reverse(Node<T> head) {

        Node<T> first = head.next;      //指向原链表剩余节点的第一个元素
        Node<T> second;                 //指向原链表剩余节点的第二个元素
        Node<T> reverse = null;       //指向原有的链表头
        while (first != null) {
            second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        head.next = reverse;
    }

    /**
     * 递归反转
     *
     * @param first
     * @param <T>
     */
    private static <T> Node<T> reverse2(Node<T> first) {

        if (first == null) return null;
        if (first.next == null) return first;
        Node<T> second = first.next;
        Node<T> rest = reverse2(second);
        second.next = first;
        first.next = null;
        return rest;

    }

}
