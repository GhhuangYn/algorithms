package algorithms.chapter1.stack.test;

import algorithms.chapter1.stack.demo.Stack;

/**
 * @Description: 编写copy函数，返回一个栈的副本
 * @author: HuangYn
 * @date: 2018/12/7 10:01
 */
public class Test1_3_12 {

    private static Stack<String> copy(Stack<String> other) {

        Stack<String> tmp = new Stack<>(other.size());
        Stack<String> newStack = new Stack<>(other.size());
        other.iterator().forEachRemaining(tmp::push);
        tmp.iterator().forEachRemaining(newStack::push);
        return newStack;
    }

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>(10);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");

        Stack<String> newStack = copy(stack);
        newStack.forEach(System.out::println);
    }

}
