package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ5014 {
    private static boolean visited[];
    private static int res = -1;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();

        visited = new boolean[F + 1];

        Queue<Elevator> queue = new LinkedList<>();
        queue.add(new Elevator(S, 0));

        while (!queue.isEmpty()) {
            Elevator currElevator = queue.poll();
            int currCnt = currElevator.cnt;
            int currFloor = currElevator.floor;
            visited[currFloor] = true;

            if (currFloor == G) {
                res = currCnt;
                break;
            }

            if(currFloor + U <= F && !visited[currFloor + U]){
                visited[currFloor + U]  =true;
                queue.add(new Elevator(currFloor+U, currCnt+1));
            }
            if(currFloor - D > 0 && !visited[currFloor -D]){
                visited[currFloor -D]  =true;
                queue.add(new Elevator(currFloor-D, currCnt+1));
            }
        }
        if (visited[G]) {
            System.out.println(res);
        }else{
            System.out.println("use the stairs");
        }
    }

    static class Elevator {
        private int floor;
        private int cnt;

        public Elevator(int floor, int cnt) {
            this.floor = floor;
            this.cnt = cnt;
        }
    }
}
