package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Solution_역량_보물상자 {
	// 문제 똑바로 일ㄺ자
	static int N;
	static int K;
	static int len;
	static String str;
	static HashSet<String> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			String[] line = br.readLine().split(" ");
			set = new HashSet<String>();
			set.clear();
			// 문자 수
			N = Integer.parseInt(line[0]);
			// 회전 수 
			K = Integer.parseInt(line[1]);
			// 회전 수가 만자열 길이를 초과하면 중복되는 값들이 나오기 때문에 더 계산안해도 된다.
			
			str = br.readLine();
//			System.out.println(str.length());
			// 16진수 문자열 길이
			len = N/4;
			
			solve();
			
			ArrayList<Long> list = new ArrayList<Long>();
			for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
				long num = Long.parseLong(iter.next(),16);
//				System.out.println(iter.next());
				list.add(num);
//				System.out.println(num);
			}
//			System.out.println(list.size());
			Collections.sort(list);
			sb.append("#"+t+" "+list.get(list.size()-(K))+"\n");
			list.clear();
		}
		System.out.println(sb);
		
	}

	private static void solve() {
		
		// 회전 안한 상태에서
		for (int i = 0; i+len <= N; i += len) {
			set.add(str.substring(i,i+len));
		}
		
		for (int i = 1; i <= len; i++) {
			move();
//			System.out.println(str);
			for (int j = 0; j+len <= N; j += len) {
				set.add(str.substring(j,j+len));
			}
		}
	}

	private static void move() {
		char[] chr = str.toCharArray();
//		System.out.println(chr.length);
		char temp = chr[N-1];
		for (int i = N-1; i > 0; i--) {
			chr[i] = chr[i-1];
		}
		chr[0] = temp;
		
		String nstr = "";
		for (int i = 0; i < chr.length; i++) {
			nstr += chr[i];
		}
		str = nstr;
	}

}
