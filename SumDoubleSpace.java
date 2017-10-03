
public class SumDoubleSpace {

    private static boolean isSpace(char c) {
        return Character.getType(c) == Character.SPACE_SEPARATOR;
    }

    private static double parseDoubleSum(String base) {
        int n = base.length();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            while (i < n && isSpace(base.charAt(i))) {
                i++;
			}
			int begin = i;
            while(i < n && !isSpace(base.charAt(i))) {
                i++;
			}
			
            if (begin != i) {
                sum += Double.parseDouble(base.substring(begin, i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        StringBuilder base = new StringBuilder();
        for (String arg: args) {
            base.append(arg).append(" ");
		}
		System.out.println(parseDoubleSum(base.toString()));
    }
}
