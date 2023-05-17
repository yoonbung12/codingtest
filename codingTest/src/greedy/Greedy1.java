package greedy;

import java.util.Scanner;

public class Greedy1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//N(동전갯수), K(목표금액)
		//A(동전 데이터 배열)
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		// 동전 갯수 = count
		int count = 0;
		// 가치가 큰 동전부터 선택해야 개수를 최소로 구성할 수 있다.
		for(int i = N-1; i>=0; i--) {
			if(A[i] <= K) {	// 현재 동전 액수가 K보다 작으면
				count += (K/A[i]);
				K = K % A[i];	//K를 현재 동전을 사용하고 남은 금액으로 계산
			}
		}
		System.out.println(count);

	}

}
