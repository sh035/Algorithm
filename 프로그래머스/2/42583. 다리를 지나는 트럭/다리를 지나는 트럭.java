import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();

        IntStream.range(0, bridge_length - 1).forEach(i -> queue.offer(0));

        int curWeight = truck_weights[0];
        queue.offer(curWeight);

        int totTime = 1;
        int idx = 1;

        while(!queue.isEmpty()) {
            totTime++;

            int out = (int) queue.poll();
            curWeight -= out;

            if (idx < truck_weights.length) {
                if (curWeight + truck_weights[idx] <= weight) {
                    curWeight += truck_weights[idx];
                    queue.offer(truck_weights[idx]);
                    idx++;
                } else {
                    queue.offer(0);
                }
            }
        }

        return totTime;
    }
}