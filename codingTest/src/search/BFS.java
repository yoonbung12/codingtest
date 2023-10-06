package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
	static int[] dx = {0, 1, 0, -1}; // 오른쪽 왼쪽(좌, 우)이동 
	static int[] dy = {1, 0, -1, 0}; // 위, 아래 (상, 하)이동 
	static boolean[][] visited; // 방문 저장 배열(2차원)
	static int[][] A;
	static int N, M;
	public static void main(String[] args) throws IOException  {
		//P2178 미로 탐색
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken(); //공백없이 한줄로 쭉 받기위해서!! 1010111
			for(int j =0; j < M; j++) {
				A[i][j]= Integer.parseInt(line.substring(j, j +1)); //substring 사용
				
			}
		}
		BFS(0,0);
		System.out.println(A[N - 1][M - 1 ]); // index가 0부터 해줘서 -1 을 해줘야함
		
	}
	private static void BFS(int i, int j) {
		Queue<int[] > queue = new LinkedList<>();
		queue.offer(new int[] {i, j}); //데이터 넣기
		while(!queue.isEmpty()) {
			int now[] = queue.poll(); //데이터 뽑기
			visited[i][j] = true;
			for(int k = 0; k < 4;  k++) {
				//상하좌우로 탐색
				int x = now[0] + dx[k];
				int y = now[1] + dx[k];
				if(x >= 0 && y >= 0 && x < N && y < M) {//유효성 검사, 배열을 넘어가면 안되고
					if(A[x][y] != 0 && !visited[x][y]) { //0 이어서 갈수 없거나, 방문했던 배열이면 안됨
						//이제 갈 수 있는 곳!!
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] + 1; //depth+1 해줄것  핵심 ******
						queue.add(new int[] {x, y}); //1차원으로 써야함
						
					}
					
				}
			}
		}
	}
	

}
