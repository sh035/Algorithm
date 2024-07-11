import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        int[] distance = new int[V + 1];
        List<Edge>[] graph = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start] = 0;

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, weight));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (distance[cur.to] < cur.weight) {
                continue;
            }

            for (int i = 0; i < graph[cur.to].size(); i++) {
                Edge edge = graph[cur.to].get(i);
                int next = edge.to;
                int weight = edge.weight;

                if (distance[next] > distance[cur.to] + weight) {
                    distance[next] = distance[cur.to] + weight;
                    pq.add(new Edge(next, distance[next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }

        }
    }
}