package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort2 {

	public static int[] A, tmp;
	public static long result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버블정렬2(1517번)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N(정렬할 수 개수), A정렬할 배열 선언, tmp(정렬할 때 잠시 사용할 임시배열 선언
		int N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		tmp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		// for(N의 갯수 만큼){A 배열 선언}
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		//병합 정렬 수행하기
		result = 0;
		merget_sort(1, N);
		System.out.println(result);

	}
	//s(시작점),e(종료점),m(중간점)
	private static void merget_sort(int s, int e) {

		if(e - s <1)
			return;
		int m = s + (e - s) /2;
		//재귀함수 형태로 구현하기
		merget_sort(s, m);
		merget_sort(m + 1, e);
		for(int i = s; i <= e; i++) {
			tmp[i] = A[i];
			
		}
		//두 그룹을 병합하는 로직
		int k = s;
		int index1 = s;
		int index2 = m + 1;
		//뒤쪽 데이터 값이 더 작아서선택될때 Swap이 일어났다고 가정하고,현재 남아 있는 앞쪽 데이터 개수만큼 결괏값을 더함
		while(index1 <= m && index2 <= e) {
			if(tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
				result = result + index2 - k;	//뒤쪽 데이터 값이 작은 경우result 업데이트
				k++;
				index2++;
			} else {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while(index1 <= m) {
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		while(index2 <= e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
		
	}

}
