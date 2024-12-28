import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] loc = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .map(i -> Math.abs(i - S))
            .toArray();

        int result = loc[0];

        for (int i = 1; i < N; i++) {
            result = gcd(result, loc[i]);
        }

        System.out.println(result);
    }
}