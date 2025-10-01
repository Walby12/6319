package src.app;

import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.regex.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    String src = "";
    try {
      src = Files.readString(Path.of(args[0]));
      src = src.trim() + " ";
      List<String> tokens = new ArrayList<>();
      Pattern pattern = Pattern.compile("\\S+|\\n");
      Matcher matcher = pattern.matcher(src);

      while (matcher.find()) {
        tokens.add(matcher.group());
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    Lexer.Result r = Lexer.tokenize(src);
    Parser.parse(r);
  }
}
