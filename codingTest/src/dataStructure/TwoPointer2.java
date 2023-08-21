package dataStructure;

import java.io.*;
import java.util.*;

public class TwoPointer2 {

	public static void main(String[] args) throws IOException {
		// 주몽의 명령 문제 구하기(백준 1940)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N(재료 갯수), M(갑옷이 만들어지는 재료합수)		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		//count는 합이 9가 되는 횟수
		int count = 0;
		int i = 0;	//배열 시작 번호
		int j = N-1; //배열 마지막 번호
		while(i < j) {
			if(A[i] + A[j] < M) { //두 합이 M 보다 작으면
				i++;
			} else if(A[i] + A[j] > M) { //두합이 M보다 크면
				j--;
			} else{
				i++;
				j--;
				count++;
			
			}
			
		}
		System.out.println(count);

	}

}
