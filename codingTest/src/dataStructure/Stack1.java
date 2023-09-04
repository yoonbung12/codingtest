package dataStructure;

import java.io.*;
import java.util.Stack;

public class Stack1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 스택 수열 1874번
		//N(수열개수), A[](기본 배열)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		//오름 차순(자연수)
		int num = 1;
		boolean result = true;
		
		for(int i = 0; i < A.length; i++) {
			int su = A[i];	//현재 수열의 수
			//현재 수열값 >= 자연수
			if(su >= num) {
				while(su >= num) { //현재 수열값이 자연수랑 같아질 때까지 push()수행
					stack.push(num++);
					sb.append("+\n"); //append 는 (+)저장
					
				}
				stack.pop();
				sb.append("-\n"); //(-) 저장

			}
			else {			//현재 수열 값 < 오름차순 자연수:pop()을 수행해 수열값을 꺼냄
				int n = stack.pop();
				//스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력 불가능
				if(n > su) {
					System.out.println("NO");
					result = false;
					break;
				}
				else {
					sb.append("-\n");
				}
			}
		}
		if(result) System.out.println(sb.toString());
		
	}

}
