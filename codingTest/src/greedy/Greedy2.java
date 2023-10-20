package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Greedy2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//카드 정렬하기 1715(백준)
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		//카드 묶음수N
		int N = Integer.parseInt(br.readLine());
		//우선 순위큐 선언
		PriorityQueue pq = new PriorityQueue();
		for(int i = 0; i< N; i++) {
			//우선순위큐에 데이터 저장하
			int data = Integer.parseInt(br.readLine());
			pq.add(data);
		}
		int data1 = 0;
		int data2 = 0; 
		int sum = 0;
		//우선순위큐큐 크기가 1이 될때까지 반복
		while(pq.size() != 1) {
			data1 = (int)pq.remove(); //2개 카드 묶음을 큐에서 뽑음(remove)
			data2 = (int)pq.remove(); 
			sum += data1 + data2; //2개 카드 묶음을 합치데 필요한 비교 횟수를 결과값에더함
			pq.add(data1 + data2);
			
		}
		System.out.println(sum);
		
		
	}

}
