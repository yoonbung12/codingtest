package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {

	public static void main(String[] args) throws IOException {
		// k번째 수 구하기11004번
		// N(숫자의 개수), K(k번째 수), A[](숫자 데이터 저장 배열)
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int A[] = new int[N];
		for(int i = 0; i < N; i++) { //A배열 저장
			A[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(A, 0, N - 1, K - 1);
		System.out.println(A[K - 1]);
	}										// S = 시작, E =끝
	public static void quickSort(int A[], int S, int E, int K) {
		if(S < E) {
			int pivot = partition(A, S, E);
			if(pivot == K)						//K	번째 수가 pivot이면 더이상 구할 필요없음.
				return;
			else if(K  < pivot)
				quickSort(A, S, pivot - 1, K); 	//K가 pivot보다 작으면 왼쪽 그룹만 정렬 수행하기
			else
				quickSort(A, pivot + 1, E, K);	//K가 pivot보다 크면 오른쪽 그룹만 정렬 수행하기
		}
	}
	private static int partition(int[] A, int S, int E) {
		if(S + 1 == E) {
			if(A[S] > A[E])swap(A, S, E);
			return E;
		}
		int M = (S + E) / 2; //M = 중앙값
		swap(A, S, M);	//	중앙값을 1번째 요소로 이동하기
		int pivot = A[S];
		int i = S + 1, j = E;
		
		while(i <= j) {
			while(pivot < A[j] && j > 0) {	//피벗보다 작은 수가 나올때까지 j--
				j--;
			}
			while(pivot >A[i] && i < A.length-1) {	//피벗보다 큰 수가 나올때까지 i++
				i++;
			}
			if(i <= j) {
				swap(A, i++, j--);
			}
		}
		// i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
		A[S] = A[j];
		A[j] = pivot;
		return j;
	}
	public static void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	

}
