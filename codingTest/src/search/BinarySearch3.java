package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch3 {

	public static void main(String[] args) throws NumberFormatException, IOException  {
		
		//  P1300_k번째 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//배열의 크기(N), 구하고자 하는index(K)
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		//start(시작인덱스 = 1), end(종료 인덱스 =k)
		long start = 1;
		long end = K;
		long ans = 0;
		
		//이진 탐색수행
		while(start <= end) {
			long middle = (start + end) /2; //중간 인덱스
			long cnt = 0;
			
			//중앙값 보다 작은 수는 몇 개인지 계산
			for(int i = 1; i <= N; i++) {
				cnt += Math.min(middle / i, N); //작은 수를 카운트 하는 핵심로직	
			}
			if(cnt < K) {
				start = middle + 1;
				
			} else {
				ans = middle; //현재 단계의 중앙값을 정답 변수에 저장하기
				end = middle - 1;
				
			}
		}
		
		System.out.println(ans);
		

	}

}
