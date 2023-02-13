package search;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS3 {

	static boolean visited[]; //방문 기록 배열
	static ArrayList<Integer>[]A; //인접리스트
	static boolean arrive; //도착 확인 변수

	
	public static void main(String[] args) {
		// 친구관계 파악하기13023번
		//n(노드개수),m(엣지 개수)
		int N;
		int M;
		arrive = false;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		A = new ArrayList[N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {	//A인접 리스트의 각 ArrayList초기화
			A[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M;) {	//각 노드마다 DFS실행
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
			A[E].add(S);
		}
		for(int i = 0; i < N; i++) {
			DFS(i, 1);	//depth 1부터 시작
			if(arrive)
				break;
		}
		if(arrive)
			System.out.println("1");
		else
			System.out.println("0"); // 5의 깊이가 없다면 0 출력
	}

	//DFS구현
	private static void DFS(int now, int depth) {
		if(depth == 5 || arrive) {	//depthrk 5가 되면 프로그램 종료
			arrive = true;
			return;
		}
		visited[now] = true;
		for(int i : A[now]) {
			if(!visited[i]) {
				DFS(i, depth + 1);	//재귀 호출이 될때마다 depth를 1씩 증가
			}
		}
		visited[now] = false;
	}

}
