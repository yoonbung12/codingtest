package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 수 정렬하기(2750)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//N(정렬할 수 개수)
		int N = Integer.parseInt(br.readLine());
		//A(정렬할 배열 선언)
		int A[] = new int[N];
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < N - 1 - i; j++) {
				if(A[j] > A[j+1]) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			System.out.println(A[i]);
		}
		

	}

}
