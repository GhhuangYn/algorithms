package algorithms.chapter1.stack.demo;

/**
 * @Description: 基于链表实现的栈
 * @author: HuangYn
 * @date: 2018/12/6 20:13
 */
public class LinkedListStack<T> {

    private class Node<T> {
        T item;
        Node<T> next;

        public Node() {
        }

        public Node(T item) {
            this.item = item;
        }
    }

    private Node<T> top;    //栈顶
    private int N;          //栈中元素个数

    public LinkedListStack() {
        this.top = new Node<>();
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.next = top.next;
        top.next = node;
        N++;
    }

    public T pop() {
        if (!isEmpty()) {
            Node<T> node = top.next;
            top.next = node.next;
            N--;
            return node.item;
        }
        return null;
    }

    public int size() {
        return N;
    }


    public static void main(String[] args) {

        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
