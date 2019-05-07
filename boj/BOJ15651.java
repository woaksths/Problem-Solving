package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15651 {

    private static ArrayList<Integer> list = new ArrayList<>();
    private static int N;
    private static int M;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            list.add(i);
            dfs();
            list.remove(list.size() - 1);
        }
    }

    private static void dfs() throws IOException {
        if (list.size() == M) {
            for(int i=0; i<list.size(); i++){
                bw.write(Integer.toString(list.get(i)) + " ");
            }
            bw.newLine();
            bw.flush();
        } else {
            for (int i = 1; i <= N; i++) {
                list.add(i);
                dfs();
                list.remove(list.size() - 1);
            }
        }
    }
}
