package dataStructure;

import java.util.Scanner;

public class NumberSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 입력값을 String형 변수 Snum에 저장한 후 char[]형 변수로 변환하기
		String sNum = sc.next();
		char[] cNum = sNum.toCharArray();
		
		int sum = 0;
		for(int i = 0; i < cNum.length; i++) {
			sNum += cNum[i] - '0';
		}
		System.out.println(sum);
		
		
	}
	
}
