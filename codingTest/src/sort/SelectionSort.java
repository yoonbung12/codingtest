package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {

	public static void main(String[] args) throws IOException {
		// 내림차순 정렬(1427번)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//str(정렬할 수)
		String str = br.readLine();
		//A(자릿수 별로 구분해 저장할 배열
		int[] A = new int[str.length()];
		for(int i = 0; i < str.length(); i++) {	//str의 길이만큼 반복
			A[i] = Integer.parseInt(str.substring(i, i + 1)); // substring(beginIndex, endIndex)
			
		}
		//for(i: 0 ~ str의 길이만큼 반복)
		for(int i = 0; i < str.length(); i++) {
			int Max = i; 
			//for(j: i+1 ~ str의 길이만큼 반복) -- i+1은 그다음 인덱스부터 들어가야해서
			for(int j = i + 1; j < str.length(); j++ ) {
				if(A[j] > A[Max])
					//내림 차순이므로 최댓값 활용
					Max = j;
			}
			if(A[i] < A[Max]) { //swqp과정
				int temp = A[i];
				A[i] = A[Max];
				A[Max] = temp;
			}
		}
		//A배열 출력
		for(int i = 0; i < str.length(); i++) {
			System.out.println(A[i]);
		}
		
	}

}
