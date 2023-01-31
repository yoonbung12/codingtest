package dataStructure;

import java.util.Scanner;

public class TwoPointer {

	public static void main(String[] args) {
		// 연속된 자연수의 합 구하기(투 포인터 활용)
		Scanner sc = new Scanner(System.in);
		// N 변수 저장
		int N = sc.nextInt();
		// 사용변수 초기화(count = 1; start_index = 1; end_index = 1; sum = 1;)
		int count = 1;
		int start_index = 1;
		int end_index = 1;
		int sum = 1;
		
		while(end_index != N) {	
			if(sum == N) {	// 햔제 얀속 합이 N과 같은 경우
				count ++;
				end_index ++;
				sum = sum + end_index;
			} else if(sum > N) { // 현재 연속 합이 N보다 더 큰 경우
				sum = sum - start_index;
				start_index++;
			} else {
				end_index++;
				sum = sum + end_index;
			}
		}
			System.out.println(count);
	}

}
