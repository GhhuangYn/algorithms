package algorithms.chapter1.stack.test;

import algorithms.chapter1.stack.demo.Stack;

/**
 * @Description: 中序表达式转换为后序表达式
 * 中序表达式	        后序表达式
 * 2*3/(2-1)+3*(4-1)	23*21-/341-*+
 * @author: HuangYn
 * @date: 2018/12/7 10:27
 */
public class InfixToPostfix {

    public static void main(String[] args) {

        String middle = "2*3/(2-1)+3*(4-1)";
//        String middle = "2*3-3*(4-1)";
        Stack<Character> ops = new Stack<>(20);
        StringBuilder postorder = new StringBuilder();
        boolean higher = false;      //用于标记栈中的上一个运算符的优先级是否比当前的运算符的优先级高
        boolean left = false;       //标记左括号
        for (char c : middle.toCharArray()) {

            //如果是运算符，压栈
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                //如果上一个运算符的优先级比较高，那么先弹栈
                if (higher && !left) {      //不比较左括号
                    postorder.append(ops.pop());
                }
                higher = !(c == '+' || c == '-');   //低级的操作符
                ops.push(c);
            } else if (c == '(') {  //只做标记，不入栈
                left = true;
            } else if (c == ')') {  //弹出栈中的所有元素
                ops.iterator().forEachRemaining(postorder::append);
                left = false;       //清空left标志
            } else {
                postorder.append(c);
            }
        }
        System.out.println("后缀表达式: " + postorder);


        //使用后缀表达式计算
        Stack<Double> vals = new Stack<>(10);
        double v1, v2;
        for (char c : postorder.toString().toCharArray()) {

            if (Character.isDigit(c)) {
                vals.push(Double.parseDouble(c + ""));
            } else {
                v1 = vals.pop();
                v2 = vals.pop();
                if (c == '+') vals.push(v2 + v1);
                else if (c == '-') vals.push(v2 - v1);
                else if (c == '*') vals.push(v2 * v1);
                else if (c == '/') vals.push(v2 / v1);
            }
        }
        System.out.println("result: " + vals.pop());


    }

}
