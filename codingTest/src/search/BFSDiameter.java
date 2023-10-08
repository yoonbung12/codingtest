package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSDiameter {
	//A(인접 리스트)ArrayList<edge>로 선언할것 
	static ArrayList< Edge>[] A;
	//visited(방문 기록 저장 배열), distance(거리 저장 배열)
	static boolean visited[];
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
		// p1167트리의 지름
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//노드의 개수 N
		int N = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			A[i]  = new ArrayList<Edge>(); //ArrayList초기화 하기
			
		}
		for(int i = 0; i < N; i++) { //A인접 리스트에 그래프 데이터 저장하기
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			while(true) {
				st = new StringTokenizer(br.readLine());
				int E = Integer.parseInt(st.nextToken());
				if(E == -1)
					break;
				int V = Integer.parseInt(st.nextToken());
				A[S].add(new Edge(E, V));
			}
			
		}
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		BFS(1);
		int Max = 1;
		for(int i = 2; i <= N; i++) { //distance배열에서 가장 큰 값으로 다시 시작점 설정
			if(distance[Max] < distance[i])
				Max = i;
		}
		
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		BFS(Max);	//새로운 시작점으로 실행
		Arrays.sort(distance);
		System.out.println(distance[N]);
			
		}
		
		

	private static void BFS(int index) { //BFS구현
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		visited[index] = true;
		while(!queue.isEmpty()) {
			int now_node = queue.poll();
			for(Edge i : A[now_node]) {
				int e = i.e;
				int v = i.value;
				if(!visited[e]) {
					visited[e] = true;
					queue.add(e);
					distance[e] = distance[now_node] + v; //거리 배열 업데이트 하기
				}
			}
		}
	
	}
}

class Edge {
	int e;
	int value;
	public Edge(int e, int value) {
		this.e = e;
		this.value = value;
	}
}
