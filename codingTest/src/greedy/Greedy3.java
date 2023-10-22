package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Greedy3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//수를 묶어서 최댓값 만들기1744(백준)
		// N(카드 묶음수 저장하기)
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//양수 내림차순 정렬
		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusPq = new PriorityQueue<>();
		
		//숫자 1, 0
		int one = 0;
		int zero = 0;
		
		for(int i = 0; i < N; i++) {
			//4개의 그룹으로 분리해 저장하기
			int data = Integer.parseInt(br.readLine());
			if(data > 1) {
				plusPq.add(data);
			} else if(data == 1) {
				one++;
			} else if(data == 0) {
				zero++;
			} else {
				minusPq.add(data);
			}
		}
		int sum = 0;
		
		//양수 처리하기
		while(plusPq.size() > 1) {
			//수 2개를 큐에서 뽑는다.
			int first = plusPq.remove();
			int second = plusPq.remove();
			sum = sum + first * second;
		}
		if(!plusPq.isEmpty()){
			sum = sum + plusPq.remove();
		}
		
		//음수처리하기
		while(minusPq.size() >1 ) {
			// 수 2개를 큐에서 뽑는다.
			int first = minusPq.remove();
			int second = minusPq.remove();
			sum = sum + first * second;
		}
		if(!minusPq.isEmpty()) {
			if(zero == 0) {
				sum = sum + minusPq.remove();
			}
		}
		//1처리하기
		sum = sum + one;
		System.out.println(sum);
		
	}

}
