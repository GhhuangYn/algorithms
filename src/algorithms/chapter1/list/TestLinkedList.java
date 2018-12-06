package algorithms.chapter1.list;

/**
 * @Description:
 * @author: HuangYn
 * @date: 2018/12/6 17:30
 */
public class TestLinkedList {

    public static void main(String[] args) {

        Node<String> head = new Node<>("head");     //头指针
        Node<String> node1 = new Node<>("node1");
        Node<String> node2 = new Node<>("node2");
        Node<String> node3 = new Node<>("node3");

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        printList(head);

        //在表头插入节点
        Node<String> newNode = new Node<>("newNode");
        head.next = newNode;
        newNode.next = node1;
        printList(head);

        //在node1和node2之间插入node4
        Node<String> node4 = new Node<>("node4");
        node1.next = node4;
        node4.next = node2;

        printList(head);

        //移除第一个节点
        head.next = node1;
        printList(head);

        //移除指定内容的元素
        remove(head, "node3");
        printList(head);

        //链表末尾添加一个元素
        add(head, new Node<>("node5"));
        printList(head);

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

    //删除指定节点
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

    //在链表末尾添加一个元素
    private static <T> void add(Node<T> head, Node<T> newNode) {

        Node<T> p = head;
        while (p.next != null) p = p.next;  //找到最后一个节点
        p.next = newNode;
    }

}
