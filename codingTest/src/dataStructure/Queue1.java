package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Queue1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 카드 게임(2164번)
		//N(카드의 개수), queue(카드 저장하는 구조)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		while(queue.size() > 1) { //큐에 한장만 남게되면 while문 빠져나옴
			queue.poll(); //맨위 카드 버림
			queue.add(queue.poll()); // 맨위에 폴하고 다음 맨위 카드를 맨 아래로 이동
			
		}
		System.out.println(queue.poll()); //마지막으로 남은 카드 출력
		
	}

}
