package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSection2 {

	public static void main(String[] args) throws IOException  {
		//11660_구간합 구하기2(빽준)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//N(배열 크기)=N * N , quizNo(질의 개수)
		int N = Integer.parseInt(st.nextToken());
		int quizNo = Integer.parseInt(st.nextToken());
		
		//원본 배열 A[	][] 선언
		int A[][] = new int[N+1][N+1];	// N+1은 배열의 시작을 0이아닌 1로하기위해
		for(int i =1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N+1; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//구간합 구하기
		int D[][]	= new int[N+1][N+1];
		for(int i = 1; i < N+1; i++ ) {
			for(int j = 1; j < N+1; j++ ) {
				D[i][j]= D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
			}
		}
		// 구간합 배열로 질의에 답변하기(quizNo)
		for(int i = 0; i < quizNo; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = D[x2][y2] - D[x2][y1-1] - D[x1-1][y2] + D[x1-1][y1-1];
			System.out.println(result);
			
		}
		
		
		
			
	}
	

}
