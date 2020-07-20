package com.stack;

import java.util.Stack;

/** 224. 基本计算器
 * https://leetcode-cn.com/problems/basic-calculator/
 * @author chenshuang
 *
 */
public class _224_基本计算器 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// (1+(4+5+2)-3)+(6+8)
	public int calculate(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			Character str = s.charAt(i);
			if (str.equals('(')) {	// 左括号 - 入栈
				stack.push(str);
			} else if () {
				
			}
		}
		return 0;
	}
}
