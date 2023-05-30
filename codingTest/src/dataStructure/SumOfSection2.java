package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSection2 {

	public static void main(String[] args) throws IOException {
		//N(배열의 크기), M(질의의 갯수) 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A[][] = new int[N+1][N+1]; // 인덱스를 0이 아닌  1부터 시작하기 위해서
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		//합배열 저장
		int D[][] = new int[N+1][N+1];
		for(int i = 1; i<= N; i++) {
			for(int j = 1; j <= N; j++) {
				D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
			}
		}
		//질의에 답변하기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// x1, y1, x2, y2
			int x1 = Integer.parseInt(st.nextToken()); 
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			//구간합 배열로 질의에 답변
			int result = D[x1][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
			System.out.println(result);
		}
	}

}