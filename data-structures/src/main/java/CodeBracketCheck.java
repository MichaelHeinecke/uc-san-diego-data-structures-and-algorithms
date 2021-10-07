import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CodeBracketCheck {
    public static int checkIfBracketsAreBalanced(String s) {
        // returns 1-indexed position of first bracket mismatch or 0 if no mismatch is found
        Stack<Bracket> openingBrackets = new Stack<>();
        for (int position = 0; position < s.length(); position++) {
            char next = s.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                openingBrackets.push(new Bracket(next, position));
            } else if (next == ')' || next == ']' || next == '}') {
                if (openingBrackets.empty() || !openingBrackets.pop().match(next)) {
                    return ++position;
                }
            }
        }

        return openingBrackets.isEmpty() ? 0 : openingBrackets.peek().getPosition() + 1;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String text = bufferedReader.readLine();

        int result = checkIfBracketsAreBalanced(text);
        if (result == 0) {
            System.out.println("Success");
        } else {
            System.out.println(result);
        }

        bufferedReader.close();
        inputStreamReader.close();
    }

    static class Bracket {
        char type;
        int position;

        Bracket(char type, int position) {
            this.type = type;
            this.position = position;
        }

        public char getType() {
            return type;
        }

        public int getPosition() {
            return position;
        }

        boolean match(char c) {
            if (this.type == '[' && c == ']') {
                return true;
            } else if (this.type == '{' && c == '}') {
                return true;
            } else {
                return this.type == '(' && c == ')';
            }
        }
    }
}
