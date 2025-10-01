package src.app;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
  public record Result(ArrayList<Tokens> toks, ArrayList<Int> ints) {}

  public static Result tokenize(String str) {
    ArrayList<Tokens> toks = new ArrayList<>();
    ArrayList<Int> ints = new ArrayList<>();
    int int_index = 0;
    int line = 1;

    str = str.replace("\r\n", "\n");

    Pattern pattern = Pattern.compile("\\S+|\\n");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
      String c = matcher.group();

      if (c.equals("\n")) {
        toks.add(Tokens.NEWLINE);
        line++;
      } else {
        switch (c) {
          case "push" -> toks.add(Tokens.PUSH);
          case "pop"  -> toks.add(Tokens.POP);
          case "+"    -> toks.add(Tokens.ADD);
          case "."    -> toks.add(Tokens.DUMP);
          case "eq"   -> toks.add(Tokens.EQUALS);
          case "if"   -> toks.add(Tokens.IF);
          case "end"   -> toks.add(Tokens.END);
          default -> {
            try {
              int n = Integer.parseInt(c);
              toks.add(Tokens.INT);
              ints.add(new Int(int_index++, n));
            } catch (NumberFormatException e) {
              System.out.printf("Unrecognized string: '%s' at line %d\n", c, line);
              System.exit(1);
            }
          }
        }
      }
    }
  return new Result(toks, ints);
  }
}
