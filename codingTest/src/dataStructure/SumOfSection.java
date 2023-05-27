package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSection {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//숫자 개수(N), 질의개수(M)
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//합 배열
		long[] S = new long[N + 1];
		st = new  StringTokenizer(br.readLine());
		for(int i =1; i <= N; i++) {
			S[i] = S[i -1] + Integer.parseInt(st.nextToken());
		}
		for(int q = 0; q < M; q++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			//구간합 구하기
			System.out.println(S[j] - S[i - 1]);
		}
		
		
	}

}
