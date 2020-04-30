package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_스타일리쉬들여쓰기 {

	static int p, q;

	static int[][] info;

	private static int[][] dap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			// [i][0] = '.'의 수
			// [i][1] = a-b
			// [i][2] = c-d
			// [i][3] = e-f
			
			info = new int[p][4];
			dap = new int[q][4];
			
			
			// start masrter
			String str;
			
			for (int i = 0; i < p; i++) {
				str = br.readLine();
				int index = 0;
				while(str.charAt(index) == '.') {
					index++;
				}
				info[i][0] = index;
				
				if(i>0) {					
					info[i][1] = info[i-1][1];
					info[i][2] = info[i-1][2];
					info[i][3] = info[i-1][3];
				}
				for (int j = index; j < str.length(); j++) {
					switch (str.charAt(j)) {
					case '(':
						info[i][1]++;
						break;
					case ')':
						info[i][1]--;
						break;
					case '{':
						info[i][2]++;
						break;
					case '}':
						info[i][2]--;
						break;
					case '[':
						info[i][3]++;
						break;
					case ']':
						info[i][3]--;
						break;
					default:
						break;
					}
				}
			}// end master
			
			
			// start my
			for (int i = 0; i < q; i++) {
				str = br.readLine();
				
				if(i>0) {					
					dap[i][1] = dap[i-1][1];
					dap[i][2] = dap[i-1][2];
					dap[i][3] = dap[i-1][3];
				}
				
				for (int j = 0; j < str.length(); j++) {
					switch (str.charAt(j)) {
					case '(':
						dap[i][1]++;
						break;
					case ')':
						dap[i][1]--;
						break;
					case '{':
						dap[i][2]++;
						break;
					case '}':
						dap[i][2]--;
						break;
					case '[':
						dap[i][3]++;
						break;
					case ']':
						dap[i][3]--;
						break;
					default:
						break;
					}
				}
			}// end my
			
			for (int i = 0; i < q; i++) {
				dap[i][0] = -2;
			}

			for (int r = 1; r <= 20; r++) {
				for (int s = 1; s <= 20; s++) {
					for (int v = 1; v <= 20; v++) {
						if(check(r,s,v)) {
							calc(r,s,v);
						}
					}
				}
			}
			
			System.out.print("#"+t+" ");
			System.out.print("0"+" ");
			for (int i = 1; i < q; i++) {
				System.out.print(dap[i][0]+" ");
			}
			System.out.println();
		}

	}
	
	// 0과 -1둘다 유효한값이기에
	// dap[i][0]은 -2로초기화

	private static void calc(int r, int s, int v) {
		for (int i = 1; i < q; i++) {
			int dot = dap[i-1][1]*r + dap[i-1][2]*s + dap[i-1][3]*v;
			
			if(dap[i][0] == -2) {
				dap[i][0] = dot;
			}else if(dap[i][0] != dot){
				dap[i][0] = -1;
			}
			
		}
		
		
	}

	private static boolean check(int r, int s, int v) {
		
		for (int k = 1; k < p; k++) {
			int res = info[k-1][1]*r + info[k-1][2]*s +info[k-1][3]*v;
			if(res != info[k][0]) {
				return false;
			}
		}
		return true;
	}

}
