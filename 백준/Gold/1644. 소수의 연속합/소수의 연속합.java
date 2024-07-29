import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  static List<Integer> prime;
  static boolean[] isPrime;

  public static void makePrime(int N) {
    isPrime = new boolean[N + 1];
    prime = new ArrayList<>();

    isPrime[0] = true;
    isPrime[1] = true;

    for (int i = 2; i <= Math.sqrt(N); i++) {
      if (!isPrime[i]) {
        for (int j = i * i; j < isPrime.length; j = j + i) {
          isPrime[j] = true;
        }
      }
    }

    for (int i = 2; i <= N ; i++) {
      if (!isPrime[i]) {
        prime.add(i);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    makePrime(N);

    int start = 0;
    int end = 0;
    int sum = 0;
    int cnt = 0;

    while (true) {
      if (sum >= N) {
        sum -= prime.get(start++);
      } else if (end == prime.size()) {
        break;
      } else {
        sum += prime.get(end++);
      }
      if (N == sum) cnt++;
    }
    System.out.println(cnt);
  }
}