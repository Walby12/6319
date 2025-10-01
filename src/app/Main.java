package src.app;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    String src = "push 10 push 20 add dump";
    Lexer.Result r = Lexer.tokenize(src);
    for (int i = 0; i < r.toks().size(); i++) {
      System.out.println(r.toks().get(i));
    }
    for (int j = 0; j < r.ints().size(); j++) {
      r.ints().get(j).show();
    }
  }
}
