package com.sample.calculator.logic;

import java.util.Stack;

public class Logic
{

    private static String expr="", val="";

    public void setter(String expr)
    {
        Logic.expr =expr;
    }

    public String getter()
    {
        return val;
    }

    private static double opPre(char ch)
    {
        if(ch=='+'||ch=='-')
            return 1;
        else
        if(ch=='×'||ch=='÷'||ch=='^')
            return 2;

        return 0;
    }

    private static double operation(double n1, double n2, char opr)
    {
        if(opr=='+')
            return n1+n2;
        if(opr=='-')
            return n1-n2;
        if(opr=='×')
            return n1*n2;
        if(opr=='^')
            return Math.pow(n1, n2);
        else
            return n1/n2;
    }

    public void run() {

        try {
            int l, i;
            double n1, n2;
            char opr, ch;
            String s = "";
            Stack<Double> num = new Stack<>();
            Stack<Character> ops = new Stack<>();
            l = expr.length();
            expr += " ";
            for (i = 0; i < l; i++) {
                ch = expr.charAt(i);
                if (Character.isDigit(ch) || ch == '.') {
                    s += ch;
                    if (expr.charAt(i + 1) != '.' && !Character.isDigit(expr.charAt(i + 1))) {
                        num.push(Double.parseDouble(s));
                        s = "";
                    }
                } else if (ch == '(')
                    ops.push(ch);
                else if (ch == ')') {
                    while (ops.peek() != '(') {
                        opr = ops.pop();
                        n2 = num.pop();
                        n1 = num.pop();
                        num.push(operation(n1, n2, opr));
                    }
                    ops.pop();
                } else if (ch == '+' || ch == '-' || ch == '×' || ch == '÷'||ch=='^') {
                    while (!ops.isEmpty() && ops.peek() != '(' && opPre(ch) <= opPre(ops.peek())) {
                        opr = ops.pop();
                        n2 = num.pop();
                        n1 = num.pop();
                        num.push(operation(n1, n2, opr));
                    }
                    ops.push(ch);
                }
            }

            while (!ops.isEmpty()) {
                opr = ops.pop();
                n2 = num.pop();
                n1 = num.pop();
                num.push(operation(n1, n2, opr));
            }

//        System.out.print(expr+"= ");

            if (num.peek().intValue() == num.peek())
                val = String.valueOf(num.peek().intValue());
            else
                val = String.valueOf(num.peek());
        }

        catch (Exception e)
        {
            val="Syntax Error";
        }
    }

}
