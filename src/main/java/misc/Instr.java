package misc;

// mimic Oracle's INSTR function - validate chars in input against colors
public class Instr {
    private boolean setValidColor(String input, String colors) {
        for (int i = input.length() - 1; i >= 0; --i) {
            if (colors.indexOf(input.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Instr t = new Instr();
        //System.out.println(t.setValidColor("YZOR", "RGOPYB"));
        System.out.println(t.setValidColor("", ""));
    }
}
