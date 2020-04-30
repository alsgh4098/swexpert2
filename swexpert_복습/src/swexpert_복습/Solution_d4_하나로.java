package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// 크루스칼
// 거리공식
// 값출력 형식 double

public class Solution_d4_하나로 {
	
	static class Connect{
		int x;
		int y;
		double weight;
		
		public Connect(int x, int y, double weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
	}
	
	static double E;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] isle_x = new int[N];
			int[] isle_y = new int[N];
			ArrayList<Connect> list = new ArrayList<Connect>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				isle_x[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				isle_y[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					
					list.add(new Connect(i,j, (E * Math.pow(Math.sqrt(Math.pow(isle_x[i]-isle_x[j], 2) + Math.pow(isle_y[i]-isle_y[j], 2)), 2))));
				}
			}
			
			Collections.sort(list,new Comparator<Connect>() {
				@Override
				public int compare(Connect o1, Connect o2) {
					if(o1.weight > o2.weight) {
						return 1;
					}else if(o1.weight == o2.weight){
						return 0;
					}else {
						return -1;
					}
				}
			});
			
			parent = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
			
			double ans = 0;
			
			for (Connect c : list) {
				int x = c.x;
				int y = c.y;
				
				if(union(x,y)) {
					ans +=  c.weight;
				}
			}
			

			
			sb.append("#"+t+" "+Math.round(ans)+"\n");
			
		}
		
		System.out.println(sb);
	}// end main
	
	static int findRoot(int idx) {
		if(parent[idx] == idx) {
			return idx;
		}else {
			return parent[idx] = findRoot(parent[idx]);
		}
	}
	
	static boolean union(int idx1, int idx2) {
		
		idx1 = findRoot(idx1);
		idx2 = findRoot(idx2);
		
		if(idx1 != idx2) {
			parent[idx1] = idx2;
			return true;
		}
		
		return false;
	}

}