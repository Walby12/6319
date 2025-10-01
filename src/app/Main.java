package src.app;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    String src = "dump";
    Lexer.Result r = Lexer.tokenize(src);
    Parser.parse(r);
  }
}
