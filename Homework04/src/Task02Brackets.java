import java.util.ArrayDeque;
import java.util.Deque;

public class Task02Brackets {
    public static void main(String[] args) {
        String s = "(()())(())";            //output:  "()()()"
//        String s = "()()";                  //output: ""
//        String s = "((()())) () () (())";   //output: "()()()()()"
        cutter(s);


    }

    static void cutter(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append('"');
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                dq.push(c);
                System.out.println(c);
            } else {
                if (c == ')' && !dq.isEmpty() && count > 0) {
                    sb.append(dq.pop());
                    sb.append(c);
                }
                if (!dq.isEmpty()) {
                    dq.pop();
                }
            }
        }
        sb.append('"');
        System.out.println(sb);

    }

}
