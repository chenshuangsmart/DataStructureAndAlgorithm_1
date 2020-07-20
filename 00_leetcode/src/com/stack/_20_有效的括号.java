package com.stack;

import java.util.HashMap;
import java.util.Stack;

/**20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author chenshuang
 *
 */
public class _20_有效的括号 {
	
	private static HashMap<Character, Character> map = new HashMap<>();
	static {
		map.put('(', ')');
		map.put('{','}');
		map.put('[',']');
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			Character c = s.charAt(i);
			if (map.containsKey(c)) {	// 左括号 - 入栈
				stack.push(c);
			} else {	// 右括号
				if (stack.isEmpty()) {
					return false;
				}
				if (c != map.get(stack.pop())) {
					return false;
				}
			}
		}
		return stack.isEmpty();
    }
}
