import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class TimeConversionResult {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        if (s.contains("AM")) {
            s = s.replaceAll("AM", "");
            String[] split = s.split(":");

            if ("12".equals(split[0]))  {
                split[0] = "00";
            }

            return String.join(":", split);
        } else if (s.contains("PM")) {
            // get rid of the 'PM'
            s = s.replaceAll("PM", "");

            // get the first digit
            String[] split = s.split(":");
            int firstDigit = Integer.parseInt(split[0]);
            if (firstDigit < 12) {
                firstDigit += 12;
            }
            split[0] = String.valueOf(firstDigit);
            return String.join(":", split);
        }
        return s;
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        System.out.println(TimeConversionResult.timeConversion("07:05:45PM"));
        System.out.println(TimeConversionResult.timeConversion("07:05:45AM"));
        System.out.println(TimeConversionResult.timeConversion("12:05:45PM"));
        System.out.println(TimeConversionResult.timeConversion("12:05:45AM"));


    }
}
