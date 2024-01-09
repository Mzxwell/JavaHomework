import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class float0 {
    public static void main(String[] args) {
        float f;
        Logger logger = LogManager.getLogger("float0");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("please enter a number: ");
        try {
            String s = br.readLine();
            f = Float.parseFloat(s);
            System.out.printf("%f\n", f);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        double number = Math.pow(2,-1000); // 要输出二进制表示的 double 数字
        long bits = Double.doubleToLongBits(number); // 将 double 转换为 long 型整数表示其二进制形式
        String binaryString = Long.toBinaryString(bits); // 将 long 型整数转换为二进制字符串
        System.out.println("Double " + number + " 的二进制表示为: " + binaryString);
    }
}
