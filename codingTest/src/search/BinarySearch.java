package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {

	public static void main(String[] args) throws IOException  {
		// 1920번 원하는 정수 찾기(이진 탐색)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//N(정렬할 수 개수),
		int N = Integer.parseInt(st.nextToken());
		// A(정렬할 배열 선언)
		int[] A = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 데이터를 정렬을 해놓고 나서 이진 탐색 시작
		Arrays.sort(A);
		
		//  M(찾아야할 수 갯수)
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			boolean find = false;
			int target = Integer.parseInt(st.nextToken()); //target = 찾아야 하는 수)
			
			// 이진 탐색 시작
			int start = 0; // 시작 인덱스
			int end = A.length -1;
			
			//시작 인덱스가 종료 인덱스랑 같아지면 종료!!
			while(start <= end) {
				int midi = (start + end) / 2; //중간인덱스
				int midv = A[midi]; //중간 익덱스에 들어 있는 값
	
				if(midv > target) {
					end = midi - 1;
	
				} else if(midv < target) {
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
