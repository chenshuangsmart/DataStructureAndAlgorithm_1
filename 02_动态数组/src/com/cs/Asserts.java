package com.cs;
/**
 * 校验条件是否成立
 * @author chenshuang
 *
 */
public class Asserts {
	public static void test(boolean value) {
		try {
			if (!value) {
				throw new Exception("测试未通过");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
