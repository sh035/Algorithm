import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 완전 탐색시 시간 초과
 * (정렬과 우선순위 큐 활용)
 *
 * 시작 시간을 기준으로 오름차순 정렬하지만 시작 시간이 같을 경우 마감 시간을 오름차순 정렬
 *
 * PriorityQueue 에 첫 수업의 마감시간을 add 해주고 아직 강의하지 않은 수업들의 시작 시간을 비교한다.
 * 강의중인 수업의 마감 시간 <= 강의하지 않은 수업의 시작 시간 ( poll )
 * 강의중인 수업의 마감 시간 > 강의하지 않은 수업의 시작 시간 ( add )
 */

public class Main {
    public static class Lesson implements Comparable<Lesson> {
        int start, end;

        public Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lesson o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }

            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Lesson[] arr = new Lesson[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            arr[i] = new Lesson(S, T);
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0].end);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i].start) {
                pq.poll();
            }

            pq.add(arr[i].end);
        }

        System.out.println(pq.size());

    }
}
