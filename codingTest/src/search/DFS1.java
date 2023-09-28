package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS1 {

	//유일하게 사용하기 때문에 static사용(솔직히 어디에 넣어도 문제가 없다본다.)
	static boolean visited[]; // visted[방문기록 저장 배열] ,
	//A[그래프 데이터 인접리스트]
	static ArrayList<Integer>[] A;

	public static void main(String[] args) throws IOException  {
		// 23번(11724번)DFS(깊이 우선 탐색- 스택or재귀함수(주로 많이 사용)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N(노드의 개수),M(에지의 개수)
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1]; //0번 인덱스부터 하면 헷갈리거 같아서 1부터 시작할려한다.
		A = new ArrayList[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			A[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < M; i++) {//인접리스트에담아야 해서 M을 쓴거다
			st = new StringTokenizer(br.readLine()); //데이터 받아야해서st 다시 선언
			int S = Integer.parseInt(st.nextToken()); //S는 시작점
			int E = Integer.parseInt(st.nextToken()); //E는 종료점
			A[S].add(E); //시작점에서 종료점으로 갈수도 있고
			A[E].add(S); // 종료점에서 시작점으로 갈수도 있다 (결국 방향이 안정해져 있어서 가능한거)
			
		}
		int count = 0;
		for(int i = 1; i < N + 1; i++) {
			if(!visited[i] ) { //방문하지 않은 상태이면
				count++;
				DFS(i);
			}
			
		}
		System.out.println(count);
		
	}

	//DFS구현 하기
	private static void DFS(int v) {
		// if(현재노드가 == 방문 노드이면 ) return;
		if(visited[v] ) { //방문노드이면 
			return;
		}
		visited[v] = true;
		for(int i : A[v]  ) { //현재 노드중 방문하지 않은 노드들 찾아야한다.
			if(!visited[i]) { //방문하지 않은 노드가 있다면 다시DFS실행해줘야한다.
				DFS(i); //재귀함수상태
			}
		}
		
	}

}
