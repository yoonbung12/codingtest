package dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue1 {

	public static void main(String[] args) {
		// 카드 게임(2164번)
		// N(카드의 개수), myQueue(카드 저장 자료구조)
		Scanner sc = new Scanner(System.in);
		//Queue선언(int)값 받을것
		Queue<Integer> myQueue = new LinkedList<>();
		int N = sc.nextInt();
		for(int i = 1; i < N; i++) { //카드를 큐에 저장하기
			myQueue.add(i);
			 
		}
		//카드가 한장남을때까지 while문 반복
		while(myQueue.size() > 1	) {
			myQueue.poll(); //맨위에 카드를 버림
			//int temp = myQueue.poll(); 26번줄이랑 같은거임(쓰는방식만  다를뿐)
			//myQueue.add(temp);
			myQueue.add(myQueue.poll());
		}
		System.out.println(myQueue.poll());
	}

}
