package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch2 {

	public static void main(String[] args) throws IOException  {
		//블루레이 구하기 2343(백준)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N(레슨 개수), M(블루레이 개수)
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//A(기타레슨 데이터 저장배열)
		int[] A = new int[N];
		// start(이진탐색 시작 인덱스), end(이진탐색 종료 인덱스)
		int start = 0;
		int end = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			//A 배열 저장
			A[i] = Integer.parseInt(st.nextToken());
			// 시작 인덱스 저장(A배열의 최댓값), 종료 인데스 저장(A배열의 총합)
			if(start < A[i] ) start = A[i]; //레슨 최댓값을 시작 인덱스로 저장하기
			end = end + A[i]; //모든 레슨의 총합을 종료 인덱스로 저장하기
					
		}
		//while(시작 인덱스 <= 종료인덱스) 
		while(start <= end) {
			int middle = (start + end) / 2; //중간 인덱스(middle)
			int sum = 0; //레슨합
			int count = 0; // 현재 사용한 블루레이 개수
			
			//middle값으로 모든 레슨을 저장할 수 있는지 확인
			for(int i = 0; i < N; i++) {
				if(sum + A[i] > middle) {
					count++;
					sum = 0; //sum 초기화 시키기
				}
				sum = sum + A[i];
			}
			// 탐색 후 sum 이 0이 아니면 블루레이가 1개 더 필요하니까 더함
			if(sum != 0) {
				count++;
			}
			if(count > M) {
				start = middle+1;
			} else {
				end = middle - 1;
			}
		}
		System.out.println(start);
	}
}
