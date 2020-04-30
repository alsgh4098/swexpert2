package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의_활주로 {
	
	static int N,X;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split(" ");
		
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}// end input
			
//			input test
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			
			int res = 0;
			
			for (int i = 0; i < N; i++) {
				if(xCheck(i)) {
					res++;
				}
				
				if(yCheck(i)) {
					res++;
				}
				
			}// end logic
			
			sb.append("#"+t+" "+res+"\n");
		}//end tc
		
		System.out.println(sb);
	}// end main

	private static boolean yCheck(int y) {
		if(sameY(y)) {
			return true;
		}
		
		boolean[] visited = new boolean[N];
		
		int high = 0;
		
		for (int i = 0; i < N-1; ) {
			if(Math.abs(map[i][y]-map[i+1][y]) > 1) {
				return false;
			}
			
			if( map[i][y] < map[i+1][y] ) {
				high = map[i][y];
				
				// 그 자리에 경사로가 이미 있을경우.
				if(visited[i]) {
					return false;
				}
				
				visited[i] = true;
				int cnt = 1;
				
				while(cnt != X) {
					i--;
					if(i<0) {
						return false;
					}else {
						if(map[i][y] == high) {
							if(visited[i]) {
								return false;
							}else {
								visited[i] = true;
								cnt++;
								continue;
							}
						}else {
							return false;
						}
					}
					
				}
				i += X;
				continue;
			}
			
			if(map[i][y] == map[i+1][y]) {
				i++;
				continue;
			}
			
			if( map[i][y] > map[i+1][y]) {
				i++;
				high = map[i][y];
				
				// 그 자리에 경사로가 이미 있을경우.
				if(visited[i]) {
					return false;
				}
				
				visited[i] = true;
				int cnt = 1;
				
				while(cnt != X) {
					i++;
					if(N<=i) {
						return false;
					}else {
						if(map[i][y] == high) {
							if(visited[i]) {
								return false;
							}else {
								visited[i] = true;
								cnt++;
								continue;
							}
						}else {
							return false;
						}
					}
				}
				continue;
			}
			
			
		}// end logic
		
		
		
		return true;
	}

	private static boolean xCheck(int x) {
		
		if(sameX(x)) {
			return true;
		}
		
		boolean[] visited = new boolean[N];
		
		int high = 0;
		
		for (int i = 0; i < N-1; ) {
			if(Math.abs(map[x][i]-map[x][i+1]) > 1) {
				return false;
			}
			
			if( map[x][i] < map[x][i+1] ) {
				high = map[x][i];
				
				// 그 자리에 경사로가 이미 있을경우.
				if(visited[i]) {
					return false;
				}
				
				visited[i] = true;
				int cnt = 1;
				
				while(cnt != X) {
					i--;
					if(i<0) {
						return false;
					}else {
						if(map[x][i] == high) {
							if(visited[i]) {
								return false;
							}else {
								visited[i] = true;
								cnt++;
								continue;
							}
						}else {
							return false;
						}
					}
					
				}
				i += X;
				continue;
			}
			
			if(map[x][i] == map[x][i+1]) {
				i++;
				continue;
			}
			
			if( map[x][i] > map[x][i+1]) {
				i++;
				high = map[x][i];
				
				// 그 자리에 경사로가 이미 있을경우.
				if(visited[i]) {
					return false;
				}
				
				visited[i] = true;
				int cnt = 1;
				
				while(cnt != X) {
					i++;
					if(N<=i) {
						return false;
					}else {
						if(map[x][i] == high) {
							if(visited[i]) {
								return false;
							}else {
								visited[i] = true;
								cnt++;
								continue;
							}
						}else {
							return false;
						}
					}
				}
				continue;
			}
			
			
		}// end logic
		
		
		return true;
	}

	private static boolean sameX(int x) {
		boolean check = true;
		int num = map[x][0];
		for (int j = 1; j < N; j++) {
			if(map[x][j] == num) {
				continue;
			}else {
				return false;
			}
		}
		
		return check;
	}
	
	private static boolean sameY(int y) {
		boolean check = true;
		int num = map[0][y];
		for (int j = 1; j < N; j++) {
			if(map[j][y] == num) {
				continue;
			}else {
				return false;
			}
		}
		
		return check;
	}
}
