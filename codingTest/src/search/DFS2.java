package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFS2 {
	
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//신기한 소수 찾기2023번
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		//DFS실행하기
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
		
		
	}

	//DFS(숫자, 자릿수)
	private static void DFS(int number, int jarisu) {
		if(jarisu == N) {
			if(isPrime(number)) {
				System.out.println(number);
			}
			return;
		}
		for(int i = 1; i < 10; i++) {
			if(i % 2 == 0) { //짝수라면 더이상 탐색할 필요가 없다.
				continue;
			}
			if(isPrime(number * 10 + i)) { //소수라면 재귀 함수로 자릿수를 늘린다.
				DFS(number * 10 + i, jarisu + 1);
			}
		}
		
	}

	 static boolean isPrime(int num) {
		for(int i =2; i <= num /2; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return false;

	}
	

}
