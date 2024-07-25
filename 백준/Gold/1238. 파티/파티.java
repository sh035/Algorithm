import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, X, A, B, T, dist[], rDist[];
  static ArrayList<Node>[] nodes, rNodes;

  static class Node implements Comparable<Node> {

    int to, time;

    public Node(int to, int time) {
      this.to = to;
      this.time = time;
    }

    @Override
    public int compareTo(Node o) {
      return this.time - o.time;
    }
  }

  static void dijkstra(ArrayList<Node>[] nodes, int[] dist) {
    PriorityQueue<Node> pq = new PriorityQueue();
    pq.add(new Node(X, 0));
    dist[X] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      for (Node next : nodes[cur.to]) {
        if (dist[next.to] > dist[cur.to] + next.time) {
          dist[next.to] = dist[cur.to] + next.time;
          pq.add(new Node(next.to, dist[next.to]));
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    nodes = new ArrayList[N + 1];
    rNodes = new ArrayList[N + 1];
    dist = new int[N + 1];
    rDist = new int[N + 1];

    for (int i = 0; i <= N; i++) {
      nodes[i] = new ArrayList<>();
      rNodes[i] = new ArrayList<>();
    }

    Arrays.fill(dist, Integer.MAX_VALUE);
    Arrays.fill(rDist, Integer.MAX_VALUE);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      T = Integer.parseInt(st.nextToken());

      nodes[A].add(new Node(B, T));
      rNodes[B].add(new Node(A, T));
    }

    dijkstra(nodes, dist);
    dijkstra(rNodes, rDist);

    int max = 0;
    for (int i = 1; i <= N; i++) {
      max = Math.max(max, dist[i] + rDist[i]);
    }

    System.out.println(max);
  }
}