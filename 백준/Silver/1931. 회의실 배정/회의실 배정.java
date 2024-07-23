import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    List<int[]> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
    }

    Collections.sort(list, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

    int n = 0;
    int end = 0;
    for (int[] arr : list) {
      if (arr[0] >= end) {
        end = arr[1];
        n++;
      }
    }

    System.out.println(n);
  }
}