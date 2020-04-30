package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import swexpert_복습.Solution_점심식사시간.Pair;

public class Solution_역량_점심식사시간 {

	static int[][] map;
	static int N;

	static class People {
		int x;
		int y;
		int time;
		int stair;
		int state;
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

		// 첫번째 계단을 택한 사람
		List<People> stair1 = new ArrayList<People>();
		// 두번째 계단을 택한 사람
		List<People> stair2 = new ArrayList<People>();

		// 첫번째 계단을 내려가고 있는 사람
		List<People> down1 = new ArrayList<People>();
		// 두번째 계단을 내려가고 있는 사람
		List<People> down2 = new ArrayList<People>();
		
		int pcnt1 = 0;
		int pcnt2 = 0;
		
		
		for (int i = 0; i < pcnt; i++) {
			if (parr[i].stair == 0) {
				stair1.add(parr[i]);
				pcnt1++;
			} else if (parr[i].stair == 1) {
				stair2.add(parr[i]);
				pcnt2++;
			}
		}

		// 계단과의 거리가 짧은순으로 사람들을 정렬.
		Collections.sort(stair1, new Comparator<People>() {
			@Override
			public int compare(People o1, People o2) {
				if (o1.len < o2.len) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		Collections.sort(stair2, new Comparator<People>() {
			@Override
			public int compare(People o1, People o2) {
				if (o1.len < o2.len) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		// 내려가는 중인 사람을 넣음.
		int cnt = 0;

		for (Iterator<People> iter = stair1.iterator(); iter.hasNext();) {
			People ppl = iter.next();
			down1.add(ppl);
			iter.remove();
			cnt++;
			if (cnt == 3) {
				break;
			}
		}

		cnt = 0;
		for (Iterator<People> iter = stair2.iterator(); iter.hasNext();) {
			People ppl = iter.next();
			down2.add(ppl);
			iter.remove();
			cnt++;
			if (cnt == 3) {
				break;
			}
		}

		int time1 = 0;
		int downcnt = 0;
		// 첫번째 계단에서
		while (true && pcnt1!=0) {
			boolean finish = false;
			time1++;
			for (Iterator<People> iter = down1.iterator(); iter.hasNext();) {
				People ppl = iter.next();
				if (ppl.len + 1 + sarr[0].val <= time1) {
					iter.remove();
					downcnt++;
					if(downcnt == pcnt1) {
						finish = true;
						break;
					}
				}
			}
			
			if(finish) {
				break;
			}


			for (Iterator<People> iter = stair1.iterator(); iter.hasNext();) {
				People ppl = iter.next();
				if (ppl.len + 1 <= time1 && down1.size() < 3) {
					down1.add(ppl);
					iter.remove();
				}
			}
		}

		int time2 = 0;
		downcnt = 0;
		// 두번째 계단에서
		while (true && pcnt2!=0) {
			boolean finish = false;
			time2++;
			for (Iterator<People> iter = down2.iterator(); iter.hasNext();) {
				People ppl = iter.next();
				if (ppl.len + 1 + sarr[1].val <= time2) {
					iter.remove();
					downcnt++;
					if(downcnt == pcnt2) {
						finish = true;
						break;
					}
				}
			}
			
			if(finish) {
				break;
			}


			for (Iterator<People> iter = stair2.iterator(); iter.hasNext();) {
				People ppl = iter.next();
				if (ppl.len + 1 <= time2 && down2.size() < 3) {
					down2.add(ppl);
					iter.remove();
				}
			}
			
		}

		return Math.max(time1, time2);
	}

}
