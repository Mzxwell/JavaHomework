package ALU;
import org.jetbrains.annotations.NotNull;
public class Transformer {
    public static @NotNull String oneAdder(@NotNull String operand) {
        int len = operand.length();
        StringBuilder temp = new StringBuilder(operand);
        temp.reverse();
        int[] num = new int[len];
        for (int i = 0; i < len; i++) num[i] = temp.charAt(i) - '0';
        int bit;
        int carry = 0x1;
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            bit = num[i] ^ carry;
            carry = num[i] & carry;
            res[i] = (char) ('0' + bit);
        }
        String result = new StringBuffer(new String(res)).reverse().toString();
        return (result.charAt(0) == operand.charAt(0) ? '0' : '1') + result;
    }
    public static @NotNull String negation(@NotNull String operand) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < operand.length(); i++) {
            if (operand.charAt(i) == '1') {
                result.append("0");
            } else {
                result.append("1");
            }
        }
        return result.toString();
    }
}
