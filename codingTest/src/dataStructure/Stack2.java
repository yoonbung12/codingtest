package dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Stack2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 오큰수 구하기(17298번)
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// N(수열 개수), A[](수열 배열), ans[](정답 배열)
		int N = Integer.parseInt(bf.readLine());
		int A[]	 = new int[N];	//수열 배열 생성
		int ans[] = new int[N];	//정답 배열 생성
		String[] str = bf.readLine().split(" ");
		
		//for(N만큼 반복)
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(str[i]);
		}
		Stack<Integer> myStack = new Stack();
		myStack.push(0);	// 처음에는 항상 스택이 비어 있으므로 최초값을 push해 초기화
		for(int i = 0; i < N; i++) {
			// 스택이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
			while(!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
				ans[myStack.pop()] = A[i];	//정답 배열에 오큰수를 현재 수열로 저장하기
			}
			myStack.push(i);	// 신규 데이터 push
			
		}
		while(!myStack.empty()) {
			//반복문을 다 돌고 나왔는데 스택이 비어 있지 않다면 빌 때까지
			ans[myStack.pop()] = -1;
			//스택에 쌓인 index에 -1을 넣고
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < N; i++) {
			bw.write(ans[i] + " ");
			//출력한다
		}
		bw.write("\n");
		bw.flush();
	}

}
