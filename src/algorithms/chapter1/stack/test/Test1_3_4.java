package algorithms.chapter1.stack.test;

import algorithms.chapter1.stack.demo.Stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 使用栈判定其中的括号是否配对完整
 * @author: HuangYn
 * @date: 2018/12/6 22:22
 */
public class Test1_3_4 {

    public static void main(String[] args) {

        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');
        String s = "[()]{}{[()()]()}";
        Stack<Character> left = new Stack<>(20);
        char[] chars = s.toCharArray();
        boolean flag = true;
        for (char c : chars) {
            if (c == '[' || c == '(' || c == '{') {
                left.push(c);
            } else {

                if (c != map.get(left.pop())) {
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(flag);

    }
}
