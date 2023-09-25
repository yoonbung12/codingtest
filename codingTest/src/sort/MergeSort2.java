package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort2 {

	//A(정렬할 배열 선언)
	public static int A[];
	//tmp(임시로 저장할 배열)
	public static int tmp[];
	//result(swap한 갯수)
	public static long result;
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		// 버블정렬2(1517번)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//정렬할 수 선언(N)
		int N = Integer.parseInt(br.readLine());
		A = new  int [N + 1];
		tmp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			A[i]= Integer.parseInt(st.nextToken());
		}
		result = 0;
		//병합정렬 수행
		merge_sort(1, N);

		System.out.println(result);
		
	}

	private static void merge_sort(int s, int e) {
		if(e - s < 1)
			return;
		int m = s + (e -s)/2;
		
		//재귀 함수 형태로 구현
		merge_sort(s, m);
		merge_sort(m+1, e);
		//임시 저장 배열tmp
		for(int i = s; i <= e; i++) {
			tmp[i] = A[i];
			
		}
		int k = s; //시작점 을 넣어줘야함.
		int index1 = s;
		int index2 = m+1;
		while(index1 <= m && index2 <= e ) { //두그룹 병합 로직
			//뒤쪽 데이터 값이 더 작아서 선택되면, swap이 일어났다고 가정하고, 
			//현재 남아있는 앞쪽 데이터 갯수 만큼 결과갑을 더한다.
			if(tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
				result = result + index2 -k; //뒤쪽 데이터 값이 작은 경우 result업데이
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
