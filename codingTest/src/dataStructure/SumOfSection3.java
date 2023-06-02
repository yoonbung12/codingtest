package dataStructure;

import java.util.Scanner;

public class SumOfSection3 {

	public static void main(String[] args) {
		//숫자 갯수N, 나누는 값M
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] S = new long[N];
		long[] C = new long[M];
		long answer = 0;
		S[0] = sc.nextInt();
		for(int i = 1; i <= N; i++) {	//합 배열 만들기
			S[i] = S[i - 1] + sc.nextInt();
		}
		for(int i = 0; i< N; i++) {	//합 배열의 모든 값에 %연산 수행하기
			int remainder = (int)(S[i] % M);
			// 0 ~ i까지의 구간 합 자체가 0일 때 정답에 더하기
			if(remainder == 0) answer++;
			//나머지가 같은 인덱스의 개수 카운팅 하기
			C[remainder]++;
		}
		
		for(int i = 0; i < M; i++) {
			if(C[i] > 1) {
				//나머지가 같은 인덱스중 2개를 뽑는 경우의 수를 더해주기
				answer = answer + (C[i] * (C[i] - 1)/ 2);
			}
		}
		System.out.println(answer);
	}
}
