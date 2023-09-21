package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {

	public static void main(String[] args) throws IOException  {
		// k번째 수 구하기11004번
		// 그냥 정렬함수 사용해서 해도 되지만 퀵정렬 활용해보자
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N(데이터 개수), K(K번째수)
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		//A[N]배열 선언		
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for(int i =0; i< N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//퀵정렬 실행
		quickSort(A,0,  N -1, K-1);
		

		
	}

	private static void quickSort(int[] A, int start, int end, int K) {
		
		if(start < end) {
			int pivot = partition(A, start, end);
			if(pivot == K	) { //둘이같으면 답입니다.
				return;
			}
			else if(K  < pivot ) { //왼쪽만 정렬
				quickSort(A,start, pivot -1, K	);
				
			}
			else if(K > pivot) { //오른쪽만 정렬
				quickSort(A, pivot + 1, end, K);
				
			}
		}

		
	}

	private static int partition(int[] A, int start, int end) {
		if(start+1 == end	) {
			if(A[start] > A[end])
				swap(A,start,end);
				return end;
		}
		int M = (start + end) / 2;
		
	    swap(A, start, M); // 중앙값을 1번째 요소로 이동하기
	    int pivot = A[start];
	    int i = start+1, j = end;
	    
	    while (i <= j) {
	        while (pivot < A[j] && j > 0 ){   //피벗보다 작은 수가 나올때까지 j--
	            j--;    
	        }
	        while (pivot > A[i]  && i <A.length-1){  //피벗보다 큰 수가 나올 떄까지 i++
	               i ++;  
	        }
	        if (i <= j) {
	            swap (A, i++, j--);  // 찾은 i와 j를 교환하기
	        }
	    }
	    // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
	    A[start] = A[j];
	    A[j] = pivot;
	    return j;
		


	}

	private static void swap(int[] A, int start, int end) {
		int temp = A[start];
		A[start] = A[end];
		A[end] = temp; 
		
		
		

		
	}

}
