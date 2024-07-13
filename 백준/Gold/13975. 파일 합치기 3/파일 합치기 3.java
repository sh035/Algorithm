import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            PriorityQueue<Long> pq = new PriorityQueue<>();

            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long total = 0;
            while (true) {
                if (pq.size() == 1) break;

                long temp1 = pq.poll();
                long temp2 = pq.poll();
                total += temp1 + temp2;

                pq.offer(temp1 + temp2);
            }
            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}
