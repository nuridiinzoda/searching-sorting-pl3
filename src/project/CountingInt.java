package project;

public class CountingInt implements Comparable<CountingInt> {
    public static long comparisonCount = 0;
    private final int value;

    public CountingInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(CountingInt other) {
        comparisonCount++;
        return Integer.compare(this.value, other.value);
    }

    public static void resetCounter() {
        comparisonCount = 0;
    }
}
