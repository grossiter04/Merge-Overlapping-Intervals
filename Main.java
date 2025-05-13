import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<int[]> mergeOverlap(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{arr[0][0], arr[0][1]});

        for (int i = 1; i < arr.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] curr = arr[i];

            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                res.add(new int[]{curr[0], curr[1]});
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número de intervalos: ");
        int n = scanner.nextInt();

        int[][] arr = new int[n][2];
        System.out.println("Insira os intervalos (formato: início fim):");
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        scanner.close();

        List<int[]> res = mergeOverlap(arr);

        System.out.println("\nIntervalos mesclados:");
        List<String> intervalosFormatados = new ArrayList<>();
        for (int[] intervalo : res) {
            intervalosFormatados.add(String.format("[%d, %d]", intervalo[0], intervalo[1]));
        }
        System.out.println(String.join(" ", intervalosFormatados));
    }
}