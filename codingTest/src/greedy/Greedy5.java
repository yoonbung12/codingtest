package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy5 {
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		// 최솟값을 만드는 괄호 배치 찾기-1541(백준)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ex = br.readLine();
		// '-'로 split해주기 
		String[] str = ex.split("-");
		
		// for(나눠진 데이터 개수만큼 반복하기)
		for(int i =0; i < str.length; i++) {
			int temp = mySum(str[i]);
			
			if(answer == 0) {
				answer += temp;
			} else {
				answer -= temp;
			}
		}
		System.out.println(answer);
	
		
	}
	private static int mySum(String a) {
		int sum = 0;
		// 더하기 끼리 묶어야함
		// 임시변수 tmep
		String[] temp = a.split("[+]");
		for(int i =0; i <  temp.length; i++ ) {
			// string 값을 int형태로 바꿔서 더할것
			sum = sum + Integer.parseInt(temp[i]);
		}
		return sum;
	}

}
