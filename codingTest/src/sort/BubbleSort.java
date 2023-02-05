package sort;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		// 수 정렬하기(2750)
		// N개의 수, A[] 정렬할 배열 선언
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		// A의 값을 받을것
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		//버블 정렬 구현(이중 for문 쓸것)
		for(int i = 0; i < N -1; i++) { //루프가 몇번 도는지
			for(int j = 0; j < N - 1 - i; j++) {
				if(A[j] > A[j + 1]) { // 인접한 두수 비교(앞에것이 더 크다는 가정)
					// swap방법
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
