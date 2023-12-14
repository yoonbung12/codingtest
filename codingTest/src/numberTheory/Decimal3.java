package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decimal3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 소수 팰린드롬 1747백준
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[100000001];
		for(int i = 2; i< A.length; i++) {
			A[i] = i;
		}
		for (int i =2; i< Math.sqrt(A.length); i++) { // 제곱근까지 수행하기
			if(A[i] == 0) {
				continue;
			}
			for(int j = i + i; j < A.length; j = j + i) { // 배수 지우기
				A[j] = 0;
				
			}
			
		}
		int i = N;
		while(true) { // N부터 1씩 증가시키면서 소수와 펠린드롬 수가 맞는지 확인하기
			if(A[i] != 0) {
				int result = A[i];
				if(isPalindrome(result)) {
					System.out.println(result);
					break;
				}
			}
			i++;
			
		}
		
	}
	private static boolean isPalindrome(int target) { // 펠린드롬 수 판별함
		char temp[] =String.valueOf(target).toCharArray();
		int s = 0;
		int e = temp.length -1;
		while(s <  e) {
			if(temp[s] != temp[e]) {
				return false;
			}
			s++;
			e--;
		}
		return true;
		
	}
	
}
