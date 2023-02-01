package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1253번 '좋은 수' 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N(수의 개수)
		int N = Integer.parseInt(br.readLine());
		int Result = 0;
		// A(수 데이터 배열 저장)
		long A[]  = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// for(N 만큼 반복)
		for(int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		// A배열 정렬
		Arrays.sort(A);
		
		// for( K를 0부터 N 까지 반복)
		for(int k = 0; k < N; k++) {
			long find = A[k];
			int i = 0;
			int j = N - 1;
			
			// 투 포인터 알고리즘
			while(i < j) {
				if(A[i] + A[j] == find) {
					// find는 서로 다른 두 수의 합이어야 함을 체크
					if(i != k && j != k) {
						Result++;
						break;
					} else if(i == k) {
						i++;
					} else if(j == k) {
						j--;
					}
				} else if(A[i] + A[j] < find) {
					i++;
				} else {
					j--;
				}
			}
		}
		System.out.println(Result);
		br.close();
	}

}
