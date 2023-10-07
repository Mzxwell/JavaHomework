package src.main.java.util;

import static java.lang.Math.pow;

public class Transformer {
    static String[] strings = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1100", "1101"};
    static int toInt(String s){
        int a = 0,l=s.length()-1;
        for (int i = l; i >= 0; i--) a += s.charAt(i) == '0' ? 0 : 1 << (l - i);
        return a;
    }

    static int findIndex(String a) {
        int i = 0;
        while (!strings[i].equals(a)) i++;
        return i;
    }

    private static StringBuilder toBinary(int a) {
        StringBuilder builder = new StringBuilder();
        while (a > 0) {
            builder.insert(0, a % 2);
            a /= 2;
        }
        return builder;
    }
    private static StringBuilder ftoBinary(float a) {
        StringBuilder builder = new StringBuilder();
        while (a >= 1) {
            builder.insert(0, a % 2>=1?'1':'0');
            a /= 2;
        }
        return builder;
    }

    private static StringBuilder toBinary(float a) {
        StringBuilder builder = new StringBuilder();
        while (builder.length() < 149) {
            a *= 2;
            builder.append(a >= 1 ? '1' : '0');
            if (a >= 1) a--;
        }
        return builder;
    }

    private static float toFloat(String s){
        float f = 1;
        for(int i = 0;i<23;i++)f+= s.charAt(i)=='1'?(float) pow(2,-i-1):0;
        return f;
    }

    public static String intToBinary(String numStr) {
        int a = Integer.parseInt(numStr);
        boolean b = a < 0;
        if (b) a = -1 - a;
        StringBuilder builder = toBinary(a);
        while (builder.length() < 32) builder.insert(0, 0);
        if (b) for (int i = 0; i < 32; i++) builder.replace(i, i + 1, builder.charAt(i) == '0' ? "1" : "0");
        return builder.toString();
    }

    public static String binaryToInt(String binStr) {
        boolean b = binStr.charAt(0) == '1';
        if (b) {
            binStr = binStr.replace('0', '2');
            binStr = binStr.replace('1', '0');
            binStr = binStr.replace('2', '1');
        }
        int a = toInt(binStr.substring(1));
        if (b) a=-a-1;
        return String.valueOf(a);
    }

    public static String decimalToNBCD(String decimalStr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = decimalStr.length() - 1; i >= 0; i--) stringBuilder.insert(0, strings[decimalStr.charAt(i) - '0']);
        while (stringBuilder.length() < 28) stringBuilder.insert(0, "0000");
        stringBuilder.insert(0, decimalStr.charAt(0) == '-' ? "1101" : "1100");
        return stringBuilder.toString();
    }

    public static String NBCDToDecimal(String NBCDStr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (NBCDStr.startsWith("1101")) stringBuilder.append("-");
        int i = 4;
        while (NBCDStr.startsWith("0000", i)) i += 4;
        for (; i <= 28; i += 4) stringBuilder.append(findIndex(NBCDStr.substring(i, i + 4)));
        String s=stringBuilder.toString();
        return s.isEmpty() || s.equals("-") ?"0":s;
    }

    public static String floatToBinary(String floatStr) {
        if (Float.parseFloat(floatStr) > Float.MAX_VALUE) return "+Inf";
        if (Float.parseFloat(floatStr) < -Float.MAX_VALUE) return "-Inf";
        char c = floatStr.charAt(0) == '-' ? '1' : '0';
        if (floatStr.charAt(0) == '-') floatStr = floatStr.substring(1);
        float fl = Float.parseFloat(floatStr),f = (float) Math.floor(fl),l = fl - f;
        int E, zeros = 0;
        StringBuilder front = ftoBinary(f), latter = toBinary(l);
        while (zeros<latter.length()&&latter.charAt(zeros) == '0') zeros++;
        boolean fnz = f != 0;
        if(fl<pow(2,-126))E=0;
        else if (fnz) E = 126 + front.length();
        else if (l != 0) E = 126 - zeros;
        else E = 127;
        if (E == 0) front = latter;
        else {
            front.append(latter);
            while (front.charAt(0) != '1') front.deleteCharAt(0);
            front.deleteCharAt(0);
        }
        boolean flag=true;
        while (front.length() > 23) {
            if (front.charAt(0)!='0'||fnz)flag=false;
            front.deleteCharAt(flag?0:23);
        }
        while (front.length() < 23) front.append('0');
        StringBuilder Es = toBinary(E);
        while (Es.length() < 8) Es.insert(0, '0');
        return Es.append(front).insert(0, c).toString();
    }

    public static String binaryToFloat(String binStr) {
        float f=toFloat(binStr.substring(9));
        if(binStr.startsWith("00000000", 1)){
            f--;
            f=f*(float) pow(2,-126);
        }else f=f*(float) pow(2,toInt(binStr.substring(1,9))-127);
        if(binStr.charAt(0)=='1')f=-f;
        return String.valueOf(f);
    }

}
