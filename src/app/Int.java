package src.app;

public class Int {
  int index;
  String value;

  Int (int i, String v) {
    index = i;
    value = v;
  }
  public void show() {
    System.out.printf("Index: %d\nvalue: %s\n", index, value);
  }
}
