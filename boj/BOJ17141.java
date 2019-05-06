package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ17141 {

    private static int map[][];
    private static ArrayList<Coordinate> virusList = new ArrayList<>();
    private static ArrayList<Coordinate> selectedVirus = new ArrayList<>();
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, -1, 1};
    private static int result = 987654321;
    private static int M;
    private static int N;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    virusList.add(new Coordinate(i, j));
                }
            }
        }
        dfs(0);
        if (result == 987654321) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void dfs(int idx) {
        if (selectedVirus.size() == M) {
            int res = spreadVirus(selectedVirus);
            if (res != -1 && result > res) {
                result = res;
            }
        } else {
            for (int i = idx; i < virusList.size(); i++) {
                selectedVirus.add(virusList.get(i));
                dfs(i + 1);
                selectedVirus.remove(selectedVirus.size() - 1);
            }
        }
    }

    private static int spreadVirus(ArrayList<Coordinate> selectedVirus) {
        boolean isVisited[][] = new boolean[map.length][map.length];
        int level[][] = new int[map.length][map.length];
        int temp[][] = new int[map.length][map.length];
        Queue<Coordinate> queue = new LinkedList<>();

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (map[i][j] == 1) {
                    level[i][j] = -1;
                }
                temp[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < virusList.size(); i++) {
            int x = virusList.get(i).x;
            int y = virusList.get(i).y;
            temp[x][y] = 0;
        }

        for (int i = 0; i < selectedVirus.size(); i++) {
            int x = selectedVirus.get(i).x;
            int y = selectedVirus.get(i).y;
            isVisited[x][y] = true;
            queue.add(new Coordinate(x, y));
        }
        while (!queue.isEmpty()) {
            Coordinate virus = queue.poll();
            isVisited[virus.x][virus.y] = true;

            for (int i = 0; i < dx.length; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) continue;
                if (temp[nx][ny] == 1 || isVisited[nx][ny]) continue;

                level[nx][ny] = level[virus.x][virus.y] + 1;
                isVisited[nx][ny] = true;
                queue.add(new Coordinate(nx, ny));
            }
        }

        int cnt = 0;
        int max = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (level[i][j] == 0) {
                    cnt += 1;
                }
                if (level[i][j] > max) {
                    max = level[i][j];
                }
            }
        }
        if (cnt == selectedVirus.size()) {
            return max;
        } else {
            return -1;
        }
    }

    static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}