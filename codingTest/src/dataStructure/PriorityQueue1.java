package dataStructure;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//N(카드묶음의 수 저장)
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int data = sc.nextInt();
			pq.add(data);
		}
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		while(pq.size() != 1) {
			data1 = pq.remove();
			data2 = pq.remove();
			sum += data1 + data2;
			pq.add(data1 + data2);
		}
		System.out.println(sum);
		
		
	}

}
