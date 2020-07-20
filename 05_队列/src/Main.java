import com.cs.queue.Queue;
import com.cs.queue.circle.CircleDeque;
import com.cs.queue.circle.CircleQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		queueTest();
//		circleQueueTest();
		circleDequeTest();
	}

	/// 队列测试
	static void queueTest() {
		Queue<Integer> queue = new Queue<>();
		queue.enQueue(11);
		queue.enQueue(22);
		queue.enQueue(33);
		queue.enQueue(44);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
	}
	
	/// 循环单端队列测试
	static void circleQueueTest() {
		CircleQueue<Integer> queue = new CircleQueue<>();
		// 0 1 2 3 4 5 6 7 8 9
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		// null null null null null 5 6 7 8 9
		for (int i = 0; i < 5; i++) {
			queue.deQueue();
		}
		// 15 16 17 18 19 5 6 7 8 9
		for (int i = 15; i < 20; i++) {
			queue.enQueue(i);
		}
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
		System.out.println(queue);
	}
	
	/// 循环双端队列测试
	static void circleDequeTest() {
		CircleDeque<Integer> queue = new CircleDeque<>(); 
		// 入队
		for (int i = 0; i < 10; i++) {
			queue.enQueueFront(i + 1);
			queue.enQueueRear(i + 100);
		}
		System.out.println(queue);
		
		// 出队
		for (int i = 0; i < 3; i++) {
			queue.deQueueFront();
			queue.deQueueRear();
		}
		System.out.println(queue);
		
		// 入队
		queue.enQueueFront(11);
		queue.enQueueFront(12);
		System.out.println(queue);
		
	}
}
