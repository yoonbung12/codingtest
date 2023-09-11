package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortMaxValue {

	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		// 버블소트 정렬구하기(1377번)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//데이터 개수(N), A(데이터 배열, 단 클래스를 데이터로 담는 배열)
		int N = Integer.parseInt(br.readLine());
		cData[] A = new cData[N]; 
		
		//for(N만큼 반복)
		for(int i = 0; i< N; i++) {
			A[i] = new cData( Integer.parseInt(br.readLine()), i);
		}
		
		Arrays.sort(A); //A 배열 정렬하기(O(nlogn)시간 복잡도
		int Max = 0;
		for(int i = 0; i < N; i++) {
			//A[i]의 정렬전 index - 정렬후 index 계산의 최댓값을 찾아 저장
			if(Max < A[i].index - i) {
				Max = A[i].index - i;
			}
		}
		System.out.println(Max + 1);		
	}

}

class cData implements Comparable<cData> {
	
	int value;
	int index;

	public cData(int value, int index) {
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(cData o) { //value기준 오름차순
		return this.value - o.value;
	}
	
}


