package algorithms.chapter1.stack.test;

import algorithms.chapter1.stack.demo.Stack;

import java.util.Arrays;

/**
 * @Description: 中序表达式转为前序表达式
 * 中序表达式	            前序表达式
 * 2*3/(2-1)+3*(4-1)	+/*23-21*3-41
 * <p>
 * 1、反转输入字符串，如“2*3/(2-1)+3*(4-1)” 反转后为“ )1-4(*3+)1-2(/3*2”，
 * 2、从字符串中取出下一个字符
 * 　　2.1.如果是操作数，则直接输出
 * 　　2.2.如果是“)”，压入栈中
 * 　　2.3.如果是运算符但不是“(”，“)”,则不断循环进行以下处理
 * 　　　　2.3.1.如果栈为空，则此运算符进栈，结束此步骤
 * 　　　　2.3.2.如果栈顶是“)”,则此运算符进栈，结束此步骤
 * 　　　　2.3.2.如果此运算符与栈顶优先级相同或者更高，此运算符进栈，结束此步骤
 * 　　　　2.3.4.否则，运算符连续出栈输出，直到满足上述三个条件之一，然后此运算符进栈
 * 　　2.4、如果是“(”，则运算符连续出栈输出，直到遇见“)”为止,将“)”出栈且丢弃之
 * 3、如果还有更多的字符串，则转到第2步
 * 4、不在有未处理的字符串了，输出栈中剩余元素
 * 5、再次反转字符串得到最终结果
 */
public class InfixToPrefix {

    public static void main(String[] args) {

        String middle = "2 * 3 / ( 2 - 1 ) + 3 * ( 4 - 1 )";
        String prefix = getPrefix(middle);
        double result = getPrefixResult(prefix);
        System.out.println(result);
    }

    //计算前序表达式的值
    private static double getPrefixResult(String prefix) {

        Stack<String> reverseStack = new Stack<>(10);
        Stack<Double> digitStack = new Stack<>(10);    //存放操作数

        for (String elem : prefix.split(" "))
            reverseStack.push(elem);
        String elem;
        double v1 = 0.0, v2 = 0.0;
        while (!reverseStack.isEmpty()) {
            elem = reverseStack.pop();

            //如果遇到运算符，弹出的其前两个数字进行操作再把结果存回去
            if (elem.equals("+") || elem.equals("-")
                    || elem.equals("*") || elem.equals("/")) {
                v1 = digitStack.pop();
                v2 = digitStack.pop();
                switch (elem){
                    case "+" : v2 = v1 + v2;break;
                    case "-" : v2 = v1 - v2;break;
                    case "*" : v2 = v1 * v2;break;
                    case "/" : v2 = v1 / v2;break;
                }
                digitStack.push(v2);
            } else {
                digitStack.push(Double.parseDouble(elem));
            }
        }

        return digitStack.pop();
    }

    public static String getPrefix(String middle) {
        //先反转字符串

        String[] middleArr = middle.split(" ");
        Stack<String> reverseStack = new Stack<>(10);
        for (String s : middleArr) reverseStack.push(s);

        Stack<String> ops = new Stack<>(10);     //存放过程数据
        Stack<String> result = new Stack<>(10);  //存放结果

        String opsTop = "";
        String elem;
        while (!reverseStack.isEmpty()) {

            elem = reverseStack.pop();
            if (!ops.isEmpty()) {           //获取ops中栈顶元素
                opsTop = ops.peek();
            }
            if (elem.equals(")")) {     //如果是括号
                ops.push(elem);

            } else if (elem.equals("(")) {    //遇到右括号，把括号配对中的全部元素弹出到结果栈中

                while (!ops.peek().equals(")")) result.push(ops.pop());
                ops.pop();      //把左括号弹出

            } else if (elem.equals("+") || elem.equals("-") || elem.equals("*") || elem.equals("/")) {  //如果是运算符

                if (opsTop.equals(")")) {    //如果上一个是左括号，运算符压栈
                    ops.push(elem);
                } else if (opsTop.equals("*") || opsTop.equals("/")) {    //如果opsTop是高级运算符
                    if (elem.equals("+") || elem.equals("-")) {               //如果栈顶的运算符比当前的高级，弹出,再压栈
                        result.push(ops.pop());
                        ops.push(elem);
                    } else {
                        ops.push(elem);                //否则直接压栈
                    }
                } else {
                    ops.push(elem);                   //如过opsTop是低级运算符
                }
            } else {     //数字,直接输出
                result.push(elem);
            }
        }

        //弹出剩余的元素
        ops.iterator().forEachRemaining(result::push);

        StringBuffer sb = new StringBuffer();
        result.iterator().forEachRemaining(s -> sb.append(s + " "));
        System.out.println(sb.toString());
        return sb.toString();
    }


}
