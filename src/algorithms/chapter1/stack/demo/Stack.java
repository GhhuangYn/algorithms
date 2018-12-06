package algorithms.chapter1.stack.demo;

import java.util.Iterator;

/**
 * @Description: 使用数组实现栈
 * @author: HuangYn
 * @date: 2018/12/6 15:29
 */
public class Stack<T> implements Iterable<T> {

    private T[] elements;
    private int N;           //数组大小
    private int currIdx;     //当前的索引

    public Stack() {
    }

    public Stack(int N) {
        this.currIdx = -1;
        this.N = N;
        this.elements = (T[]) new Object[N];
    }

    public void push(T elem) {

        if (isFull()) resize(2 * N);
        currIdx++;
        elements[currIdx] = elem;
    }

    public T pop() {
        if (!isEmpty()) {
            T elem = elements[currIdx];
            elements[currIdx] = null;   //防止游离对象
            currIdx--;

            //如果栈的使用大小小于四分之一，那么就把大小减半
            if (currIdx > 0 && currIdx == N / 4)
                resize(N / 2);

            return elem;
        } else {
            System.out.println("当前栈为空!");
            return null;
        }
    }

    private boolean isEmpty() {
        return currIdx == -1;
    }

    private boolean isFull() {
        return currIdx == N - 1;
    }

    private int size() {
        return N;
    }

    //重新分配数组的大小
    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i <= currIdx; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
        this.N = temp.length;
    }

    //返回最近添加的元素，但不删除
    public T peek(){
        return elements[currIdx];
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
                return pop();
            }
        };
    }



    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>(20);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.size());

        stack.iterator().forEachRemaining(System.out::println);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());

    }
}
