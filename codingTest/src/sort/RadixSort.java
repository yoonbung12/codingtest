package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RadixSort {

	private static int[] A;		//정렬할 배열(A)
	

	public static void main(String[] args) throws NumberFormatException, IOException  {
		// 수 정렬하기3(10989번)-기수 정렬 활용 


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//정렬할 수 갯수(N)
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		Radix_sort(A, 5); // 5는 만의 자릿수보자 작아서 5를 적었다.
		
	
		
	}


	private static void Radix_sort(int[] A, int max_size) {
		int[] output = new int[A.length]; //임시정렬을 위한 배열 
		int jarisu = 1;	//현재 자릿수
		int count = 0;
		//로직 부분
		while(count != max_size) { //최대 자릿수 만큼 반복하기
			int[] bucket = new int[10];
			for(int i = 0; i < A.length; i++) {
				bucket[(A[i] / jarisu) % 10]++; //일의 자리부터 시작하기 
			}
			for(int i = 1; i < 10; i++) {	//합배열 사용해서 index계산
				bucket[i] = bucket[i] + bucket[i - 1];
			}
			for(int i = A.length - 1; i >= 0; i--) { //현재 자릿수를 기준으로 정렬하기
				output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
				bucket[(A[i] / jarisu) % 10]--;
			}
			for(int i = 0; i < A.length; i++) {
				//다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
				A[i] = output[i];
			}
			jarisu = jarisu * 10; //자릿수 증가시키기
			count++;
			
		}
		
	}

}
