package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DfsBfs {
	//A(그래프 데이터저장 인접 리스트), visited(방문기록 저장 배열)
	static boolean visited[];
	static ArrayList<Integer>[] A;
	public static void main(String[] args) {
	
		//노드의 개수N, 엣지 개수M, 시작점Start
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int Start = sc.nextInt();
		A = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
			
		}
		for(int i = 0; i < M; i++) {
			// S(처음점), E(끝점)
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
			A[E].add(S);
		}
		//번호가 작은 것을 먼저 방문하기 위해 정렬하기
		for(int i = 1; i <= N; i++) {
			Collections.sort(A[i]);
		}
		visited = new  boolean[N + 1];	//방문 배열 초기화 하기
		DFS(Start);
		System.out.println();
		visited = new boolean[N + 1];	//방문 배열 초기화 하기
		BFS(Start);
		System.out.println();
		
	}
	
	private static void DFS(int Node) { 	//DFS구현
		System.out.println(Node + " ");
		visited[Node] = true;
		for(int i : A[Node]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
		
	}
	private static void BFS(int Node) { //BFS구현
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node] = true;
		
		while(!queue.isEmpty()){
			int now_Node = queue.poll();
			System.out.println(now_Node + " ");
			for(int i : A[now_Node]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
	}
}
