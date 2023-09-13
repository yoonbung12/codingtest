package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class SumOfSection3 {

	public static void main(String[] args) throws IOException {
		//10986 나머지 합 구하기3 이거 다시해봐야
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//N(수열 개수),M(나누는값)
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//합 배열S선언, C(같은 나머지의 인덱스 카운하는 배열)
		long[] S = new long[N];
		long[] C = new long[M];
		long answer = 0;
		S[0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < N; i++) {	//합배열
			S[i] = S[i -1] + Integer.parseInt(br.readLine());
			
		}
		for(int i = 0; i<N; i++) { //합배열 각인덱스마다 %연산, 나머지값remainV 
			int remainV = (int)(S[i] % M);
			// 0 ~i 까지의 구간 합 자체가 0일때까지 정답에 ++
			if(remainV == 0) {
				//나머지값이 같은 인덱스의 갯수세기
				C[remainV]++;
			}
			
		}
		for(int i = 0; i< M; i++) {
			if(C[i] > 1) {
				//나머지가 같은 인덱스중 2개를 뽑는 경우의 수를 더하기
				answer = answer + (C[i] * (C[i] - 1)/2);
			}
		}
		System.out.println(answer);
		
	
	
	}
	
}
