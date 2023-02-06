package sort;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		// 내림차순 정렬(1427번)
		Scanner sc = new Scanner(System.in); 
		// str(정렬할 수), A(자릿수 별로 구분해 저장한 배열)
		String str = sc.next(); 
		int A[] = new int[str.length()];
		
		//for(str의 길이만큼 반복,subString 사용
		for(int i = 0; i < str.length(); i++) {
			A[i] = Integer.parseInt(str.substring(i, i+1)) ;
		}
		
		//선택정렬
		for(int i = 0; i < str.length(); i++) {
			 // max값 정하기
			int Max = i;
			for(int j = i + 1; j < str.length(); j++) {
				if(A[j] > A[Max]) {// 내림차순이므로 최댓값을 찾는다.
					Max = j;
				}
				if(A[i] < A[Max] ) {
					// 임시변수temp
					int temp = A[i];
					A[i] = A[Max];
					A[Max] = temp;
				}
			}
		}		// -----선택정렬 끝
		
		for(int i = 0; i < str.length(); i++) {
			System.out.print(A[i]);
		}
	}

}
