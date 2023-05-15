package search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BinarySearch2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N레슨 개수, M블루레이 개수 (9, 3)
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//A기타레슨 데이터 저장 배열
		int[] A = new int[N];
		
		// 처음 인덱스,마지막 인덱스, 중앙값
		int left = 0;
		int right = 0;
		int mid = (left + right)/2;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			
			right += A[i];
			left = Math.max(left, A[i]);
			
			while(left <= right) {
				mid = (left + right)/2;
				
				int count = getCount(N, A, mid);
				
				if(count > M) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			
		}
		
		System.out.println(left);
		
	}

	private static int getCount(int N, int[] A, int mid) {

		int sum = 0;
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(sum + A[i] > mid	) {
				sum = 0;
				count++;
			}
			sum += A[i];
		}
		if(sum != 0	) 
			count++;
		return count;
	}

}
