import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sum {

    private static int parseString(String base)
    {
        int tmpSum = 0;
        Pattern pattern = Pattern.compile("(-|\\+)?\\d+");
        Matcher matcher = pattern.matcher(base);
        while(matcher.find())
            tmpSum += Integer.parseInt(matcher.group(0));
        return tmpSum;
    }

    public static void main(String[] args) {
        int sum = 0;
        for (String arg : args) {
            sum += parseString(arg);
        }
        System.out.println(sum);
    }
}
