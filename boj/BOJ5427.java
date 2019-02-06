package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ5427 {

    private static char map[][];
    private static int x[] = {-1, 1, 0, 0};
    private static int y[] = {0, 0, -1, 1};
    private static boolean isEscaped;
    private static boolean[][] personVisited;
    private static boolean[][] fireVisited;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t > 0) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            map = new char[h][w];

            personVisited = new boolean[h][w];
            fireVisited = new boolean[h][w];
            isEscaped = false;

            Queue<Position> fire = new LinkedList<>();
            Queue<Position> person = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String s = sc.next();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '@') {
                        map[i][j] = '.';
                        person.add(new Position(i, j));
                    }
                    if (map[i][j] == '*') {
                        fire.add(new Position(i, j));
                    }
                }
            }

            int cnt = 0;
            while (true) {
                spreadFire(fire);
                if (spreadPerson(person)) {
                    cnt++;
                    if (isEscaped) break;
                } else {
                    break;
                }
            }
            if (isEscaped) {
                System.out.println(cnt);
            } else {
                System.out.println("IMPOSSIBLE");
            }
            t--;
        }
    }

    private static boolean spreadPerson(Queue<Position> person) {
        int currSize = person.size();
        boolean check = false;

        while (currSize > 0) {
            Position curr = person.poll();
            personVisited[curr.x][curr.y] = true;

            for (int i = 0; i < x.length; i++) {
                int nx = curr.x + x[i];
                int ny = curr.y + y[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                    check = true;
                    isEscaped = true;
                }
                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                    if (map[nx][ny] == '.' && !personVisited[nx][ny]) {
                        check = true;
                        personVisited[nx][ny] = true;
                        person.add(new Position(nx, ny));
                    }
                }
            }
            currSize--;
        }
        return check;
    }


    private static void spreadFire(Queue<Position> fire) {
        int currSize = fire.size();
        while (currSize > 0) {
            Position currFire = fire.poll();
            fireVisited[currFire.x][currFire.y] = true;
            for (int i = 0; i < x.length; i++) {
                int nx = currFire.x + x[i];
                int ny = currFire.y + y[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || fireVisited[nx][ny]) continue;

                if (map[nx][ny] == '.' || map[nx][ny] == '@') {
                    map[nx][ny] = '*';
                    fireVisited[nx][ny] = true;
                    fire.add(new Position(nx, ny));
                }
            }
            currSize--;
        }
    }

    static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
