package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS1 {
	//A[그래프 데이터 인접리스트], visted[방문기록 저장 배열]
	static boolean visited[];//방문기록 저장 배열
	static ArrayList<Integer>[] A;// 그래프 데이터 인접 리스트
	public static void main(String[] args) throws IOException {
		// 23번(11724번)DFS(깊이 우선 탐색- 스택or재귀함수)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// n(노드의 개수), m(엣지 개수), 
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()); 
		visited = new boolean[n + 1];	// 배열에서 0번 인덱스 사용하면 헷갈리거 같아서 n +1로 함
		A = new ArrayList[n + 1];
		
		for(int i = 1; i < n+1; i++) {
			A[i] = new ArrayList<Integer>();	//인접리스트 초기화하기 
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());	//시작점(s) 끝점(e)
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);	//양방향 에지이므로 양쪽에 에지를 더하기
			A[e].add(s);
		}
		int count = 0;
		for(int i = 1; i < n+1; i++) {
			if(!visited[i]) {	//방문하지 않은 노드가 없을 때까지 반복하기
				count++;
				DFS(i); 
			}
		}
		System.out.println(count);
		

	}
	private static void DFS(int v) {
		
		if(visited[v] ) {
			return;
		}
		visited[v] = true;
		for(int i : A[v]) {	//현재 노드에 연결되어있는 노드들을 전부 탐색하면서 
			if(visited[i] == false) {	//연결 노드 중 방문하지 않았던 노드만 탐색하기 
				DFS(i);
			}
		}
		
		
	}

}
