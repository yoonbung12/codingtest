package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Queue2 {

	public static void main(String[] args) throws IOException  {
		// 절댓값 힙 구현하기11286번
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N(질의 요청 개수)
		int N = Integer.parseInt(br.readLine());
		//우선 순위 큐 선언하기

		//--절대값이 작은 기준으로 정렬되도록 설정			비교할 두 객체 a,b
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->{
			
			//--(절대값이 같으면 음수가 먼저 출력된다) 
			int first_abs = Math.abs(a);
			int second_abs = Math.abs(b);
			if(first_abs == second_abs) {
				return a > b ? 1 : -1;  //1은 양수, -1은 음수
			}
			
			//절대값이 작은수를 우선한다
			return first_abs - second_abs;
		});
		


		//for(N만큼 반복)
		for(int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine()); //데이터 받아야한다(request(변수명)  사용)
			if(request == 0) {
				if(pq.isEmpty()) {
					System.out.println("0");	//큐가 비어 있으면 0출력
				} else {
					System.out.println(pq.poll()); // 비어 있지 않으면 큐의 값 출력
				}
			} else {
				pq.add(request);
			}
		}
		
		

		
	}

}
