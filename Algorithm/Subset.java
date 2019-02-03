package Algorithm;

import java.util.ArrayList;

public class Subset {

    private static ArrayList list = new ArrayList();
    private static char arr[] = {'a', 'b', 'c', 'd'};

    public static void main(String args[]) {
        int n = arr.length;

        bitRepresentation(n, arr);
        search(0);
    }

    private static void bitRepresentation(int n, char[] arr) {
        System.out.println("make subset using bit mask");
        for (int i = 0; i < (1 << (n)); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void search(int k) {
        System.out.println("make subset using recursive method");
        if (k == arr.length) {
            for(int i=0; i<list.size(); i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println(" ");

        } else {
            search(k + 1);
            list.add(arr[k]);
            search(k + 1);
            list.remove(list.size() - 1);
        }
    }
}
