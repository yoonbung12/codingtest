package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSection {

	public static void main(String[] args) throws IOException  {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//suno(숫자갯수), quizNo(질의 개수)
		int suNo = Integer.parseInt(st.nextToken());
		int quizNo = Integer.parseInt(st.nextToken());
		long[] S = new long[suNo + 1];	//합배열을넣을 공간
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= suNo; i++) {
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());	// 합배열 공식
		
		}
		for(int q = 0; q < quizNo; q++ ) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(S[j] - S[i-1]);
		}
		
		
		
		
	}

}
