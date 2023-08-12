package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoPointer {

	public static void main(String[] args) throws IOException {
		// 연속된 자연수의 합(빽2018)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());	
		//N변수 저장
//		int N = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());

		int count = 1;	//가지수
		int sum = 1;	//합
		// 투포인터 (startIndex,endIndex)
		int start_index = 1; 
		int end_index = 1;
		
		while(end_index != N) { //endindex가 N가 같아지지 않을때까지 반복
			if(sum == N	) {	//합이 N가 같은수가 나오면 count++해줌.
				count++;
				end_index++;
				sum = sum + end_index;
			} else if(sum > N) {
				sum = sum - start_index;
				start_index++;
			} else {
				end_index++;
				sum = sum + end_index;
				
			}
		}
		System.out.println(count);
		
		
		
	}

}
