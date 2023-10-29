package ALU;
import org.jetbrains.annotations.NotNull;
public class ALU {
    private void add(StringBuilder stringBuilder, String string) {
        boolean C = false, x, y;
        for (int i = 0, j = 31 - i; i < 32; j = 31 - (++i)) {
            x = stringBuilder.charAt(j) == '1';
            y = string.charAt(j) == '1';
            stringBuilder.setCharAt(j, x ^ y ^ C ? '1' : '0');
            C = (x && y) || (x && C) || (y && C);
        }
    }
    private @NotNull String invertAndAddOne(String s) {
        return Transformer.oneAdder(Transformer.negation(s)).substring(1);
    }
    public DataType mul(@NotNull DataType src, @NotNull DataType dest) {
        StringBuilder stringBuilder = new StringBuilder("00000000000000000000000000000000");
        String s = src + "0", d = dest.toString();
        boolean b;
        for (int i = 0; i < 32; i++) {
            if ((b = s.charAt(32 - i) == '0') ^ (s.charAt(31 - i) == '0'))
                add(stringBuilder, b ? invertAndAddOne(d) : d);
            stringBuilder.insert(0, stringBuilder.charAt(0));
        }
        return new DataType(stringBuilder.substring(32));
    }
    DataType remainderReg;
    public DataType div(@NotNull DataType src, @NotNull DataType dest) {
        boolean SrcLessThan0 = (src.data[0] & 0b10000000) != 0, DestLessThan0 = (dest.data[0] & 0b10000000) != 0;
        String zero = "00000000000000000000000000000000", s = SrcLessThan0 ? invertAndAddOne(src.toString()) : src.toString(), negativeSrc = invertAndAddOne(s);
        StringBuilder d = new StringBuilder(zero + (DestLessThan0 ? invertAndAddOne(dest.toString()) : dest)), builder = new StringBuilder();
        if (s.equals(zero)) throw new ArithmeticException();
        for (int i = 0; i <= 32; i++) {
            if (d.substring(0, 32).compareTo(s) >= 0) {
                add(d, negativeSrc);
                builder.append('1');
            } else builder.append('0');
            if(i!=32)d.deleteCharAt(0);
        }
        remainderReg=new DataType(DestLessThan0?invertAndAddOne(d.toString()):d.toString());
        zero=builder.substring(1);
        return new DataType(SrcLessThan0^DestLessThan0?invertAndAddOne(zero):zero);
    }
}