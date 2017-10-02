import static java.lang.Character.SPACE_SEPARATOR;


public class SumDoubleSpace {

    private static boolean isSpace(char c)
    {
        return Character.getType(c) == SPACE_SEPARATOR;
    }

    private static double parseDoubleSum(String base){
        int n = base.length(), i = 0;
        StringBuilder tempDouble = new StringBuilder();
        double sum = 0;
        while (i < n)
        {
            while(i < n && isSpace(base.charAt(i)))
                i++;
            while(i < n && !isSpace(base.charAt(i)))
                tempDouble.append(base.charAt(i++));
            if(tempDouble.length() != 0)
            {
                sum += Double.parseDouble(tempDouble.toString());
                tempDouble.setLength(0);
            }
        }
        return sum;
    }

    public static void main(String[] args){
        StringBuilder base = new StringBuilder();
        for(String arg: args)
            base.append(arg).append(" ");
        System.out.println(parseDoubleSum(base.toString()));
    }
}
