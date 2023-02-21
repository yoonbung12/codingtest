package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.sun.javafx.geom.Edge;

public class BFS2 {
	//트리의 지름1167
	//노드의 개수N, A 그래프 데이터 저장 인접 리스트
	//visited방문배열, distance거리 저장 배열
	static boolean visited[];
	static ArrayList< Edge>[] A;
	static int[] distance;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//노드 개수N
		A = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			A[i] = new ArrayList< Edge>();
		}
		
		for(int i = 0; i < N; i++) {	//A인접리스트에 그래프 데이터 저장하기
			int S = sc.nextInt();
			while(true) {
				int E = sc.nextInt();
				if(E == -1)
					break;
				int V = sc.nextInt();
				A[S].add(new Edge(E, V));
			}
		}
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		BFS(1);
		int Max = 1;
		for(int i = 2; i <= N; i++) {	//distance배열에서 가장 큰값으로 다시 시작점 설정
			if(distance[Max] < distance[i])
				Max = 1;
		}
		distance = new int[N + 1];
		visited = new boolean[N + 1];
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
					distance[e] = distance[now_node] + v;	//거리 배열 업데이트
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

}
