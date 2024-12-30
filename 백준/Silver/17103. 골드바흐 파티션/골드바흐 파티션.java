import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static int[] isPrime(int n) {
        int[] primes = new int[n + 1];

        for (int i = 2; i < n; i++) {
            primes[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i] == 0) continue;

            for (int j = i * 2; j <= n; j += i) {
                primes[j] = 0;
            }
        }

        return primes;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] primes = isPrime(1_000_000);

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int start = 0, end = n, cnt = 0;

            for (int j = 0; j <= n / 2; j++) {
                if (primes[start] != 0 && primes[end] != 0) {
                    cnt++;
                }

                start++;
                end--;
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }
}