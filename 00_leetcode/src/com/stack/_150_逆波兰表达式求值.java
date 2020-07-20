package com.stack;

import java.sql.Array;
import java.util.HashMap;
import java.util.Stack;

import com.sun.jdi.IntegerValue;

/** 150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author chenshuang
 *
 */
public class _150_逆波兰表达式求值 {
	
//	private static Stack<Integer> stack = new Stack<>();
	private static HashMap<String, String> map = new HashMap<>();
	
	static {
		map.put("+", "+");
		map.put("-", "-");
		map.put("*", "*");
		map.put("/", "/");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] tokens = {"2", "1", "+", "3", "*"};	// 9
//		String[] tokens = {"4", "13", "5", "/", "+"};	// 6
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};	// 22
		
		System.out.println(evalRPN1(tokens));
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		int total = 0;
		for (int i = 0; i < tokens.length; i++) {
			String str = tokens[i];
			if (!map.containsKey(str)) {	// 数字 - 入栈
				stack.push(Integer.parseInt(str));
			} else {	// 运算符 - 出栈前面两个
				int num1 = stack.pop();
				int num2 = stack.pop();
				if (str == "+") {
					total = num1 + num2;
					stack.push(total);
				} else if (str == "-") {
					total = num2 - num1;
					stack.push(total);
				} else if (str == "*") {
					total = num1 * num2;
					stack.push(total);
				} else if (str == "/") {
					total = num2 / num1;
					stack.push(total);
				}
			}
		}
		return total;
    }
	
	public static int evalRPN1(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
