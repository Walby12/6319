package src.app;

import java.util.ArrayList;

public class Parser {
  public static void parse(Lexer.Result r) {
    ArrayList<Integer> stack = new ArrayList<>();
    int line = 1;
    int index_int = 0;

    for (int i = 0; i < r.toks().size(); i++) {
      Tokens t  = r.toks().get(i);

      if (t == Tokens.PUSH) {
        Tokens t_r = peek_r(r, i);
        i++;
        if (!(t_r == Tokens.INT)) {
          System.out.printf("Error: Excpected an integer after the push op at tok %d at line %d but got: %s op\n", i + 1, line, t_r);
          System.exit(1);
        }
        int val = r.ints().get(index_int).getValue();
        stack.add(val);
        index_int++;
      } else if (t == Tokens.ADD) {
        if (stack.size() < 2) {
          System.out.printf("Error: the stack is not long enough for add op at tok: %d at line: %d\n", i + 1, line);
          System.exit(1);
        }
        int a = stack.remove(stack.size() - 1);
        int b = stack.remove(stack.size() - 1);
        stack.add(a + b);
      } else if (t == Tokens.DUMP) {
        for (int j = 0; j < stack.size(); j++) {
          System.out.printf("%d\n", stack.get(j));
        }
      } else if (t == Tokens.POP) {
        if (stack.size() < 1) {
          System.out.printf("Error: the stack is not long enough for pop op at tok: %d at line: %d\n", i + 1, line);
          System.exit(1);
        }
        System.out.println(stack.remove(stack.size() - 1));
      } else if (t == Tokens.EQUALS) {
        if (stack.size() < 2) {
          System.out.printf("Error: the stack is not long enough for equals op at tok: %d at line: %d\n", i + 1, line);
          System.exit(1);
        }
        int a = stack.remove(stack.size() - 1);
        int b = stack.remove(stack.size() - 1);
        stack.add(a == b ? 1 : 0);
      }
    }
  }
  static Tokens peek_r(Lexer.Result r, int i) {
    return r.toks().get(i + 1);
  }
}
