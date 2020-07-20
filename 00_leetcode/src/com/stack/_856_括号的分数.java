package com.stack;

import java.util.HashMap;
import java.util.Stack;

/* 856. 括号的分数
 * https://leetcode-cn.com/problems/score-of-parentheses/
 */
public class _856_括号的分数 {
	private static HashMap<Character, Character> map = new HashMap<>();
	private static Stack<Character> stack = new Stack<>();
	
	static {
		map.put('(', ')');
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "(())";
		System.out.println(scoreOfParentheses(string));
	}
	
	static public int scoreOfParentheses(String S) {
		int length = S.length();
		int total = 0;
		for (int i = 0; i < length; i++) {
			Character c = S.charAt(i);
			if (map.containsKey(c)) {	// 左字符串 - 入栈
				stack.push(c);
			} else {	// 右字符串 - 出栈
				if (map.containsKey(S.charAt(i - 1))) {
					total += Math.pow(2, stack.size() - 1);
					 stack.pop();
				} else {
					stack.pop();
				}
			}
		}
		return total;
    }
}
