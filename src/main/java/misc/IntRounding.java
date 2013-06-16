package misc;

// In the first example, the multiplication happens first, so division by totalSize
// gives you an int percentage value, which is what OP wants.
// (Multiplying before dividing is a way to avoid integer division giving a
// premature zero value.) The second does the same thing but adds half of
// totalSize to the numerator so that after the division, it's like having added
// 0.5 before taking the integer part of the result.
public class IntRounding {
    public static void main(String[] args) {
        int currentSize = 4079;
        int totalSize = 500802;
        int percentage1 = currentSize * 100 / totalSize;
        int percentage2 = (currentSize * 100 + (totalSize >> 1)) / totalSize;
        System.out.println(percentage1 + " " + percentage2);
    }
}
