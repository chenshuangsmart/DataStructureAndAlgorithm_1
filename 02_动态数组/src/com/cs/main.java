package com.cs;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ArrayList<Object> list = new ArrayList<Object>();
//		list.add(10);
//		list.add(new Person(10, "Jack"));
//		list.add(20);
//		list.indexOf(new Person(10, "jack"));
//		System.out.println(list.toString());
		
//		ArrayList<Object> persons  = new ArrayList<>();
//		persons.add(new Person(10, "Jack"));
//		persons.add(null);
//		persons.add(new Person(15, "Rose"));
//		persons.add(null);
//		persons.add(new Person(12, "James"));
//		persons.add(null);
//
//		System.out.println(persons.indexOf(new Person(12, "James")));
		
		test();
	}
	
	static void test() {
		// Object int -> Integer
		// 所有的类，最终都继承 java.lang.Object
		
		// new 是向堆空间申请内存
		ArrayList<Person> persons = new ArrayList<Person>();
		persons.add(new Person(10, "Jack"));
		persons.add(new Person(12, "James"));
		persons.add(new Person(15, "Rose"));
		persons.clear();
		persons.add(new Person(22, "abc"));
		System.out.println(persons);
		
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(10);
		ints.add(10);
		ints.add(22);
		ints.add(33);
		System.out.println(ints);
	}

}
