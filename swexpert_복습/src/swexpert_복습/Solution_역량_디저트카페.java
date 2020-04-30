package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_역량_디저트카페 {

	static int[] dx = { -1, -1, 1, 1 };
	static int[] dy = { 1, -1, -1, 1 };

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] dessert;
	static int max;

	static int sx;
	static int sy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			max = Integer.MIN_VALUE;
			visited = new boolean[N][N];
			dessert = new boolean[101];

			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sx = i;
					sy = j;
					visited[sx][sy] = true;
					dessert[map[sx][sy]] = true;
					dfs(sx, sy, 0, 0);
					visited[sx][sy] = false;
					dessert[map[sx][sy]] = false;
				}
			}

			if (max == Integer.MIN_VALUE) {
				max = -1;
			}
			System.out.println("#" + t + " " + max);

		}

	}

	private static void dfs(int x, int y, int dir, int cnt) {

		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (!inner(nx, ny)) {
			return;
		}
		if (nx == sx && ny == sy && dir == 3) {
			if (max < cnt) {
				max = cnt + 1;
			}
			return;
		}
		if (visited[nx][ny] || dessert[map[nx][ny]]) {
			return;
		}
		visited[nx][ny] = true;
		dessert[map[nx][ny]] = true;

		if (dir < 3) {
			dfs(nx, ny, dir + 1, cnt + 1);
		}
		dfs(nx, ny, dir, cnt + 1);
		
		
		// 방문처리가 백트래킹을 위한것이라고 할 수 있다.
		// 백트래킹을 위한 방문처리 취소.
		visited[nx][ny] = false;
		dessert[map[nx][ny]] = false;
	}

	static boolean inner(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		} else {
			return false;
		}
	}

}
