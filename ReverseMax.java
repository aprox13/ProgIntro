import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseMax {



    public static void main(String[] args)
    {
        int n = 0, m = 1;

        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            ArrayList<Integer> line = new ArrayList<>();
            Scanner currentLine = new Scanner(in.nextLine());
            while (currentLine.hasNextInt())
                line.add(currentLine.nextInt());
            if(m < line.size())
                m = line.size();
            rows.add(line);
            n++;
        }

        ArrayList<Integer> maxInRow = new ArrayList<>();
        ArrayList<Integer> maxInSt = new ArrayList<>();
        int max;
        for(int i = 0; i < rows.size(); i++) {
            max = Integer.MIN_VALUE;
            for(int j = 0; j < rows.get(i).size();j++)
                if(max < rows.get(i).get(j))
                    max = rows.get(i).get(j);
            maxInRow.add(max);
        }

        for(int i = 0; i < m; i++) {
            max = Integer.MIN_VALUE;
            for(int j = 0; j < n; j++){
                if(i < rows.get(j).size()) {
                    int tmp  = rows.get(j).get(i);
                    if( tmp > max)
                        max = tmp;
                }
            }
            maxInSt.add(max);
        }

        for(int i = 0; i < rows.size(); i++){
            for(int j = 0; j < rows.get(i).size(); j++)
                System.out.print(Math.max(maxInSt.get(j), maxInRow.get(i)) + " ");
            System.out.println();
        }
    }
}
