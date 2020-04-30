package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_치즈도둑 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			max = Integer.MIN_VALUE;
			
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input
			
			int res = 0;
			
			// 1일째부터 100일까지.
			for (int d = 0; d <= 100; d++) {
				// 요정이 치즈를 먹는다.
				// 그 날짜와 같은 수의 맛있는 정도의 치즈를 먹는다.
				EatCheese(0,0,d);
				visited = new boolean[N][N];
				res = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// 요정이 하루씩 먹고 남은 치즈 중 덩어리가 가장 만을때를 찾는다.
						if(map[i][j] != 0 && visited[i][j] != true) {
							FindMass(i,j);
							res++;
						}
					}
				}
				
				visited = new boolean[N][N];
				if(max<res) {
					max = res;
				}
			}

			sb.append("#" + t + " " + max + "\n");
		} // end testcase

		System.out.println(sb);
	}// end main

	private static void FindMass(int x, int y) {
		
		if(x<0 || N<=x || y<0 || N<=y) {
			return;
		}

		if(visited[x][y] == true) {
			return;
		}
		
		if(map[x][y] == 0) {
			return;
		}
		
		visited[x][y] = true;
		
		
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			FindMass(nx,ny);
		}
	}

	private static void EatCheese(int x,int y,int day) {	
		
		if(x<0 || N<=x || y<0 || N<=y) {
			return;
		}

		if(visited[x][y] == true) {
			return;
		}
		
		
		visited[x][y] = true;
		
		if(map[x][y] == day) {
			map[x][y] = 0;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			EatCheese(nx,ny,day);
		}
	}

}
