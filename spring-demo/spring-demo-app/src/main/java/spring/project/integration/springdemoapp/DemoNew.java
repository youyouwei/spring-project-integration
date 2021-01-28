package spring.project.integration.springdemoapp;

import com.google.common.base.Stopwatch;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:08 2021/1/23
 */
public class DemoNew {
    public static void main(String[] args) {

//        String result = add("12345", "789");
//        System.out.println(result);

        int count = 1000000;

        Stopwatch watch = Stopwatch.createStarted();
        for (int i = 0; i < count; i++) {
            add("12345", "789");
        }
        watch.stop();
        System.out.println(watch.elapsed());

        watch.start();
        for (int i = 0; i < count; i++) {
            new BigDecimal("12345").add(new BigDecimal("789"));
        }
        watch.stop();
        System.out.println(watch.elapsed());

    }

    public static String add(String s1, String s2) {
        try {
            if (StringUtils.isNotBlank(s1) && StringUtils.isNotBlank(s2)) {
                int len1 = s1.length();
                int len2 = s2.length();
                char[] char1 = s1.toCharArray();
                char[] char2 = s2.toCharArray();

                int len3 = len1 - len2;
                if (len3 >= 0) {
                    char[] result = new char[len1 + 1];
                    int tem = 0;
                    for (int i = len1 - 1, j = 0; i >= 0; i--, j++) {
                        int resultBit;
                        if (i - len3 >= 0) {
                            resultBit = toInt(char1[i]) + toInt(char2[i - len3]) + tem;
                        } else {
                            resultBit = toInt(char1[i]) + tem;
                        }
                        tem = resultBit / 10;
                        result[result.length - 1 - j] = toChar(resultBit % 10);
                    }
                    if (tem > 0) {
                        result[0] = toChar(tem);
                    }
                    return new String(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static char toChar(int i) {
        return (char) (i + 48);
    }

    private static int toInt(char c) {
        return c - 48;
    }
}
