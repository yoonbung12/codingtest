package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// 1920번 원하는 정수 찾기(이진 탐색)
		Scanner sc = new Scanner(System.in);
		//N(정렬할 수 개수), M(탐색할 숫자의 개수)
		//A(정렬할 배열 선언)
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {//N의 개수만큼 반복하기
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);	//배열 정렬하기
		int M = sc.nextInt();
		for(int i = 0; i < M; i++) {//M의 개수만큼 반복하기
			boolean find = false;
			int target = sc.nextInt();	//찾아야하는 수(target)
			//이진 탐색 시작
			int start = 0;	//시작 인덱스
			int end = A.length - 1; //종료 인덱스
			while(start <= end) {
				int midi = (start + end) /2; //midi(중앙값)
				int midV = A[midi];
				if(midV > target) {
					end = midi - 1;
				} else if(midV < target) {
					start = midi + 1;
				} else {
					find = true;
					break;
				}
				
			}
			if(find) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

	}

}
