package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_d4_정식이의은행업무 {

	static long res;
	static ArrayList<Long> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			// 2진법 숫자
			char[] num2 = br.readLine().toCharArray();
			// 3진법 숫자
			char[] num3 = br.readLine().toCharArray();

			res = 0;
			list = new ArrayList<Long>();
			// 작은 자리수에서 부터 바꾼다.
			solve(num2,num2.length-1,2);
			solve(num3,num3.length-1,3);
//			System.out.println(res);
			sb.append("#"+t+" "+res+"\n");
//			System.out.println(Integer.parseInt(Integer.toString(res),2));
		} // end test case
		System.out.println(sb);
	}// end main

	private static boolean solve(char[] num, int idx, int way) {
		char[] nnum = num;
		
		if(idx<0) {
			return false;
		}
		
//		System.out.println(idx+" "+way);
		
		// 2진법
		if (way == 2) {
			if (idx != 0) {
				char temp = nnum[idx];
				
				if (nnum[idx] == '0') {
					nnum[idx] = '1';
				} else if (nnum[idx] == '1') {
					nnum[idx] = '0';
				}
				
				if (check(nnum,2)) {
					return true;
				}else {
					nnum[idx] = temp;
					if (solve(nnum, idx - 1, way)) {
						return true;
					}					
				}
			}else {
				if (nnum[idx] == '0') {
					nnum[idx] = '1';
				} else if (nnum[idx] == '1') {
					nnum[idx] = '0';
				}
				
				if (check(nnum,2)) {
					return true;
				}
			}
			// 3진법
		} else if (way == 3) {
			if (idx != 0) {
				char temp = nnum[idx];

				if (nnum[idx] == '0') {
					nnum[idx] = '1';
					if (check(nnum,3)) {
						return true;
					}else {
						nnum[idx] = temp;
						if (solve(nnum, idx - 1, way)) {
							return true;
						}					
					}
					nnum[idx] = '2';
					if (check(nnum,3)) {
						return true;
					}else {
						nnum[idx] = temp;
						if (solve(nnum, idx - 1, way)) {
							return true;
						}					
					}
				} else if (nnum[idx] == '1') {
					nnum[idx] = '2';
					if (check(nnum,3)) {
						return true;
					}else {
						nnum[idx] = temp;
						if (solve(nnum, idx - 1, way)) {
							return true;
						}					
					}
					nnum[idx] = '0';
					if (check(nnum,3)) {
						return true;
					}else {
						nnum[idx] = temp;
						if (solve(nnum, idx - 1, way)) {
							return true;
						}					
					}
				} else if (nnum[idx] == '2') {
					nnum[idx] = '0';
					if (check(nnum,3)) {
						return true;
					}else {
						nnum[idx] = temp;
						if (solve(nnum, idx - 1, way)) {
							return true;
						}					
					}
					nnum[idx] = '1';
					if (check(nnum,3)) {
						return true;
					}else {
						nnum[idx] = temp;
						if (solve(nnum, idx - 1, way)) {
							return true;
						}					
					}
				}
			} else {
				if (nnum[idx] == '1') {
					nnum[idx] = '0';
					if (check(nnum,3)) {
						return true;
					}
					nnum[idx] = '2';
					if (check(nnum,3)) {
						return true;
					}

				}else if (nnum[idx] == '2') {
					nnum[idx] = '0';
					if (check(nnum,3)) {
						return true;
					}
					nnum[idx] = '1';
					if (check(nnum,3)) {
						return true;
					}
					
				}else if (nnum[idx] == '0') {
					nnum[idx] = '1';
					if (check(nnum,3)) {
						return true;
					}
					nnum[idx] = '2';
					if (check(nnum,3)) {
						return true;
					}
				}
			}
		}

		return false;

	}

	static boolean check(char[] num,int way) {
		String strnum = "";
		for (int i = 0; i < num.length; i++) {
			strnum += num[i];
		}
		long val = Long.parseLong(strnum, way);
		if(way == 2) {
			list.add(val);
//			System.out.println(val+" "+way);
			return false;
		}else {
			if (list.contains(val)) {
				res = val;
//				System.out.println(val+" "+way);
				return true;
			}else {
//				System.out.println(val+" "+way);
				return false;
			}
		}
	}

}
