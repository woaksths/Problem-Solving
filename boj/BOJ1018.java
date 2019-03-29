package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1018 {

    private static int dx[] = {1, 0};
    private static int dy[] = {0, 1};
    private static int result = Integer.MAX_VALUE;
    private static char map[][];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isPossibleSize(i, j)) {
                    chessBoard(i, j);
                }
            }
        }
        System.out.println(result);
    }

    private static void chessBoard(int row, int col) {
        char board[][] = new char[8][8];

        for (int start = 0, i = row; start < 8 && i <= row + 7; start++, i++) {
            for (int end = 0, j = col; end < 8 && j <= col + 7; end++, j++) {
                board[start][end] = map[i][j];
            }
        }
        char[][] tempB = new char[8][8];
        char[][] tempW = new char[8][8];
        for (int i = 0; i < tempB.length; i++)
            tempB[i] = Arrays.copyOf(board[i], board[i].length);

        for (int i = 0; i < tempW.length; i++)
            tempW[i] = Arrays.copyOf(board[i], board[i].length);

        int cntB = 0;
        if (tempB[0][0] == 'W') {
            tempB[0][0] = 'B';
            cntB = makeChessBoard(tempB) + 1;
        } else {
            cntB = makeChessBoard(tempB);
        }

        int cntW=0;
        if(tempW[0][0] =='B'){
            tempW[0][0] = 'W';
            cntW = makeChessBoard(tempW) +1;
        }else{
            cntW = makeChessBoard(tempW);
        }

        if (Math.min(cntB, cntW) < result) {
            result = Math.min(cntB, cntW);
        }
    }

    private static int makeChessBoard(char[][] board) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 8 || ny >= 8) continue;
                    if (board[i][j] == board[nx][ny]) {
                        if (board[i][j] == 'B') {
                            board[nx][ny] = 'W';
                        }
                        if (board[i][j] == 'W') {
                            board[nx][ny] = 'B';
                        }
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private static boolean isPossibleSize(int row, int col) {
        if (row + 7 >= map.length || col + 7 >= map[0].length)
            return false;
        return true;
    }
}