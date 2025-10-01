package src.app;

public class Int {
    int index;
    int value;

    public Int(int i, int v) {
        this.index = i;
        this.value = v;
    }

    public int getValue() {
        return value;
    }

    public void show() {
        System.out.printf("Index: %d, Value: %d\n", index, value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
