package dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack2 {

	public static void main(String[] args) throws NumberFormatException, IOException  {
		// 오큰수 구하기(17298번)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N(수열 개수), A[](수열 배열), answer[](정답 배열		
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		int[] answer = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0); //처음에는 비어져 있으므로 최초 값을 push해서 초기화
		
		for(int i = 0; i < N; i++) {
			//스택이 NoEmpty, 현재 수열값 > top에 있는 수열보다 클때까지
			while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
				answer[stack.pop()] = A[i]; //오큰수 저장하기(정답 배열에)
				
			}
			stack.push(i); // 현재 수열을 스택에 넣기
		}
		while(!stack.isEmpty()) {
			//스택이 다 비워질때까지
			answer[stack.pop()] = -1;
		}
		for(int i =0; i < N; i++) {
			bw.write(answer[i] + " ");
		}
		bw.write("\n");
		bw.flush();
		
		
		
	}

}
