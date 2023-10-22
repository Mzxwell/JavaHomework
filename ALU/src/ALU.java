public class ALU {
    public DataType add(DataType src, DataType dest) {
        String s = src.toString(), d = dest.toString();
        StringBuilder stringBuilder = new StringBuilder();
        boolean C = false, x, y;
        for (int i = 0, j = 31 - i; i < 32; j = 31 - (++i)) {
            x = s.charAt(j) == '1';
            y = d.charAt(j) == '1';
            stringBuilder.insert(0, x ^ y ^ C ? '1' : '0');
            C = (x && y) || (x && C) || (y && C);
        }
        return new DataType(stringBuilder.toString());
    }

    public DataType sub(DataType src, DataType dest) {
        return add(dest, add(src.not(), new DataType("00000000000000000000000000000001")));
    }
}