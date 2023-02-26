package search;

//import java.util.ArrayList;
//import java.util.Scanner;
import java.util.*;

public class BFSDiameter {
	//A(인접 리스트), 
	//visited(방문 기록 저장 배열), distance(거리 저장 배열)
	static boolean visited[];
	static int[] distance;
	static ArrayList< Edge>[] A;
	
	public static void main(String[] args) {
		// p1167트리의 지름
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		//노드갯수(n),
		A = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {	//A의 인접 리스트의 각 ArrayList 초기화하기
			A[i] = new ArrayList< Edge>();
			
		}
		for(int i = 0; i < N; i++) {	//A 인접 리스트에 그래프 데이터 저장하기
			int S = sc.nextInt();
			while(true) {
				int E = sc.nextInt();
				if(E == -1)
					break;
				int V = sc.nextInt();
				A[S].add(new Edge(E, V));
			}
			
		}
		distance = new int[N + 1];	//배열 초기화 하기
		visited = new boolean[N + 1];//배열 초기화 하기

		BFS(1);	//임의의 시작점으로 실행
		int Max = 1;
		for(int i = 2; i <= N; i++) {	//distance 배열에서 가장 큰 값으로 다시 시작점 설정
			if(distance[Max] < distance[i])
				Max = i;
		}
		distance = new int[N + 1];//배열 초기화 하기
		visited = new boolean[N + 1];//배열 초기화 하기
		BFS(Max);	//새로운 시작점으로 실행
		Arrays.sort(distance);
		System.out.println(distance[N]);

	}

	private static void BFS(int index) {	//BFS구현
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

class Edge{
	int e;
	int value;
	public Edge(int e, int value) {
		this.e = e;
		this.value = value;
	}
}