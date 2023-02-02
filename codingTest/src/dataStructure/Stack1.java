package dataStructure;

import java.util.Scanner;
import java.util.Stack;

public class Stack1 {

	public static void main(String[] args) {
		// 스택 수열 1874번
		Scanner sc = new Scanner(System.in);
		//수열 개수N,A[](수열 배열)
		int N = sc.nextInt(); 
		int A[] = new int[N];
		
		//for(N만큼 반복)
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		//오름차순 자연수 num
		int num = 1;
		boolean result = true;
		StringBuffer bf = new StringBuffer();
		for(int i = 0; i < A.length; i++) {
			//수열에 있는 값
			int su = A[i];
			if(su >= num) {
				while(su >= num) {	//값이 같아질때까
					stack.push(num++);
					//출력
					bf.append("+\n");
				}
				//같아지면 빼냄
				stack.pop();
				bf.append("-\n");
			} else {
				int n = stack.pop();
				if(n > su	) {
					System.out.println("NO");
					result = false;
					break;
				} else {
					bf.append("-\n");
				}
			}
		}
		if(result) System.out.println(bf.toString());
	}

}
