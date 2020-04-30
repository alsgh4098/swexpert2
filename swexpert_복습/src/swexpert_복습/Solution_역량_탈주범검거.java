package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_역량_탈주범검거 {

	static class people {
		int x;
		int y;

		public people(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] line = br.readLine().split(" ");

			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
			int X = Integer.parseInt(line[2]);
			int Y = Integer.parseInt(line[3]);
			int L = Integer.parseInt(line[4]);

			int[][] map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				String line2 = br.readLine().replace(" ", "");
				for (int j = 0; j < M; j++) {
					map[i][j] = line2.charAt(j) - '0';
				}
			} // end input
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			} // print

			Queue<people> q = new LinkedList<people>();

			q.add(new people(X, Y));

			int time = L;

			while (time != 0) {

				int len = q.size();
				for (int i = 0; i < len; i++) {
					people ppl = q.poll();

					int x = ppl.x;
					int y = ppl.y;
					visited[x][y] = true;

					if (map[x][y] == 1) {
						// 상 우 하 좌
						// 상 
						int nx = x + dx[0];
						int ny = y + dy[0];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 3 && map[nx][ny] != 4 && map[nx][ny] != 7 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
						// 하
						nx = x + dx[2];
						ny = y + dy[2];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 3 && map[nx][ny] != 5 && map[nx][ny] != 6 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
						// 우
						nx = x + dx[1];
						ny = y + dy[1];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 2 && map[nx][ny] != 4 && map[nx][ny] != 5 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
						// 좌
						nx = x + dx[3];
						ny = y + dy[3];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 2 && map[nx][ny] != 6 && map[nx][ny] != 7 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
					} else if (map[x][y] == 2) {
						// 상 
						int nx = x + dx[0];
						int ny = y + dy[0];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 3 && map[nx][ny] != 4 && map[nx][ny] != 7 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
						// 하
						nx = x + dx[2];
						ny = y + dy[2];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 3 && map[nx][ny] != 5 && map[nx][ny] != 6 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
					} else if (map[x][y] == 3) {
						// 우
						int nx = x + dx[1];
						int ny = y + dy[1];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 2 && map[nx][ny] != 4 && map[nx][ny] != 5 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
						// 좌
						nx = x + dx[3];
						ny = y + dy[3];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 2 && map[nx][ny] != 6 && map[nx][ny] != 7 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
					} else if (map[x][y] == 4) {
						// 우
						int nx = x + dx[1];
						int ny = y + dy[1];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 2 && map[nx][ny] != 4 && map[nx][ny] != 5 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
						// 상
						nx = x + dx[0];
						ny = y + dy[0];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 3 && map[nx][ny] != 4 && map[nx][ny] != 7 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
					} else if (map[x][y] == 5) {
						// 우
						int nx = x + dx[1];
						int ny = y + dy[1];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 2 && map[nx][ny] != 4 && map[nx][ny] != 5 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
						// 하
						nx = x + dx[2];
						ny = y + dy[2];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 3 && map[nx][ny] != 5 && map[nx][ny] != 6 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
					} else if (map[x][y] == 6) {
						// 좌
						int nx = x + dx[3];
						int ny = y + dy[3];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 2 && map[nx][ny] != 6 && map[nx][ny] != 7 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
						// 하
						nx = x + dx[2];
						ny = y + dy[2];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 3 && map[nx][ny] != 5 && map[nx][ny] != 6 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
					} else if (map[x][y] == 7) {
						// 좌
						int nx = x + dx[3];
						int ny = y + dy[3];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 2 && map[nx][ny] != 6 && map[nx][ny] != 7 &&map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
						// 상
						nx = x + dx[0];
						ny = y + dy[0];
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] != 3 && map[nx][ny] != 4 && map[nx][ny] != 7 && map[nx][ny] != 0 && !visited[nx][ny]) {
								q.add(new people(nx, ny));
							}
						}
					}
				}
				time--;
			}// end while
			
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited[i][j]) {
						cnt++;
					}
				}
			}
			
			sb.append("#"+t+" "+cnt+"\n");

		} // end tc
		System.out.println(sb);
	}// end main

}
