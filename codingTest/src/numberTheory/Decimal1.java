package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Decimal1 {

	public static void main(String[] args) throws IOException {
		// 소수구하기-1929
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// M(시작수),N(종료수)
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		// 소수 배열 선언하기
		int[] A = new int[N+1]; // 배열이 인덱스가 0부터 시작하니까 +1해줌
		for(int i = 1; i <= N; i++ ) {
			A[i] = i; // A배열 초기화해주기
			
		}
		
		// 에라토스테네스
		for(int i = 2; i <= Math.sqrt(N); i++  ) {
			if(A[i] == 0) {
				continue;
			} else {
				for(int j = i + i; j <= N; j = j+i ) {
					A[j] = 0;
				}
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(A[i] != 0) {
				System.out.println(A[i]);
			}
			
		}
		
	}

}
