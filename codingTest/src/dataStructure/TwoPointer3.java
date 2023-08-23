package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1253번 '좋은 수' 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//N(수의 개수)
		int N = Integer.parseInt(br.readLine());
		//Result 합쳐서 나오는 수의 갯수
		int Result = 0;
		//A[] 선언해주기
		long[] A = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		//A[]정렬해주기
		Arrays.sort(A);
		for(int k=0; k < N; k++) {
			long find = A[k];
			int i = 0;
			int j = N - 1;
			
			//투포인터
			while(i < j) {
				if(A[i] + A[j] ==find) {
					//find는 서로 다른두 수의 합이어야함
					if(i != k && j != k) {
						Result++;
						break;
					} else if(i ==k) {
						i++;
					} else if(j ==k) {
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


		
	}

}
