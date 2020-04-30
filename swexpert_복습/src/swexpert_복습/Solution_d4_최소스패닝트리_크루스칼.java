package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_d4_최소스패닝트리_크루스칼 {
	
	static class Edge{
		int s;
		int e;
		long weight;

		public Edge(int s, int e, long weight) {
			super();
			this.s = s;
			this.e = e;
			this.weight = weight;
		}
	}
	
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			String[] line = br.readLine().split(" ");
			
			int N = Integer.parseInt(line[0]);
			int E = Integer.parseInt(line[1]);
			
			ArrayList<Edge> list = new ArrayList<Edge>();
			
			for (int i = 0; i < E; i++) {
				line = br.readLine().split(" ");
				int ths = Integer.parseInt(line[0]);
				int tht = Integer.parseInt(line[1]);
				int weight = Integer.parseInt(line[2]);
				
				list.add(new Edge(ths,tht,weight));
			}
			
			Collections.sort(list,new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {
					if(o1.weight > o2.weight) {
						return 1;
					}else if(o1.weight == o2.weight) {
						return 0;
					}else {
						return -1;
					}
				}
				
			});
			
			long res = 0;
			parent = new int[N+1];
			for (int i = 1; i < N+1; i++) {
				parent[i] = i;
			}

			for (Edge edg : list) {
				int s = edg.s;
				int e = edg.e;
				long weight = edg.weight;
				
				if(union(s,e)) {
					res += weight;
				}
			}
			
			sb.append("#"+t+" "+res+"\n");
		}
		System.out.println(sb);
		
	}

	private static boolean union(int s, int e) {
		
		s = findRoot(s);
		e = findRoot(e);
		
		if(s != e) {
			parent[s] = e;
			return true;
		}
		
		return false;
	}

	private static int findRoot(int s) {
		if(parent[s] == s) {
			return s;
		}else {
			return parent[s] = findRoot(parent[s]);
		}
	}

}
