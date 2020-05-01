package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_역량_등산로 {
	
	static int N,K;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int res = 0;
	static ArrayList<Road> list;
	
	// 제일 높은 위치에서 시작.
	static class Road{
		int x;
		int y;
		int cnt;

		public Road(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			String[] line = br.readLine().split(" ");
			
			N = Integer.parseInt(line[0]);
			K = Integer.parseInt(line[1]);
			
			map = new int[N][N];
			res = Integer.MIN_VALUE;
			
			int hgst = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				line = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(line[j]);
					if(hgst < map[i][j]) {
						hgst = map[i][j];
					}
				}
			}// end input
			
			list = new ArrayList<Road>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(hgst == map[i][j]) {
						list.add(new Road(i,j,1));
					}
				}
			}// end input
			
			// 봉우리 하나를 깎고
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					int temp = map[i][j];
					
					for (int k = 0; k < K; k++) {
						map[i][j]--;
						// 최고 점에서 출발.
						move();
						if(map[i][j] == 0) {
							break;
						}
					}
					
					map[i][j] = temp;
				}
			}// end logic
			sb.append("#"+t+" "+res+"\n");
		}// end testcase
		System.out.println(sb);
	}// main
	
	private static void move() {
		for (int i = 0; i < list.size(); i++) {
			Road rd = list.get(i);
			
			Queue<Road> qu = new LinkedList<Road>();
			boolean[][] visited = new boolean[N][N];
			
			qu.add(rd);
			
			while(!qu.isEmpty()) {
				Road ths = qu.poll();
				int cnt = ths.cnt;
				
				if(cnt>res) {
					res = cnt;
				}
				
//				visited[ths.x][ths.y] = true;
				
				// 조건에 따라 이동
				for (int j = 0; j < 4; j++) {
					int nx = ths.x+dx[j];
					int ny = ths.y+dy[j];
					if( 0<= nx && nx<N && 0<=ny && ny<N) {
//						if(visited[nx][ny] == false) {
							if(map[ths.x][ths.y] > map[nx][ny]) {
								qu.add(new Road(nx,ny,cnt+1));
							}
//						}
					}
				}// end for
				
			}// end while
			
		}
	}

	static int[][] copyMap() {
		int[][] nmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				nmap[i][j] = map[i][j];
			}
		}
		return nmap;
	}

}
