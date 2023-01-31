package dataStructure;

import java.util.Scanner;

public class RestOfSum {

	public static void main(String[] args) {
		// Q.나머지 합 구하기
		Scanner sc = new Scanner(System.in);
		
		// N입력받기(수열의 개수)
		int N = sc.nextInt();
		// M입력받기(나누어떨어져야 하는 수)
		int M = sc.nextInt();
		// S선언하기(합 배열)
		long[] S = new long[N];
		// C선언하기(같은 나머지의 인덱스를 카운트하는 배열
		long[] C = new long[M];
		
		long answer = 0;
		S[0] = sc.nextInt();
		for(int i = 1; i < N; i++) { //수열 합 배열 만들기
			S[i] = S[i - 1] + sc.nextInt();

		}
		for(int i = 0; i < N; i++) { // 합 배열의 모든 값에 % 연산 수행하기
			int remainder = (int)(S[i] % M);
			// 0 ~ i까지의 구간 합 자체가 0일때 정답에 더하기
			if(remainder == 0) answer++;
			// 나머지가 같은 인덱스의 개수 카운팅하기
			C[remainder]++;
		}
		for(int i = 0; i < M; i++) {
			if(C[i] > 1) {
				// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
				answer = answer + (C[i] * (C[i] - 1) / 2);
			}
		}
		System.out.println(answer);
	}

}
