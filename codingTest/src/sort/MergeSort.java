package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MergeSort {
	//A(정렬할 배열 선언)
	public static int[] A;
	//임시 저장 배열tmp
	public static int tmp[];
	//result값
	public static long result;

	public static void main(String[] args) throws NumberFormatException, IOException  {
		// 수 정렬하기2(2751번)

		//tmp(정렬시 잠시 사용할 배열 선언)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//N(정렬할 수 개수)
		int N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		tmp = new int[N + 1];
		for(int i =1; i <=N; i++) {
			//A배열 저장
			A[i] = Integer.parseInt(br.readLine());
		}
		merge_sort(1, N); //병합 정렬수행하기
		for(int i = 1; i <= N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();

		
				
	}

	private static void merge_sort(int s, int e) { //s(startindex), e(endindex)
		if(e -s < 1)
			return;
		//중간값(m) 
		int m = s + (e+s)/2 ;
		//재귀함수
		merge_sort(s, m);
		merge_sort(m + 1, e);
		for(int i = s; i <= e; i++) {
			tmp[i] = A[i]; //tmp에다가 A[i]값을 넣는다.
		}
		int k = s;
		int index1 = s;
		int index2 = m + 1; //m(중간값)에서 한칸 더간게 index2다.
		while(index1 <= m && index2 <= e) { //두 그룹 병합 로직
			//양쪽 그룹의 index가 가리키는 값을 비교해 더 적은 수를 선택하고 배열에 저장,
			//선택된 데이터의 index값을 오른쪽으로 한칸 이동
			if(tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
				k++;
				index2++;
			} else { // tmp[index1] < tmp[index2]
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while(index1 <= m) { //한쪽 그룹이 모두 선택된후 남아 있는 값 정리하기
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
