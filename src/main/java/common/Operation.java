package common;

public class Operation {
    private static int ADD =1;
    private static int SUB =1;
    private static int MUL =2;
    private static int DIV =2;

    public static int getValue(String operation){
        int result = 0;
        if ("+".equals(operation)) {
            result = ADD;
        } else if ("-".equals(operation)) {
            result = SUB;
        } else if ("*".equals(operation)) {
            result = MUL;
        } else if ("/".equals(operation)) {
            result = DIV;
        } else {
//            System.out.println("异常字符");
        }
        return result;
    }
}
