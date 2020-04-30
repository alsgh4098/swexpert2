package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_역량_특이한자석 {
	
	static int[][] magnets;
	static int[] mag1;
	static int[] mag2;
	static int[] mag3;
	static int[] mag4;
	
	static int[][] move;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			//회전수
			int K = Integer.parseInt(br.readLine());
			
			magnets = new int[5][];
			mag1 = new int[8];
			mag2 = new int[8];
			mag3 = new int[8];
			mag4 = new int[8];
			
			magnets[1] = mag1; 
			magnets[2] = mag2; 
			magnets[3] = mag3; 
			magnets[4] = mag4; 
			
			for (int i = 1; i <= 4; i++) {
				String line = br.readLine().replace(" ", "");
				for (int j = 0; j < 8; j++) {
					magnets[i][j] = line.charAt(j)-'0';
				}
			}
			
//			for (int i = 0; i < 4; i++) {
//				for (int j = 0; j < 8; j++) {
//					System.out.print(magnets[i][j]+" ");
//				}
//				System.out.println();
//			}// print
			
			
			
			// K번째에 0번은 돌릴 자석번호
			// K번째에 1번은 돌릴 방향
			// 1번 시계, -1 반시계
			move = new int[K][2];
			
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					move[i][j] = Integer.parseInt(st.nextToken());
				}
			}// end input
			
//			for (int i = 0; i < K; i++) {
//				for (int j = 0; j < 2; j++) {
//					System.out.print(move[i][j]+" ");
//				}
//				System.out.println();
//			}// print
			
			for (int i = 0; i < K; i++) {
				int magNum = move[i][0];
				int way = move[i][1];
//				System.out.println(way);
				int[] nMove = new int[5];
				nMove[magNum] = way;
				// 돌릴지 여부만 확인
				// 왼쪽
				for (int j = magNum; j > 1; j--) {
					boolean poss = possL(j,j-1);
					
					if(poss) {
						nMove[j-1] = -way;
						way = -way;
						continue;
					}else {
						break;
					}
				}
				
				
				way = move[i][1];
				
				// 오른쪽
				for (int j = magNum; j < 4; j++) {
					boolean poss = possR(j,j+1);
					
					if(poss) {
						nMove[j+1] = -way;
						way = -way;
						continue;
					}else {
						break;
					}
				}
				
				// 돌림
				for (int j = 1; j <= 4; j++) {
					int nway = nMove[j];
					move(j,nway);
				}
			}// end logic
			
			int res = 0;
			
			for (int i = 1; i <= 4; i++) {
//				System.out.println(magnets[i][0]);
				if(magnets[i][0] == 1) {
					res += Math.pow(2,i-1);
				}
			}
			sb.append("#"+t+" "+res+"\n");
		}// end tc
		System.out.println(sb);
	}// end main
	
	// 반시계
	static void move(int num, int way) {
		
		if(way == 1) {
			int temp = magnets[num][7];
			
			for (int i = 7; i > 0; i--) {
				magnets[num][i] = magnets[num][i-1];
			}
			
			magnets[num][0] = temp;
		}else if (way == -1){
			int temp = magnets[num][0];
			
			for (int i = 0; i < 7; i++) {
				magnets[num][i] = magnets[num][i+1];
			}
			
			magnets[num][7] = temp;
		}
		

	}
	
	// 왼쪽 방향 자석 돌아가는지 확인
	// num1이 자신
	// num2가 다음
	static boolean possL(int num1, int num2) {
		if(magnets[num1][6] == magnets[num2][2]) {
			return false;
		}
		
		return true;
	}
	
	// 오른쪽 방향 자석 돌아가는지 확인
	// num1이 자신
	// num2가 다음
	static boolean possR(int num1, int num2) {
		if(magnets[num1][2] == magnets[num2][6]) {
			return false;
		}
		
		return true;
	}

}
