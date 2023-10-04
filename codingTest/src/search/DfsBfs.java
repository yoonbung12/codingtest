package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs {
	//A(그래프 데이터저장 인접 리스트), visited(방문기록 저장 배열)
	static boolean visited[];
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//노드의 개수N, 엣지 개수M, 시작점Start
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) { // 노드가 1부터 시작이니i = 1;
			//A 인접 리스트의 각 ArrayList초기화 하기
			A[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			//A인접리스트에 그래프 데이터 저장하기
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()); // S시작점
			int E = Integer.parseInt(st.nextToken()); // E 종료점
			A[S].add(E); //시작점에서 종료점으로도 갈수 있고
			A[E].add(S); //종료점에서 시작으로도 갈 수 있다.(방향이 안정해져 있어서 가능)
		}
		
		//방문할 수 있는 노드가 여러개일 경우에는 번호가 작은것부터방문
		for(int i = 1; i <= N; i++) {
			Collections.sort(A[i]); // 각 노드와 관련된 예제를 정렬할것
		}
		visited = new boolean[N + 1]; //방문 배열 초기화
		DFS(start);
		System.out.println();
		visited = new boolean[N + 1]; //방문 배열 초기화
		BFS(start);
				
	}

	private static void BFS(int Node) {
		//BFS구현
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node); //큐 자료구조에 시작 노드(add하기)
		visited[Node] = true; //visited배열에 현재 노드 방문 기록
		
		while(!queue.isEmpty()) { // 큐가 비어 있을때 까지 반복
			int now_Node = queue.poll(); //큐에서 노드 데이터 가져옴
			System.out.print(now_Node + " ");
			for(int i : A[now_Node]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
			
		}
	}

	private static void DFS(int Node) { //DFS구현
		System.out.print(Node + " "); //현재 노드 출력
		visited[Node] = true; //visited에 현재노드가 방문한거 기록
		for(int i : A[Node]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
		
		
	}
}
