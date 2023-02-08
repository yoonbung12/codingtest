package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MergeSort {
	
	public static int[] A, tmp;
	public static long result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 수 정렬하기2(2751번)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//N(정렬할 수 갯수), A(정렬할 배열 선언하기, tmp(정렬할 때 잠시 사용할 임시 배열 선언
		int N = Integer.parseInt(br.readLine());
		A = new int[N +1];
		tmp = new int[N + 1];
		// for(N의 개수만큼)
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		//병합정렬 함수 수행하기
		merget_sort(1, N);
		for(int i = 1; i <= N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
		
	}
	//병합 정렬(S, E)
	private static void merget_sort(int s, int e) {
		// s(시작점), e(종룔점), m(중간점)

		if(e - s < 1) 
			return;
		int m = s + (e - s) / 2;
		// 재귀함수 형태로 구현하기
		merget_sort(s, m);
		merget_sort(m + 1, e);
		for(int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}
		int k = s;
		int index1 = s;
		int index2 = m +1;
		while(index1 <= m && index2 <= e) { //두 그룹을 병합하는 로직
			//양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고, 선택된 데이터의 index값을 오른쪽으로 한칸 이동하기
			if(tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
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
