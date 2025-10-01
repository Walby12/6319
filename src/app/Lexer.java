package src.app;

import java.util.ArrayList;

public class Lexer {
  public record Result(ArrayList<Tokens> toks, ArrayList<Int> ints) {}
  public static Result tokenize(String str) {
    ArrayList<Tokens> toks = new ArrayList<>();
    ArrayList<Int> ints = new ArrayList<>();
    int int_index = -1;
    int line = 1;
    String[] source = str.split(" ");

    for (int i = 0; i < source.length; i++) {
      String c = source[i];

      if (c.equals("push")) {
        toks.add(Tokens.PUSH);
      } else if (c.equals("pop")) {
        toks.add(Tokens.POP);
      } else if (c.equals("+")) {
        toks.add(Tokens.ADD);
      } else if (c.equals(".")) {
        toks.add(Tokens.DUMP);
      } else if (c.equals("\n")) {
        toks.add(Tokens.NEWLINE);
        line++;
      } else {
        try {
          Integer.parseInt(c);
          toks.add(Tokens.INT);
          int_index++;
          ints.add(new Int(int_index, c));

        } catch (NumberFormatException e) {
          System.out.printf("Unrecognized string: %s at line: %d\n", c, line);
          System.exit(1);
        }
      }
    }
    return new Result(toks, ints);
  }
}
