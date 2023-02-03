package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Queue2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 절댓값 힙 구현하기11286번
		// N(질의 요청 개수), 우선순위 큐 선언
		// 절댓값 기준으로 정렬되도록 설정
		// 단, 절댓값이 같으면 음수 우선 정렬하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) ->{
			
				

			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if(first_abs == second_abs) {// 절댓값이 같으면 음수 먼저
				return o1 > o2 ? 1 : -1;
			}
			return first_abs - second_abs;	// 절대값이 작은  데이터 우선
			
		}); 
		
		for(int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine());
			if(request == 0) {
				if(myQueue.isEmpty()) {	//안에 데이터가 비어있으면
					System.out.println("0");
				//그게 아닌경우
				} else {
					System.out.println(myQueue.poll());
				}
			} else {
				myQueue.add(request);
			}
		}

	}

}
