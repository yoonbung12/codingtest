package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 주몽의 명령 문제 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N재료의 개수, M갑옷이 되는 번호,
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A); //오름차순 정렬
		int count = 0;
		int i = 0;
		int j = N - 1;
		while(i < j) { //투 포인터 이동원칙에 따라 포인터를 이동하며 처리
			if(A[i] + A[j] < M) {
				i++;
			} else if(A[i] + A[j] > M) {
				j--;
			} else {
				count++;
				i++;
				j--;
				
			}
		}
		System.out.println(count);
		br.close();

	}

}
