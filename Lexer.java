package src.app;

import java.utils.ArrayList;

public enum Tokens {
  PUSH,
  POP,
  ADD,
  DUMP,
}

public class Lexer {
  public static ArrayList<Tokens> tokenize(String str) {
    ArrayList<Tokens> toks = new ArrayList<>();
    String[] source = src.split(" ");
    
    for (int i = 0; i < source.lenght(); i++) {
      System.out.println(source[i]);
    }

    return toks;
  }
}
