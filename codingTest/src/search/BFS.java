package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
	static int[] dx = {0,1,0,-1}; //상하좌우
	static int[] dy = {1,0,-1,0};
	static boolean[][] visited;	//방문배열
	static int[][] A;
	static int N;	//행
	static int M;	//열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();	//1011001 이런식으로 들어옴
			for(int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j + 1)); //j를 쓴 이유는 하나하나씩 잘라서 넣어줌
			}
		}
		BFS(0,0);
		System.out.println(A[N-1][M -1]);

	}
	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		while(!queue.isEmpty()) {//queue가 빌때까지 계속 돌림
			int now[]  = queue.poll();

			for(int k =0; k < 4; k++) {	//상하좌우로 탐색
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x >= 0 && y >= 0 && x < N && y < M ) {	//배열을 넘어가면 안되고
					if(A[x][y] != 0 && !visited[x][y]) { // 0이여서 갈수 없거나 기방문한 곳이면 안됨
						//이제 갈수 있는곳이다,
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] + 1; //핵심 - A배열에 depth를 현재노드의 depth +1로 업데이트 하기
						queue.add(new int[] {x, y});
						
					}
				}
				
			}
		}
		
	}

}
