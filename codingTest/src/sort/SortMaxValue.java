package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortMaxValue {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버블소트 정렬구하기(1377번)
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// N(데이터 개수), A[](데이터 배열, 단 클래스를 데이터롤 담는 배열
		int N = Integer.parseInt(reader.readLine());
		mData[] A = new mData[N];
		//for(N만큼 반복하기)
		for(int i = 0; i < N; i++) {
			A[i] = new mData(Integer.parseInt(reader.readLine()), i);
		}
		//A배열 정렬하기
		Arrays.sort(A);	//	A배열 정렬(O(nlogN)시간 복잡도
		int Max = 0;
		//for(N만큼 정렬하기)
		for(int i = 0; i < N; i++) {	//정렬전 index - 정렬후 index 계산의 최댓값 저장하기
			if(Max < A[i].index - i)
				Max = A[i].index - i;
		}
		System.out.println(Max + 1);
		
	}

}
//별도 클래스 선언
class mData implements Comparable<mData>{
	int value;
	int index;
	
	public mData(int value, int index) { //mData생성자 , 매개변수 생성
		super();
		this.value = value;
		this.index = index;
	}
	@Override
	public int compareTo(mData o) {
		return this.value - o.value;
		
	}
}
