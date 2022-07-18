package common;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 这里没有考虑多位数的运算
 * 需要用正则来筛选
 */
public class CalualtionFormula {
    /**
     * 字符串计算
     */
    public static String FourArithmeticOperations(String formula){
        return getAnswer(formula);
    }

    private static String getAnswer(String formula) {
        List<String> InfixforArr = todoArr(toArray(formula));
        return toCaluation(getSuffix(InfixforArr));
    }

    private static String toCaluation(List<String> suffix) {
        Stack<String> stack = getStack();
        for (String s:suffix){
            if(s.matches("\\d+")){
                stack.push(s);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if ("+".equals(s)) {
                    res = num1+num2;
                } else if ("-".equals(s)) {
                    res = num1-num2;
                } else if ("*".equals(s)) {
                    res = num1*num2;
                } else if("/".equals(s)){
                    res = num1/num2;
                }else {
                    System.out.println("错误字符");
                }
                stack.push(Integer.toString(res));
            }
        }
        System.out.println(stack.peek());
        return stack.pop();
    }

    private static List<String> getSuffix(List<String> strArr) {
        Stack<String> s1 = getStack();    // 符号栈
        List<String> s2 = getStringList();// 数据栈
        for (String s:strArr){
            if(s.matches("\\d+")){
                s2.add(s);
            }else if(s.matches("\\(")){
                s1.push(s);
            }else if(s.matches("\\)")){
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                while (s1.size()!=0 && Operation.getValue(s1.peek())>=Operation.getValue(s)){
                    s2.add(s1.pop());
                }
                s1.add(s);
            }
        }

        while (s1.size() != 0){
            s2.add(s1.pop());
        }
//        System.out.println(s2);
        return s2;
    }



    private static List<String> getStringList() {
        return new ArrayList<String>();
    }

    private static Stack<String> getStack() {
        return new Stack<String>();
    }

    private static List<String> todoArr(String[] strArr) {
        List<String> ls = getStringList();
        for(String c:strArr){
            ls.add(c);
        }
        return ls;
    }


    // 解析字符串
    private static String[] toArray(String str){
        return str.split("");
    }    
}
