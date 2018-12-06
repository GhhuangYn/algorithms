package algorithms.chapter1.stack.demo;

/**
 * @Description: 使用双栈计算算术表达式
 * @author: HuangYn
 * @date: 2018/12/6 15:59
 */
public class Evaluate {


    public static void main(String[] args) {

        String expression = "(1+((2+3)*(4*5)))";

//        Stack<String> ops = new Stack<>(20);
//        Stack<Double> vals = new Stack<>(20);

        LinkedListStack<String> ops = new LinkedListStack<>();      //存放运算符
        LinkedListStack<Double> vals = new LinkedListStack<>();     //存放数字

        //读取字符串
        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);
            if (ch == '(') ;
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                ops.push(String.valueOf(ch));
            } else if (ch == ')') {
                String op = ops.pop();
                double v = 0.0;
                double v1 = vals.pop(), v2 = vals.pop();
                if (op.equals("+")) v = v1 + v2;
                else if (op.equals("-")) v = v2 - v1;
                else if (op.equals("*")) v = v2 * v1;
                else if (op.equals("/")) v = v2 / v1;
                vals.push(v);
            } else {
                vals.push(Double.parseDouble(ch + ""));
            }
            i++;
        }
        System.out.println(vals.pop());

    }
}
