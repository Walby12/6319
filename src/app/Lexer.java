package src.app;

import java.util.ArrayList;

public class Lexer {
  public static ArrayList<Tokens> tokenize(String str) {
    ArrayList<Tokens> toks = new ArrayList<>();
    String[] source = str.split(" ");

    for (int i = 0; i < source.length; i++) {
      String c = source[i];

      switch (c) {
        case "pop":
          toks.add(Tokens.POP);
          break;
        case "push":
          toks.add(Tokens.PUSH);
          break;
        case "add":
          toks.add(Tokens.ADD);
          break;
        case "dump":
          toks.add(Tokens.DUMP);
          break;
      }
    }

    return toks;
  }
}
