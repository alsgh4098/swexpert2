package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_역량_점심식사시간 {

	static int[][] map;
	static int N;

	static class People {
		int x;
		int y;
		int stair;
		int len;

		public People(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static class Stair {
		int x;
		int y;
		int val;

		public Stair(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	static int pcnt;
	static int scnt;
	static Stair[] sarr = null;
	static int min;
	static People[] parr = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			parr = new People[10];
			sarr = new Stair[2];

			pcnt = 0;
			scnt = 0;
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						// 사람 어레이
						parr[pcnt++] = new People(i, j);
					}
					if (map[i][j] > 1) {
						// 계단 어레이
						sarr[scnt++] = new Stair(i, j, map[i][j]);
					}
				}
			} // end input

			min = Integer.MAX_VALUE;
			dfs(0);
			sb.append("#" + t + " " + min + "\n");

		} // end tc
		System.out.println(sb);
	}

	private static void dfs(int cnt) {
		if (cnt == pcnt) {
			min = Math.min(min, calc());
			return;
		}

		parr[cnt].len = Math.abs(parr[cnt].x - sarr[0].x) + Math.abs(parr[cnt].y - sarr[0].y);
		parr[cnt].stair = 0;
		dfs(cnt + 1);
		parr[cnt].len = Math.abs(parr[cnt].x - sarr[1].x) + Math.abs(parr[cnt].y - sarr[1].y);
		parr[cnt].stair = 1;
		dfs(cnt + 1);
	}

	private static int calc() {

		// 사람
		List<People> stair = new ArrayList<People>();

		// 첫번째 계단을 내려가고 있는 사람
		List<Integer> down1 = new ArrayList<Integer>();
		// 두번째 계단을 내려가고 있는 사람
		List<Integer> down2 = new ArrayList<Integer>();

		for (int i = 0; i < pcnt; i++) {
			stair.add(parr[i]);
		}

		int time = 0;
		int downcnt = 0;

		while (downcnt != pcnt) {

			time++;


			for (Iterator<Integer> iter = down1.iterator(); iter.hasNext();) {
				Integer depth = iter.next();
				if (depth <= time) {
					iter.remove();
					downcnt++;
				}
			}

			for (Iterator<Integer> iter = down2.iterator(); iter.hasNext();) {
				Integer depth = iter.next();
				if (depth <= time) {
					iter.remove();
					downcnt++;
				}
			}

			for (Iterator<People> iter = stair.iterator(); iter.hasNext();) {
				People ppl = iter.next();
				if (ppl.stair == 1) {
					if (ppl.len + 1 <= time && down1.size() < 3) {
						down1.add(time + sarr[ppl.stair].val);
						iter.remove();
					}
				} else {
					if (ppl.len + 1 <= time && down2.size() < 3) {
						down2.add(time + sarr[ppl.stair].val);
						iter.remove();
					}
				}
				
			}

		} // end while
		return time;
	}// end method

}
