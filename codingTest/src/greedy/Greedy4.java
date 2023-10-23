package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Greedy4 {

	public static void main(String[] args) throws IOException {
		// 회의실 배정하기 (겹치지 않게)- 1931
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N회의 개수 
		int N = Integer.parseInt(st.nextToken());
		// A[][] 시작시간, 종료시간(종료시간 기준으로 정렬, 만약 종료시간이 같으면 시작시간 기준으로 정렬할것!!!)*****
		int[][] A = new int[N][2];
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i][0] = Integer.parseInt(st.nextToken());
			A[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A, new Comparator<int[]>() {

			@Override
			public int compare(int[] S, int[] E) {
				if(S[1] == E[1]) { // 종료 시간이 같을때
					return S[0] - E[0];
				}
			
				return S[1]- E[1];
			}
			
		});
		
		int count = 0;
		int end = -1;
		for(int i = 0; i < N; i++) {
			if(A[i][0] >= end) { // 겹치지 않는 다음 회의가 나온 경우
				end = A[i][1];	// 종료시간 업데이트 하기
				count++;
				
			}
		}
		System.out.println(count);

	}

}
