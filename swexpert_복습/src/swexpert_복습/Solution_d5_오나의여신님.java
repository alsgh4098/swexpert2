package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d5_오나의여신님 {
	
	static int N,M;
	
	static char[][] map;
	
	static Queue<Point> suyeon;
	static Queue<Point> devil;
	
	static int cnt;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static public class Point{
		int x;
		int y;
		int cnt;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public Point(int x, int y,int cnt) {
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
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			suyeon = new LinkedList<Point>();
			devil = new LinkedList<Point>();

			map = new char[N][M];
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == 'S') {
						suyeon.offer(new Point(i,j,0));
					}
					if(map[i][j] == '*') {
						devil.offer(new Point(i,j));
					}
				}
			}// end input
			
			int res = GameStart();
			sb.append("#"+t+" "+(res==-1?"GAME OVER":res)+"\n");
		}// end testcase
		System.out.println(sb);
	}// end main

	private static int GameStart() {
		while(!suyeon.isEmpty()) {
			int len = devil.size();
			
			for (int i = 0; i < len; i++) {
				Point dvl = devil.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = dvl.x + dx[j];
					int ny = dvl.y + dy[j];
					
					if(0<= nx && nx < N && 0<= ny && ny < M) {
						if(map[nx][ny] == 'S' || map[nx][ny] == '.') {
							map[nx][ny] = '*';
							devil.offer(new Point(nx,ny));
						}
					}
				}
			}// end devil move
			
			len = suyeon.size();
			
			for (int i = 0; i < len; i++) {
				Point syn = suyeon.poll();
				int cnt = syn.cnt;
				
				for (int j = 0; j < 4; j++) {
					int nx = syn.x + dx[j];
					int ny = syn.y + dy[j];
					
					if(0<= nx && nx < N && 0<= ny && ny < M) {
						if(map[nx][ny] == '.') {
							map[nx][ny] = 'S';
							suyeon.offer(new Point(nx,ny,cnt+1));
						}
						
						if(map[nx][ny] == 'D') {
							return (cnt+1);
						}
					}
				}
			}// end seyeon move
			
		}
		
		return -1;
	}

}
