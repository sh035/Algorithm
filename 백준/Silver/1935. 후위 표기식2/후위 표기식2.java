import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Double> stack = new Stack<>();

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String cal = st.nextToken();


        Double[] arr = new Double[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (char c : cal.toCharArray()) {
            if (c == '*' || c == '+' || c == '/' || c == '-') {
                if (!stack.isEmpty()) {
                    double val2 = stack.pop();
                    double val1 = stack.pop();
                    switch (c) {
                        case '*' -> stack.push(val1 * val2);
                        case '+' -> stack.push(val1 + val2);
                        case '-' -> stack.push(val1 - val2);
                        case '/' -> stack.push(val1 / val2);
                    }
                }
            } else {
                stack.push(arr[c - 'A']);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}