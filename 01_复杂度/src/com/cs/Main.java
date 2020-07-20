package com.cs;

import com.cs.Times.Task;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib2(0));
		System.out.println(fib2(1));
		System.out.println(fib2(2));
		System.out.println(fib2(3));
		System.out.println(fib2(4));
		System.out.println(fib2(5));
		System.out.println(fib2(6));
		
		System.out.println(fib2(64));
		
		int n = 40;
		
		Times.check("fib1", new Task() {
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println(fib1(n));
			}
		});
		Times.check("fib1", new Task() {
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println(fib2(n));
			}
		});
	}

	/**
	 * 斐波那契数列 0 1 1 2 3 5 8 11 
	 * @param n
	 * @return fib1(n-1) + fib1(n-2)
	 */
	public static int fib1(int n) {
		if (n <= 1) {
			return n;
		}
		return fib1(n - 1) + fib1(n - 2);
	}
	
	/**
	 * 斐波那契数列 0 1 1 2 3 5 8 11 
	 * @param n
	 * @return fib2(n-1) + fib2(n-2)
	 */
	public static int fib2(int n) {
		if (n <= 1) {
			return n;
		}
		int first = 0;
		int second = 1;
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
}
