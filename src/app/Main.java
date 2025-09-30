package src.app;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    String src = "push pop add";
    ArrayList<Tokens> toks = Lexer.tokenize(src);
    for (int i = 0; i < toks.size(); i++) {
      System.out.println(toks.get(i));
    }
  }
}
