package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_초콜릿과건포도 {
	
	static int[][] map;
	
	static int N;
	static int M;
	static int res;
	static int[][][][] memoi;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			memoi = new int[N+1][M+1][N+1][M+1];
			
			for (int[][][] m1 : memoi) {
				for (int[][] m2 : m1) {
					for (int[] m3 : m2) {
						 Arrays.fill(m3, Integer.MAX_VALUE);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			res = dfs(0,0,N,M);
			System.out.println("#"+t+" "+res);
		}
	}// end main
	
	static int dfs(int x,int y, int h, int w) {
		
		if(w==1 && h==1) {
			return 0;
		}
		
		if(memoi[x][y][h][w] != Integer.MAX_VALUE) {
			return memoi[x][y][h][w];
		}
		
		int sum = 0;
		
		for (int i = x; i < x+h; i++) {
			for (int j = y; j < y+w; j++) {
				sum += map[i][j];
			}
		}
		
		// 가로
		for (int i = 1; i < h; i++) {
			memoi[x][y][h][w] = Math.min(memoi[x][y][h][w], dfs(x,y,i,w) + dfs(x+i,y,h-i,w) + sum);
		}
		// 세로
		for (int i = 1; i < w; i++) {
			memoi[x][y][h][w] = Math.min(memoi[x][y][h][w], dfs(x,y,h,i) + dfs(x,y+i,h,w-i) + sum);
		}
		
		return memoi[x][y][h][w];
	}


}