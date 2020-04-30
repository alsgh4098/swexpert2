package swexpert_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
 
public class Solution_점심식사시간 {
    static int T;
    static int N;
    static int[][] map = new int[10][10];
 
    static int human[][] = new int[10][2];
    static int stairs[][] = new int[2][3];
    static int go[] = new int[10];
 
    static int hCnt;
    static int sCnt;
    static int ans;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            hCnt = 0;
            sCnt = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        // hunman
                        human[hCnt][0] = i;
                        human[hCnt++][1] = j;
                    } else if (map[i][j] != 0) {
                        stairs[sCnt][0] = i;
                        stairs[sCnt][1] = j;
                        stairs[sCnt++][2] = map[i][j];
                    }
                }
            }  
            // 0~hCnt 까지 0번 계단을 갈지 1번계단을 갈지 선택
            ans = Integer.MAX_VALUE;
            dfs(0);
            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
 
    public static void dfs(int cnt) {
        if (cnt == hCnt) {
            // 답 계산하기
            ans = Math.min(ans, solve());
            return;
        }
 
        // 0번 문을 간다
        go[cnt] = 0;
        dfs(cnt + 1);
 
        // 1번문을 간다.
        go[cnt] = 1;
        dfs(cnt + 1);
    }
 
    static class Pair {
        int h;
        int dis;
 
        public Pair(int h, int dis) {
            super();
            this.h = h;
            this.dis = dis;
        }
    }
 
    public static int solve() {
        int time = 0;
        // 거리를 담는 list
        ArrayList<Pair> arr = new ArrayList<>();
 
        // arr에 i번사람과 go[i] ( 계단) 의 거리를 계산해서 리스트에 넣어준다.
        for (int i = 0; i < hCnt; i++) {
            arr.add(new Pair(i, getDis(i, go[i])));
        }
 
        // 현재 계단을 내려가고 있는 list
         
        ArrayList<Integer> downStairs[] = new ArrayList[2];
        downStairs[0] = new ArrayList<Integer>();
        downStairs[1] = new ArrayList<Integer>();
 
        int arrive = 0;
        while (arrive != hCnt) {
            time++;
            // 계단에서 내려서 도착할 사람을 찾는다.
            for (Iterator<Integer> it = downStairs[0].iterator(); it.hasNext();) {
                int cur = it.next();
                if (cur == time) {
                    // 계단에서 도착한사람!
                    it.remove();
                    arrive++;
                }
            }
             
            for (Iterator<Integer> it = downStairs[1].iterator(); it.hasNext();) {
                int cur = it.next();
                if (cur == time) {
                    // 계단에서 도착한사람!
                    it.remove();
                    arrive++;
                }
            }
 
            // arr 안에서 계단 대기할수 있는 사람을 찾는다.
            for (Iterator<Pair> it = arr.iterator(); it.hasNext();) {
                Pair cur = it.next();
                // 계단에 들어갈수 있다면
                if (cur.dis + 1 <= time && downStairs[go[cur.h]].size()<3) {
                    downStairs[go[cur.h]].add(time + stairs[go[cur.h]][2]);
                    it.remove();
                }
            }
 
        }
        return time;
    }
 
    public static int getDis(int h, int s) {
 
        return Math.abs(human[h][0] - stairs[s][0]) + Math.abs(human[h][1] - stairs[s][1]);
    }
}