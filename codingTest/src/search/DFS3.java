package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS3 {

	static boolean visited[]; // 방문기록 저장하는 배열
	static boolean arrive; // 도착확인 변수
	static ArrayList<Integer>[] A;
	

	public static void main(String[] args) throws IOException {
		// 친구관계 파악하기13023번
		arrive = false;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//n(노드개수),m(엣지 개수), A(그래프 데이터 저장 인접 리스트)
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			//A인접 리스트의 각 ArrayList초기화 하기
			A[i] = new ArrayList<Integer>();
			
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			A[S].add(E);
			A[E].add(S);
		}
		for(int i = 0; i< N; i++) {
			DFS(i, 1);	//depth 1부터 시작
			if(arrive)
				break;
		}
		if(arrive)
			System.out.println("1");
		else
			System.out.println("0");
		
		
		
			}


	private static void DFS(int now, int depth) { //DFS구현하기
		if(depth == 5 || arrive) { //depth가 5가되면 프로그램 종료
			arrive = true;
			return;
		}
		visited[now] = true;
		for(int i : A[now]) {
			if(!visited[i]) {
				DFS(i, depth + 1); //재귀 호출이 될때 마다 depth를 1씩 증가
				
			}
		}
		visited[now] = false;
		
	}

}
