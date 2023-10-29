package ALU;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
public class DataType {
    public byte[] data = new byte[4];
    public DataType(@NotNull String dataStr) {
        int length = dataStr.length();
        if (length == 8 || length == 16 || length == 32) {
            dataStr = String.join("", Collections.nCopies(32 - length, "0")) + dataStr;
            for (int i = 0; i < 32; i++) {
                char temp = dataStr.charAt(i);
                if (temp == '0' || temp == '1') {
                    data[i / 8] |= (byte) ((dataStr.charAt(i) - '0') << (7 - i % 8));
                } else {
                    throw new NumberFormatException("Illegal dataStr: " + dataStr);
                }
            }
        } else {
            throw new NumberFormatException("Illegal dataStr: " + dataStr);
        }
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(fill32bit(Integer.toBinaryString(data[i])).substring(24));
        }
        return stringBuilder.toString();
    }
    public String fill32bit(String s){
        StringBuilder sb = new StringBuilder(s);
        if(s.length() < 32){
            int l = s.length();
            for(int i = 0;i < 32-l;i++){
                sb.insert(0,"0");
            }
        }
        return sb.toString();
    }
}