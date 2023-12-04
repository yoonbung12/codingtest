package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Decimal2 {

	public static void main(String[] args) throws IOException {
		// 거의 소수 구하기 - 1456
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// Min(시작수), Max(종료수)
		long Min = Long.parseLong(st.nextToken());
		long Max = Long.parseLong(st.nextToken());
		
		// A소수 배열
		long[] A = new long[10000001];
		for(int i =2; i < A.length; i++) {
			A[i] = i; // A 배열 초기화
		}
		
		for(int i =2; i<= Math.sqrt(A.length); i++) { // 제곱근 까지만 수행하기
			if(A[i] == 0) {
				continue; // 소수가 아니면 pass
			}
			for(int j = i + i; j < A.length; j = j + i) { // 배수 지우기
				A[j] = 0; 
				
			}
			
		}
		
		int count = 0;
		for(int i = 2; i < 10000001; i++) {
			if(A[i] != 0) {
				long temp = A[i];
				
				while((double)A[i] <= (double)Max/(double)temp) {
					if((double)A[i] >= (double)Min/(double)temp) {
						count++;
					}
					temp = temp * A[i];
				}
			}
		}
		
		System.out.println(count);

	}

}
