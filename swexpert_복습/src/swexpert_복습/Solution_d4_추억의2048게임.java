package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d4_추억의2048게임 {
	
	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			String[] line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			map = new int[N][N];
			String sway = line[1];
			
			for (int i = 0; i < N; i++) {
				line = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}// end input
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}// test input
			
			int way = 0;
			
			if(sway.equals("up")) {
				way = 1;
			}else if(sway.equals("down")) {
				way = 2;				
			}else if(sway.equals("left")) {
				way = 3;
			}else if(sway.equals("right")) {
				way = 4;				
			}
			
			int[][] nmap = move(map,way);
			
			sb.append("#"+tc+" "+"\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(nmap[i][j]+" ");
				}
				sb.append("\n");
			}
			
//			test input
//			System.out.println(way);
			
		}// end testcase
		System.out.println(sb);
	}// end main
	
	private static int[][] move(int[][] nmap, int way) {
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = nmap[i][j];
			}
		}
		
		boolean[][] visited = null;
		
		int cx = 0;
		int cy = 0;
		int vx = 0;
		int vy = 0;
		
		// 상
		if(way == 1) {
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cx = j;
					cy = i;
					
					//0이면 뒤에 숫자들을 0으로 댕김
					if(map[cx][cy] == 0) {
						vx = j+1;
						vy = i;
						boolean find = false;
						while(vx < N) {
							if(map[vx][vy] != 0) {								
								find = true;
								break;
							}
							vx++;
						}
						if(find) {					
							map[cx][cy] = map[vx][vy];
							map[vx][vy] = 0;
							
							if(cx-1>=0) {
								if(map[cx-1][cy] == map[cx][cy] && visited[cx-1][cy] == false) {
									map[cx-1][cy]+=map[cx][cy];
									map[cx][cy] = 0;
									visited[cx-1][cy] = true;
									j--;
								}
							}
						}
					//0이 아니면 뒤에 숫자를 비교해서 합침
					}else {
						if(cx+1<N) {
							if(map[cx][cy] == map[cx+1][cy] && visited[cx][cy] == false) {
								map[cx][cy]+=map[cx+1][cy];
								map[cx+1][cy] = 0;
								visited[cx][cy] = true;
							}
						}
					}
				}
			}
		// 하
		}else if(way == 2) {
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >=0; j--) {
					cx = j;
					cy = i;
					
					//0이면 뒤에 숫자들을 0으로 댕김
					if(map[cx][cy] == 0) {
						vx = j-1;
						vy = i;
						boolean find = false;
						while(vx >= 0) {
							if(map[vx][vy] != 0) {								
								find = true;
								break;
							}
							vx--;
						}
						if(find) {							
							map[cx][cy] = map[vx][vy];
							map[vx][vy] = 0;
							
							if(cx+1<N) {
								if(map[cx+1][cy] == map[cx][cy] && visited[cx+1][cy] == false) {
									map[cx+1][cy]+=map[cx][cy];
									map[cx][cy] = 0;
									visited[cx+1][cy] = true;
									j++;
								}
							}
						}
					//0이 아니면 뒤에 숫자를 비교해서 합침
					}else {
						if(cx-1>=0) {
							if(map[cx][cy] == map[cx-1][cy] && visited[cx][cy] == false) {
								map[cx][cy]+=map[cx-1][cy];
								map[cx-1][cy] = 0;
								visited[cx][cy] = true;
							}
						}
					}
				}
			}
		// 좌	
		}else if(way == 3) {
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cx = i;
					cy = j;
					
					//0이면 뒤에 숫자들을 0으로 댕김
					if(map[cx][cy] == 0) {
						vx = i;
						vy = j+1;
						boolean find = false;
						while(vy < N) {
							if(map[vx][vy] != 0) {								
								find = true;
								break;
							}
							vy++;
						}
						if(find) {							
							map[cx][cy] = map[vx][vy];
							map[vx][vy] = 0;
							
							if(cy-1>=0) {
								if(map[cx][cy-1] == map[cx][cy] && visited[cx][cy-1] == false) {
									map[cx][cy-1]+=map[cx][cy];
									map[cx][cy] = 0;
									visited[cx][cy-1] = true;
									j--;
								}
							}
						}
					//0이 아니면 뒤에 숫자를 비교해서 합침
					}else {
						if(cy+1<N) {
							if(map[cx][cy] == map[cx][cy+1] && visited[cx][cy] == false) {
								map[cx][cy]+=map[cx][cy+1];
								map[cx][cy+1] = 0;
								visited[cx][cy] = true;
							}
						}
					}
				}
			}
		// 우
		}else if(way == 4) {
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >=0; j--) {
					cx = i;
					cy = j;
					
					//0이면 뒤에 숫자들을 0으로 댕김
					if(map[cx][cy] == 0) {
						vx = i;
						vy = j-1;
						boolean find = false;
						while(vy >= 0) {
							if(map[vx][vy] != 0) {								
								find = true;
								break;
							}
							vy--;
						}
						if(find) {							
							map[cx][cy] = map[vx][vy];
							map[vx][vy] = 0;
							
							if(cy+1<N) {
								if(map[cx][cy+1] == map[cx][cy] && visited[cx][cy+1] == false) {
									map[cx][cy+1]+=map[cx][cy];
									map[cx][cy] = 0;
									visited[cx][cy+1] = true;
									j++;
								}
							}
						}
					//0이 아니면 뒤에 숫자를 비교해서 합침
					}else {
						if(cy-1>=0) {
							if(map[cx][cy] == map[cx][cy-1] && visited[cx][cy] == false) {
								map[cx][cy]+=map[cx][cy-1];
								map[cx][cy-1] = 0;
								visited[cx][cy] = true;
							}
						}
					}
				}
			}
		}
		
		return map;
	}

}
