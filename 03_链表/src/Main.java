import com.cs.Asserts;
import com.cs.list.ArrayList;
import com.cs.list.List;
import com.cs.list.circle.SingleCircleLinkedList;
import com.cs.list.single.SingleLinkedList;
import com.cs.list.single.SingleLinkedList1;
import com.cs.list.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		testList(new ArrayList<>());
		
//		testList(new LinkedList<Integer>());
		
//		testList(new SingleLinkedList<Integer>());
		
//		testList(new SingleLinkedList1<Integer>());
		
//		testList(new SingleCircleLinkedList<Integer>());
		
		testList(new SingleCircleLinkedList<Integer>());
	}

	/*
	 * 测试链表是否正常工作
	 */
	static void testList(List<Integer> list) {
		list.add(11);
		System.out.println(list);
		list.add(22);
		System.out.println(list);
		list.add(33);
		System.out.println(list);
		list.add(44);
		System.out.println(list);
		
		list.add(0, 55);
		list.add(2, 66);
		list.add(list.size(), 77);
		System.out.println(list);
		
		list.remove(0);
		list.remove(2);
		list.remove(list.size() - 1);
		System.out.println(list);
		
		Asserts.test(list.indexOf(44) == 3);
		Asserts.test(list.indexOf(22) == list.ELEMENT_NOT_FOUND);
		Asserts.test(list.contains(33));
		Asserts.test(list.get(0) == 11);
		Asserts.test(list.get(1) == 66);
		
		System.out.println(list);
		Asserts.test(list.get(list.size() - 1) == 44);
	}
}
