package dataStructure;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue2 {

	public static void main(String[] args)  {
//1744
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		//N(카드 묶음 갯수)
		int N = sc.nextInt();
		//plusPq,MinusPq(양의 우선순위큐, 음의 우선순위큐)
		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusPq = new PriorityQueue<>();
		int one = 0;	//	1의개수 카운트
		int zero = 0;	//	0의개수 카운트
		for(int i =0; i<N; i++) {	//N만큼 반복 + 4개의 그룹으로 분리해 저장하기
			int data = sc.nextInt();
			if(data > 1) {
				plusPq.add(data);
			} else if(data == 1) {
				one++;
			} else if(data == 0){
				zero++;
			} else {
				minusPq.add(data);
			}
		}
		int sum = 0;	//결과값
		
		//양수 처리하기
		while(plusPq.size() >1) {
			int first = plusPq.remove();
			int second = plusPq.remove();
			sum = sum + first * second;
		}
		if(!plusPq.isEmpty()) {
			sum = sum + plusPq.remove();
		}
		
		//음수 처리하기
		while(minusPq.size() > 1) {
			int first = minusPq.remove();
			int second = minusPq.remove();
			sum = sum + first * second;
		} 
		if(!minusPq.isEmpty()) {
			if(zero == 0) {
				sum = sum + minusPq.remove();
			}
		}
		//1 처리하기
		sum = sum + one;
		System.out.println(sum);
		
		
		

	}

}
