package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertionSort {

	public static void main(String[] args) throws IOException {
		// ATM 인출시간 계산하기11399번)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N(사람수)
		int N = Integer.parseInt(st.nextToken());
		//A(원본배열)- 각 자릿수 순서
		int[] A = new int[N];
		//S(합 배열)- 
		int[] S = new int[N];
		//A배열 저장
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		// 현재 범위에 삽입 위치 찾기(삽입 정렬)
		for(int i = 1; i < N; i++) {
			int insert_point = i;
			int insert_value = A[i];
			for(int j = i - 1; j >= 0; j--) { //뒤에서 반복하니까 -- 쓴거
				
				if(A[j] < A[i]	) {
					insert_point = j+1;
					break;
				}
				if(j == 0) {
					insert_point = 0;
				}
			}
			// 삽일을 위해  삽입 위치에서 한칸씩 뒤로 밀자
			for(int j = i; j > insert_point; j--) {
				A[j] = A[j - 1];
			}
			A[insert_point] = insert_value;
		}
		//합배열 만들기
		S[0] = A[0];
		for(int i = 1; i < N; i++) {
			S[i] = S[i -1] + A[i];
		}
		//합 배열 총합 구하기
		int sum = 0; 
		for(int i = 0; i < N; i++) {
			sum = sum + S[i];
		}
		System.out.println(sum);
		

	}

}
