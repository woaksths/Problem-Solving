package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ9205 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            Position[] arr = new Position[n + 2];
            boolean[] visited = new boolean[n + 2];

            for (int i = 0; i < n + 2; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[i] = new Position(x, y);
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            visited[0] = true;

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                visited[curr] = true;

                if (curr == n + 1) break;

                for (int i = 0; i < arr.length; i++) {
                    if (!visited[i] && manhattanDis(arr[curr], arr[i]) <= 1000) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }

            if (!visited[n + 1]) {
                System.out.println("sad");
            } else {
                System.out.println("happy");
            }
            t--;
        }
    }

    private static int manhattanDis(Position curr, Position next) {
        return Math.abs(curr.x - next.x) + Math.abs(curr.y - next.y);
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
