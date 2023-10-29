package ALU;
public class main0 {
    public static void main(String[] args) {
        ALU alu = new ALU();
        int a = 33, b = 4;
        String as = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0'), bs = String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0');
        DataType ad = new DataType(as), bd = new DataType(bs);
        String m = alu.mul(ad, bd).toString(), d = alu.div(bd, ad).toString();
        a = Integer.parseInt(m, 2);
        b = Integer.parseInt(d, 2);
        System.out.println(as + '\n' + bs + '\n' + m + '\n' + d + '\n' + a + '\n' + b);
    }
}