package search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// 1920번 원하는 정수 찾기(이진 탐색)

		//N개의 정수 A[N]개,이진탐색이니 정렬(Sort) 사용
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		//배열은 정렬되어야함
		Arrays.sort(A);
		//M의 개수 
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<M; i++ ) {
			int num = Integer.parseInt(st.nextToken()) - 1; //검색 하려는 수
			
			int left = 0;				//처음 인덱스
			int right = N -1;			//마지막 인덱스
			int mid = (left + right)/2;	//중앙 인덱스
			
			while(left <= right) {
				mid = (left + right)/2;
				if(num == A[mid]) {	//찾으려는 수가 있는 경우
					break;
					
				} else if(num < A[mid]) {
					right = mid - 1;	// 찾으려는 수가 mid 보다 작은경우
				} else {
					left = mid + 1;	
				}
			}
			if(num == A[mid])
				bw.write("1\n");
			else
				bw.write("0\n");
			
		}

		bw.close();
	}

}
